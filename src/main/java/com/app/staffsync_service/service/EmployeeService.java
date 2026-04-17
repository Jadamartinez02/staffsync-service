package com.app.staffsync_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.staffsync_service.dto.request.EmployeeRequest;
import com.app.staffsync_service.dto.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(Long id);
    Page<EmployeeResponse> getAllEmployees(Pageable pageable);
    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
}
