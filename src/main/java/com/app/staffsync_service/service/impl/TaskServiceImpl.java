package com.app.staffsync_service.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.staffsync_service.dto.request.TaskRequest;
import com.app.staffsync_service.dto.response.TaskResponse;
import com.app.staffsync_service.mapper.TaskMapper;
import com.app.staffsync_service.model.Employee;
import com.app.staffsync_service.model.Task;
import com.app.staffsync_service.model.enums.StateTask;
import com.app.staffsync_service.repository.EmployeeRepository;
import com.app.staffsync_service.repository.TaskRepository;
import com.app.staffsync_service.service.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskMapper mapper;

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Employee employee = employeeRepository.findById(request.employeeId())
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + request.employeeId() + " not found."));

        Task task = mapper.toEntity(request, employee);
        task.setState(StateTask.valueOf(request.state().toUpperCase()));

        Task savedTask = taskRepository.save(task);
        return mapper.toResponse(savedTask);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID: " + id + " not found."));
        return mapper.toResponse(task);
    }

    @Override
    public Page<TaskResponse> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<TaskResponse> getTasksByEmployeeId(Long employeeId, Pageable pageable) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("Employee with ID: " + employeeId + " not found.");
        }
        return taskRepository.findByEmployeeId(employeeId, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID: " + id + " not found."));

        Employee employee = employeeRepository.findById(request.employeeId())
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + request.employeeId() + " not found."));

        existingTask.setQualification(request.qualification());
        existingTask.setDescription(request.description());
        existingTask.setState(StateTask.valueOf(request.state().toUpperCase()));
        existingTask.setExpirationDate(request.expirationDate());
        existingTask.setEmployee(employee);

        Task updatedTask = taskRepository.save(existingTask);
        return mapper.toResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID: " + id + " not found."));
        taskRepository.delete(existingTask);
    }
}
