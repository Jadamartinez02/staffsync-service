package com.app.staffsync_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.staffsync_service.dto.request.EmployeeRequest;
import com.app.staffsync_service.dto.response.EmployeeResponse;
import com.app.staffsync_service.mapper.EmployeeMapper;
import com.app.staffsync_service.model.Employee;
import com.app.staffsync_service.repository.EmployeeRepository;
import com.app.staffsync_service.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        if (employeeRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        Employee employee = mapper.toEntity(request);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapper.toResponse(savedEmployee);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + id + " not found."));
        return mapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + id + " not found."));

        if (!existingEmployee.getEmail().equals(request.email()) && employeeRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email is already in use");
        }

        mapper.updateEntityFromRequest(request, existingEmployee);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return mapper.toResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + id + " not found."));
        employeeRepository.delete(existingEmployee);
    }

}
