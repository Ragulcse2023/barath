package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.demo.entity.Employee;
import com.example.demo.entity.Habitat;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.HabitatService;

import jakarta.validation.Valid;

@Controller
public class HabitatController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HabitatController.class);

	@Autowired
	private HabitatService habitatService;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/HabitatView")
	public String HabitatView(Model model) {
		LOGGER.info("Handling /HabitatView request");
		List<Habitat> habitat = habitatService.getAllHabitat();
		model.addAttribute("habitat", habitat);
		return "habitat/HabitatView";
	}

	@GetMapping("/AddHabitat")
	public String addHabitat(Model model) {
		LOGGER.info("Handling /AddHabitat request");
		Habitat habitat = new Habitat();
		List<Employee> employee = employeeService.getZookeepers();
		model.addAttribute("habitat", habitat);
		model.addAttribute("employee", employee);
		return "habitat/AddHabitat";
	}

	@GetMapping("/checkHabitatId")			///FOR AJAX
	@ResponseBody
	public String checkId(@RequestParam int id) {
		LOGGER.info("Checking if habitat with id {} exists", id);
		if (habitatService.habitatExists(id)) {
			return "exists";
		} else if (id == 0) {
			return "zero";
		} else {
			return "not exists";
		}
	}

	@PostMapping("/newHabitatDetails")
	public String addHabitat(@Valid @ModelAttribute Habitat h, BindingResult result, Model model) {
		LOGGER.info("Handling /newHabitatDetails request with habitat: {}", h);
		if (result.hasErrors()) {
			model.addAttribute("habitat", h);
			model.addAttribute("employee", employeeService.getZookeepers());
			return "habitat/AddHabitat"; // return to the form page if there are errors
		}
		habitatService.save(h);
		return "redirect:/HabitatView";
	}

	@RequestMapping("/HabitatEditPage")
	public String HabitatEdit(Model model) {
		LOGGER.info("Handling /HabitatEditPage request");
		List<Habitat> habitat = habitatService.getAllHabitat();
		model.addAttribute("habitat", habitat);
		return "habitat/HabitatEditPage";
	}

	@RequestMapping("/deleteHabitat/{id}")
	public String deleteHabitat(@PathVariable("id") int id, Model model) {
		LOGGER.info("Deleting habitat with id {}", id);
		habitatService.deleteHabitatById(id);
		return "redirect:/HabitatEditPage";
	}

	@GetMapping("/editHabitat/{id}")
	public String editHabitat(@PathVariable("id") int id, Model model) {
		LOGGER.info("Editing habitat with id {}", id);
		Habitat h = habitatService.getHabitatById(id);
		List<Employee> employee = employeeService.getZookeepers();
		model.addAttribute("employee", employee);
		model.addAttribute("habitat", h);
		return "habitat/EditHabitat";
	}

	@PostMapping("/saveHabitat")
	public String editHabitat(@Valid @ModelAttribute Habitat h, BindingResult result,Model model) {
		LOGGER.info("Saving habitat: {}", h);
		if (result.hasErrors()) {
			List<Employee> employee = employeeService.getZookeepers();
			model.addAttribute("employee", employee);
			return "habitat/EditHabitat"; // return to the form page if there are errors
		}
		habitatService.save(h);
		return "redirect:/HabitatEditPage";
	}

	@GetMapping("/Cleanliness")
	public String showUpdateForm(Model model) {
		LOGGER.info("Handling /Cleanliness request");
		List<Habitat> habitats = habitatService.getAllHabitat();
		model.addAttribute("habitats", habitats);
		model.addAttribute("habitat", new Habitat());
		return "open/Cleanliness";
	}

	@PostMapping("/updateCleanliness")
	public String updateCleanliness(@ModelAttribute("habitat") Habitat habitat) {
		LOGGER.info("Updating cleanliness for habitat: {}", habitat);
		habitatService.updateCleanliness(habitat.getId(), habitat.getCleanliness());
		return "redirect:/Cleanliness";
	}

	@GetMapping("/habitatName/{id}")
	@ResponseBody
	public String getHabitatName(@PathVariable("id") int id) {
		LOGGER.info("Getting name for habitat with id {}", id);
		Habitat habitat = habitatService.getHabitatById(id);
		return habitat != null ? habitat.getName() : null;
	}

	@GetMapping("/habitats")
	public List<Habitat> getAllHabitats() {
		LOGGER.info("Getting all habitats");
		return habitatService.getAllHabitat();
	}

	@RequestMapping("/StatusViewHealth")
	public String viewAnimalHealthAdmin(Model model) {
		LOGGER.info("Handling /StatusViewHealth request");
		List<Habitat> habitat = habitatService.getAllHabitat();
		model.addAttribute("habitat", habitat);
		return "open/AdminStatus";
	}
}
