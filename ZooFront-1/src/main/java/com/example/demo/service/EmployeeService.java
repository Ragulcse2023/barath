package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	public void save( Employee e) {
		employeeRepo.save(e);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public boolean employeeExists(int id) {
	    return employeeRepo.findById(id).isPresent();
	}
	
	
	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id).get();
	}
	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}
	public Optional<Employee> getEmployeeByIds(int id) {
	    return employeeRepo.findById(id);
	}
	
	public List<Employee> getVeterinarians() {
        return getAllEmployees()
            .stream()
            .filter(e -> "veterinarian".equalsIgnoreCase(e.getRole()))
            .collect(Collectors.toList());
    }
		
	public List<Employee> getZookeepers() {
        return getAllEmployees()
            .stream()
            .filter(e -> "Zookeeper".equalsIgnoreCase(e.getRole()))
            .collect(Collectors.toList());
    }	
	
}
