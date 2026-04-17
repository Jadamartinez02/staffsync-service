package com.app.staffsync_service.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.staffsync_service.dto.request.TaskRequest;
import com.app.staffsync_service.dto.response.TaskResponse;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
    TaskResponse getTaskById(Long id);
    Page<TaskResponse> getAllTasks(Pageable pageable);
    Page<TaskResponse> getTasksByEmployeeId(Long employeeId, Pageable pageable);
    TaskResponse updateTask(Long id, TaskRequest request);
    void deleteTask(Long id);
}
