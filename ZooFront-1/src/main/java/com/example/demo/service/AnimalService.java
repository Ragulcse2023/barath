package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AnimalRepository;

import jakarta.validation.Valid;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepo;
	@Autowired
	private EmployeeService employeeService;
	
	public void save(@Valid Animal a) {
		animalRepo.save(a);
	}
	
	public List<Animal> getAllAnimals(){
		return animalRepo.findAll();
	}
	
	
	public Animal getAnimalById(int id) {
		return animalRepo.findById(id).get();
	}
	public void deleteAnimalById(int id) {
		animalRepo.deleteById(id);
	}
	
	
	public boolean animalExists(int id) {
	    return animalRepo.findById(id).isPresent();
	}
	
	
	public void updateHealth(int id, String health) {
        Optional<Animal> optionalAnimal = animalRepo.findById(id);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.setHealth(health);
            animalRepo.save(animal);
        }
	}
	
	public Map<Integer, String> getAnimalCaretakerNames() {
	    List<Animal> animals = getAllAnimals();
	    Map<Integer, String> animalCaretakerNames = new HashMap<>();
	    for (Animal animal : animals) {
	        Optional<Employee> employeeOptional = employeeService.getEmployeeByIds(animal.getEmployee_id());
	        if (employeeOptional.isPresent()) {
	            Employee employee = employeeOptional.get();
	            if (employee.getRole().equalsIgnoreCase("veterinarian")) {
	                animalCaretakerNames.put(animal.getId(), employee.getName());
	            } else {
	                animalCaretakerNames.put(animal.getId(), "No veterinarian assigned");
	            }
	        } else {
	            animalCaretakerNames.put(animal.getId(), "No veterinarian assigned");
	        }
	    }
	    return animalCaretakerNames;
	}
}