package com.app.staffsync_service.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.staffsync_service.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByEmployeeId(Long employeeId, Pageable pageable);
}
