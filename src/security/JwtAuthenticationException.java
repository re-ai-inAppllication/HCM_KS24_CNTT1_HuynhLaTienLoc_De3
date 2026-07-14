package security;



public class JwtAuthenticationException extends AuthenticationException {

    private final JwtErrorCode errorCode;

    public JwtAuthenticationException(JwtErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public JwtAuthenticationException(
            JwtErrorCode errorCode,
            Throwable cause
    ) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

    public JwtErrorCode getErrorCode() {
        return errorCode;
    }
}