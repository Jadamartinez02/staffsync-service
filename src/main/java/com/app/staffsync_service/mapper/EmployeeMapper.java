package com.app.staffsync_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.app.staffsync_service.dto.request.EmployeeRequest;
import com.app.staffsync_service.dto.response.EmployeeResponse;
import com.app.staffsync_service.model.Employee;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequest request);
    EmployeeResponse toResponse(Employee employee);
    void updateEntityFromRequest(EmployeeRequest request, @MappingTarget Employee employee);

}
