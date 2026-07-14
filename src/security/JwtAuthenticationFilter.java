@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserDetailsService userDetailsService,
            JwtAuthenticationEntryPoint authenticationEntryPoint
    ) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            String token = extractToken(request);

            /*
             * Không có token thì tiếp tục filter chain.
             * Endpoint public vẫn hoạt động.
             *
             * Endpoint yêu cầu đăng nhập sẽ được Spring Security
             * trả về 401 thông qua AuthenticationEntryPoint.
             */
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                authenticateUser(token);
            }

            filterChain.doFilter(request, response);

        } catch (JwtAuthenticationException exception) {
            SecurityContextHolder.clearContext();

            authenticationEntryPoint.commence(
                    request,
                    response,
                    exception
            );
        }
    }

    private void authenticateUser(String token) {
        String username = jwtService.extractUsername(token);

        if (username == null || username.isBlank()) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.INVALID_JWT
            );
        }

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
    }

    private String extractToken(HttpServletRequest request) {
        String authorizationHeader =
                request.getHeader(AUTHORIZATION_HEADER);

        if (authorizationHeader == null
                || authorizationHeader.isBlank()) {
            return null;
        }

        if (!authorizationHeader.startsWith(BEARER_PREFIX)) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.MISSING_TOKEN
            );
        }

        String token = authorizationHeader.substring(
                BEARER_PREFIX.length()
        ).trim();

        if (token.isBlank()) {
            throw new JwtAuthenticationException(
                    JwtErrorCode.MISSING_TOKEN
            );
        }

        return token;
    }
}
