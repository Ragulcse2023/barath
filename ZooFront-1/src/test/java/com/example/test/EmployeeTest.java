package com.example.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepo;


    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee(1, "John Doe", "Earth", "john.doe@example.com", "Developer");
        employeeService.save(employee);
        verify(employeeRepo, times(1)).save(employee);
    }

    @Test
    public void testEmployeeExists() {
        when(employeeRepo.findById(1)).thenReturn(Optional.of(new Employee()));
        assertTrue(employeeService.employeeExists(1));
    }

    @Test
    public void testEmployeeDoesNotExist() {
        when(employeeRepo.findById(1)).thenReturn(Optional.empty());
        assertFalse(employeeService.employeeExists(1));
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee(1, "John Doe", "Earth", "john.doe@example.com", "Developer");
        when(employeeRepo.findById(1)).thenReturn(Optional.of(employee));
        Employee found = employeeService.getEmployeeById(1);
        assertEquals(employee, found);
    }

    @Test
    public void testDeleteEmployeeById() {
        employeeService.deleteEmployeeById(1);
        verify(employeeRepo, times(1)).deleteById(1);
    }
}
