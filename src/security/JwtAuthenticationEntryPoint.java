package security;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public JwtAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException, ServletException {

        JwtErrorCode errorCode = determineErrorCode(exception);

        SecurityErrorResponse errorResponse = new SecurityErrorResponse(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                "UNAUTHORIZED",
                errorCode.name(),
                errorCode.getMessage(),
                request.getRequestURI()
        );

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }

    private JwtErrorCode determineErrorCode(
            AuthenticationException exception
    ) {
        if (exception instanceof JwtAuthenticationException jwtException) {
            return jwtException.getErrorCode();
        }

        return JwtErrorCode.INVALID_JWT;
    }
}
