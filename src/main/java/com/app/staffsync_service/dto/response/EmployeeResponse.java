package com.app.staffsync_service.dto.response;

import java.time.LocalDateTime;

public record EmployeeResponse(
    Long id,
    String name,
    String lastName,
    String email,
    String position,
    LocalDateTime creationDate
) {

}
