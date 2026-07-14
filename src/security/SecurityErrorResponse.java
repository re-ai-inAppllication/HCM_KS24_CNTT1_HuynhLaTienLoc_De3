package security;

public record SecurityErrorResponse(

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime timestamp,

        int status,

        String error,

        String code,

        String message,

        String path
) {
}
