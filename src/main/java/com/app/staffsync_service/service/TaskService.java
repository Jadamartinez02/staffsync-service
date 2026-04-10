package com.app.staffsync_service.service;

import java.util.List;

import com.app.staffsync_service.dto.request.TaskRequest;
import com.app.staffsync_service.dto.response.TaskResponse;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
    TaskResponse getTaskById(Long id);
    List<TaskResponse> getAllTasks();
    List<TaskResponse> getTasksByEmployeeId(Long employeeId);
    TaskResponse updateTask(Long id, TaskRequest request);
    void deleteTask(Long id);
}
