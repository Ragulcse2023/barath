package com.example.demo.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Habitat;
import com.example.demo.repository.HabitatRepository;



@Service
public class HabitatService {
	
	@Autowired
	private HabitatRepository habitatRepo;

	@Autowired
	private EmployeeService employeeService;
	
	public void save(Habitat h) {
		habitatRepo.save(h);
	}
//	public void saveById(Habitat h) {
//		habitatRepo.save(h);
//	}
	public boolean habitatExists(int id) {
	    return habitatRepo.findById(id).isPresent();
	}
	
	
	public List<Habitat> getAllHabitat(){
		return habitatRepo.findAll();
	}
	
	
	public Habitat getHabitatById(int id) {
		return habitatRepo.findById(id).get();
	}
	public void deleteHabitatById(int id) {
		habitatRepo.deleteById(id);
	}

	public void updateCleanliness(int id, String cleanliness) {
	    Optional<Habitat> optionalHabitat = habitatRepo.findById(id);
	    if (optionalHabitat.isPresent()) {
	        Habitat habitat = optionalHabitat.get();
	        habitat.setCleanliness(cleanliness);
	        habitatRepo.save(habitat);
	    }
	}
	
	// In your HabitatService class
	public Map<Integer, String> getHabitatEmployeeNames() {
	    List<Habitat> habitats = getAllHabitat();
	    Map<Integer, String> habitatEmployeeNames = new HashMap<>();
	    for (Habitat habitat : habitats) {
	        Optional<Employee> employeeOptional = employeeService.getEmployeeByIds(habitat.getEmployee_id());
	        if (employeeOptional.isPresent()) {
	            Employee employee = employeeOptional.get();
	            if (employee.getRole().equalsIgnoreCase("zookeeper")) {
	                habitatEmployeeNames.put(habitat.getId(), employee.getName());
	            } else {
	                habitatEmployeeNames.put(habitat.getId(), "No zookeeper assigned");
	            }
	        } else {
	            habitatEmployeeNames.put(habitat.getId(), "No zookeeper assigned");
	        }
	    }
	    return habitatEmployeeNames;
	}
	

	
	

}
