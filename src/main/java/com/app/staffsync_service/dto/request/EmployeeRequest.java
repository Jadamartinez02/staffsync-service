package com.app.staffsync_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeRequest(
    @NotBlank(message = "Name is required") 
    String name,
    
    @NotBlank(message = "Last name is required") 
    String lastName,
    
    @NotBlank(message = "Email is required") 
    @Email(message = "Email format is invalid") 
    String email,
    
    String position
) {

}
