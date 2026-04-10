package com.app.staffsync_service.service;

import java.util.List;


import com.app.staffsync_service.dto.request.EmployeeRequest;
import com.app.staffsync_service.dto.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(Long id);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
}
