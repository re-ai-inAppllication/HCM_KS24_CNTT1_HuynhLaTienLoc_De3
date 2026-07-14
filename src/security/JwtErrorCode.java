package com.rikkei.security.exception;

public enum JwtErrorCode {

    MISSING_TOKEN("JWT token is missing"),
    INVALID_JWT_SIGNATURE("JWT signature is invalid"),
    EXPIRED_JWT("JWT token has expired"),
    MALFORMED_JWT("JWT token is malformed"),
    UNSUPPORTED_JWT("JWT token is unsupported"),
    INVALID_JWT("JWT token is invalid");

    private final String message;

    JwtErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}