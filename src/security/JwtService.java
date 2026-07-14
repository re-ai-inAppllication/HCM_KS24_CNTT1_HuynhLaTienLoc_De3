
@Service
public class JwtService {

    private final SecretKey secretKey;

    public JwtService(
            @Value("${application.security.jwt.secret-key}")
            String secretKeyValue
    ) {
        if (secretKeyValue == null || secretKeyValue.length() < 32) {
            throw new IllegalStateException(
                    "JWT secret key must contain at least 32 characters"
            );
        }

        this.secretKey = Keys.hmacShaKeyFor(
                secretKeyValue.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Claims extractClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

        } catch (SignatureException exception) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.INVALID_JWT_SIGNATURE,
                    exception
            );

        } catch (ExpiredJwtException exception) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.EXPIRED_JWT,
                    exception
            );

        } catch (MalformedJwtException exception) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.MALFORMED_JWT,
                    exception
            );

        } catch (UnsupportedJwtException exception) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.UNSUPPORTED_JWT,
                    exception
            );

        } catch (IllegalArgumentException exception) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.INVALID_JWT,
                    exception
            );

        } catch (JwtException exception) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.INVALID_JWT,
                    exception
            );
        }
    }
}
