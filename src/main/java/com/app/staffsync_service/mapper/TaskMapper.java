package com.app.staffsync_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.staffsync_service.dto.request.TaskRequest;
import com.app.staffsync_service.dto.response.TaskResponse;
import com.app.staffsync_service.model.Employee;
import com.app.staffsync_service.model.Task;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", source = "employee")
    Task toEntity(TaskRequest request, Employee employee);

    @Mapping(target = "employeeId", source = "task.employee.id")
    @Mapping(target = "employeeFullName", expression = "java(task.getEmployee().getName() + \" \" + task.getEmployee().getLastName())")
    TaskResponse toResponse(Task task);
}
