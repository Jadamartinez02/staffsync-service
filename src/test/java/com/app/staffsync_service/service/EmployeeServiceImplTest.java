package com.app.staffsync_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.staffsync_service.dto.request.EmployeeRequest;
import com.app.staffsync_service.dto.response.EmployeeResponse;
import com.app.staffsync_service.mapper.EmployeeMapper;
import com.app.staffsync_service.model.Employee;
import com.app.staffsync_service.repository.EmployeeRepository;
import com.app.staffsync_service.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeMapper mapper;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    // @Test
    // void createEmployee_Success(){
    //     // --- ARRANGE (PREPARAR LOS INGREDIENTES) ---
    //     // 1. Lo que manda el usuario
    //     EmployeeRequest request = new EmployeeRequest("Ana", "Gómez", "ana@test.com", "Dev");
        
    //     // 2. Lo que simularán los mappers y la base de datos
    //     Employee employeeEntity = Employee.builder().name("Ana").email("ana@test.com").build();
    //     Employee savedEntity = Employee.builder().id(1L).name("Ana").email("ana@test.com").build();
    //     EmployeeResponse expectedResponse = new EmployeeResponse(1L, "Ana", "Gómez", "ana@test.com", "Dev", LocalDateTime.now());

    //     // 3. ¡Las mentiras! (Cuando el servicio llame a esto, devuélvele aquello)
    //     when(employeeRepository.existsByEmail("ana@test.com")).thenReturn(false);
    //     when(mapper.toEntity(request)).thenReturn(employeeEntity);
    //     when(employeeRepository.save(employeeEntity)).thenReturn(savedEntity);
    //     when(mapper.toResponse(savedEntity)).thenReturn(expectedResponse);

    //     // --- ACT (EJECUTAR LA RECETA) ---
    //     EmployeeResponse actualResponse = employeeService.createEmployee(request);

    //     // --- ASSERT (VERIFICAR EL RESULTADO) ---
    //     assertNotNull(actualResponse); // Verificamos que no sea nulo
    //     assertEquals(1L, actualResponse.id()); // Verificamos que el ID sea el esperado
    //     assertEquals("Ana", actualResponse.name()); // Verificamos el nombre
        
    //     // Verificamos que el chef SÍ fue a la nevera a guardar exactamente 1 vez
    //     verify(employeeRepository, times(1)).save(any(Employee.class));
    // }
    @Test
    void createEmployee_DuplicateEmail_ThrowsException() {
        // --- ARRANGE ---
        EmployeeRequest request = new EmployeeRequest("Ana", "Gómez", "ana@test.com", "Dev");
        
        // ¡La mentira cambia! Ahora le decimos que el correo SÍ existe en la BD
        when(employeeRepository.existsByEmail("ana@test.com")).thenReturn(true);

        // --- ACT & ASSERT ---
        // Verificamos que el chef lance un error al ver el correo duplicado
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeService.createEmployee(request);
        });

        assertEquals("Email is already in use", exception.getMessage());
        
        // Verificamos que el chef NUNCA intentó guardar en la nevera
        verify(employeeRepository, never()).save(any());
    }
}
