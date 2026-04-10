package com.app.staffsync_service.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest(
    @NotBlank(message = "Qualification/Title is required") 
    String qualification,
    
    String description,
    
    @NotBlank(message = "State is required") 
    String state,
    
    LocalDateTime expirationDate,
    
    @NotNull(message = "Employee ID is required") 
    Long employeeId
) {

}
