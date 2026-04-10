package com.app.staffsync_service.dto.response;

import java.time.LocalDateTime;

public record TaskResponse(
    Long id,
    String qualification,
    String description,
    String state,
    LocalDateTime expirationDate,
    Long employeeId,
    String employeeFullName
) {

}
