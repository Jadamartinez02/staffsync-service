package com.app.staffsync_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.staffsync_service.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEmployeeId(Long employeeId);
}
