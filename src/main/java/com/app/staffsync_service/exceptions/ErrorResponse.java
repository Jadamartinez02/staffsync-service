package com.app.staffsync_service.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
    int status,
    String error,
    String message,
    LocalDateTime timestamp
) {

}
