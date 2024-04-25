package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Habitat;
import com.example.demo.service.AnimalService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.HabitatService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AnimalController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnimalController.class);

	@Autowired
	private AnimalService animalService;
	@Autowired
	private HabitatService habitatService;
	@Autowired
	private EmployeeService employeeService;

	
	

	@GetMapping("/AnimalView")
	public String AnimalView(Model model) {
		LOGGER.info("Handling /AnimalView request");
		List<Animal> animal = animalService.getAllAnimals();
		model.addAttribute("animal", animal);
		return "animal/AnimalView";
	}
@RequestMapping("/AddAnimal")
	public String AddAnimalView(Model model) {
		LOGGER.info("Handling /AddAnimal request");
		model.addAttribute("animal", new Animal());
		model.addAttribute("employee", employeeService.getVeterinarians());
		return "animal/AddAnimal";
	}

	@PostMapping("/newAnimalDetails")
	public String addAnimal(@Valid @ModelAttribute Animal animal, BindingResult result, Model model) {
		LOGGER.info("Handling /newAnimalDetails request with animal: {}", animal);
		if (result.hasErrors()) {
			model.addAttribute("animal", animal);
			model.addAttribute("employee", employeeService.getVeterinarians());
			return "animal/AddAnimal"; // return to the form page if there are errors
		}
		animalService.save(animal);
		return "redirect:/AnimalView";
	}

	@RequestMapping("/AnimalEditPage")
	public String AnimalEdit(Model model) {
		LOGGER.info("Handling /AnimalEditPage request");
		List<Animal> animal = animalService.getAllAnimals();
		model.addAttribute("animal", animal);
		return "animal/AnimalEditPage";
	}
	@PostMapping("/saveAnimal")
		public String saveAnimal(@Valid @ModelAttribute Animal a, BindingResult result,Model model) {
			LOGGER.info("Saving animal: {}", a);
			if (result.hasErrors()) {
				model.addAttribute("employee", employeeService.getVeterinarians());
				return "animal/EditAnimal"; 
			}
			animalService.save(a);
			return "redirect:/AnimalView";
		}
	@RequestMapping("/deleteAnimal/{id}")
	public String deleteAnimal(@PathVariable("id") int id, Model model) {
		LOGGER.info("Deleting animal with id {}", id);
		animalService.deleteAnimalById(id);
		return "redirect:/AnimalEditPage";
	}

	@RequestMapping("/editAnimal/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		LOGGER.info("Editing animal with id {}", id);
		model.addAttribute("animal", animalService.getAnimalById(id));
		model.addAttribute("employee", employeeService.getVeterinarians());
		return "animal/EditAnimal";
	}

	

	@RequestMapping("/healthOfAnimal") // For employeepage
	public String updateAnimalHealth() {
		LOGGER.info("Handling /healthOfAnimal request");
		return "open/Health";
	}

	@GetMapping("/healthOfAnimal")
	public String showUpdateForm(Model model) {
		LOGGER.info("Handling /healthOfAnimal request");
		List<Animal> animals = animalService.getAllAnimals();
		model.addAttribute("animals", animals);
		model.addAttribute("animal", new Animal());
		return "open/Health";
	}

	@PostMapping("/updateHealth")
	public String updateHealth(@ModelAttribute("animal") Animal animal) {
		LOGGER.info("Updating health for animal: {}", animal);
		animalService.updateHealth(animal.getId(), animal.getHealth());
		return "redirect:/healthOfAnimal";
	}

	@GetMapping("/animalDetails/{id}")
	@ResponseBody
	public Animal getAnimalDetails(@PathVariable("id") int id) {
		LOGGER.info("Getting details for animal with id {}", id);
		Animal animal = animalService.getAnimalById(id);
		return animal;
	}
@GetMapping("/checkAnimalId")			///FOR AJAX
	@ResponseBody
	public String checkId(@RequestParam int id) {
		LOGGER.info("Checking if animal with id {} exists", id);
		if (animalService.animalExists(id)) {
			return "exists";
		} else if (id == 0) {
			return "zero";
		} else {
			return "not exists";
		}
	}
	@GetMapping("/StatusViewHealth")
	public String viewAnimalHealthAdmin(Model model) {
		LOGGER.info("Handling /StatusViewHealth request");
		List<Animal> animals = animalService.getAllAnimals();
		List<Habitat> habitats = habitatService.getAllHabitat();
		List<Employee> employees = employeeService.getAllEmployees();

		Map<Integer, String> habitatEmployeeNames = habitatService.getHabitatEmployeeNames();
		Map<Integer, String> animalCaretakerNames = animalService.getAnimalCaretakerNames();

		model.addAttribute("animals", animals);
		model.addAttribute("habitats", habitats);
		model.addAttribute("employees", employees);
		model.addAttribute("habitatEmployeeNames", habitatEmployeeNames);
		model.addAttribute("animalCaretakerNames", animalCaretakerNames);
		return "open/AdminStatus";
	}
}
