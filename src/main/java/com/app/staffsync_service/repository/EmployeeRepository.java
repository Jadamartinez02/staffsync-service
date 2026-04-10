package com.app.staffsync_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.staffsync_service.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}
