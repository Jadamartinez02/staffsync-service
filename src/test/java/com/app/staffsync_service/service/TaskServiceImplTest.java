package com.app.staffsync_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.staffsync_service.dto.request.TaskRequest;
import com.app.staffsync_service.dto.response.TaskResponse;
import com.app.staffsync_service.mapper.TaskMapper;
import com.app.staffsync_service.model.Employee;
import com.app.staffsync_service.model.Task;
import com.app.staffsync_service.model.enums.StateTask;
import com.app.staffsync_service.repository.EmployeeRepository;
import com.app.staffsync_service.repository.TaskRepository;
import com.app.staffsync_service.service.impl.TaskServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {
    @Mock
    private TaskRepository taskRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private TaskMapper mapper;
    @InjectMocks
    private TaskServiceImpl taskService;

    // @Test
    // void createTask_Success(){
    //     LocalDateTime futureDate = LocalDateTime.now().plusDays(5);
    //     TaskRequest request = new TaskRequest("Aprender Mockito", "Hacer tests geniales", "PENDING", futureDate, 1L);
    //     Employee employee = Employee.builder().id(1L).name("Juan").lastName("Pérez").build();
    //     Task taskEntity = Task.builder().qualification("Aprender Mockito").state(StateTask.PENDING).build();
    //     Task savedTask = Task.builder().id(100L).qualification("Aprender Mockito").state(StateTask.PENDING).employee(employee).build();
        
    //     // TaskResponse expectedResponse = new TaskResponse(100L, "Aprender Mockito", "Hacer tests geniales", "PENDING", futureDate, 1L, "Juan Pérez");

    //     // Las mentiras estratégicas
    //     when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
    //     when(mapper.toEntity(request, employee)).thenReturn(taskEntity);
    //     when(taskRepository.save(taskEntity)).thenReturn(savedTask);
    //     when(mapper.toResponse(savedTask)).thenReturn(expectedResponse);

    //     // --- ACT ---
    //     TaskResponse actualResponse = taskService.createTask(request);

    //     // --- ASSERT ---
    //     assertNotNull(actualResponse);
    //     assertEquals(100L, actualResponse.id());
    //     assertEquals("Juan Pérez", actualResponse.employeeFullName()); // Verificamos el nombre mágico

    //     // Verificamos que el chef fue a la nevera de tareas a guardar exactamente 1 vez
    //     verify(taskRepository, times(1)).save(any(Task.class));
    // }
}
