package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/EmployeeView")
	public String EmployeeView(Model model) {
		LOGGER.info("Handling /EmployeeView request");
		List<Employee> employee = employeeService.getAllEmployees();
		model.addAttribute("employee", employee);
		return "employee/EmployeeView";
	}

	@GetMapping("/AddEmployee")
	public String showForm(Model model) {
		LOGGER.info("Handling /AddEmployee request");
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/AddEmployee";
	}

	@GetMapping("/checkEmployeeId")			///FOR AJAX
	@ResponseBody
	public String checkId(@RequestParam int id) {
		LOGGER.info("Checking if employee with id {} exists", id);
		if (employeeService.employeeExists(id)) {
			return "exists";
		} else if (id == 0) {
			return "zero";
		} else {
			return "not exists";
		}
	}

	@PostMapping("/newEmployeeDetails")
	public String addEmployee(@Valid @ModelAttribute Employee e, BindingResult result) {
		LOGGER.info("Handling /newEmployeeDetails request with employee: {}", e);
		if (result.hasErrors()) {
			
			return "employee/AddEmployee"; // return to the form page if there are errors
		}
		employeeService.save(e);
		return "redirect:/EmployeeView";
	}

	@RequestMapping("/EmployeeTabEdit")
	public String EmployeeEdit(Model model) {
		LOGGER.info("Handling /EmployeeTabEdit request");
		List<Employee> employee = employeeService.getAllEmployees();
		model.addAttribute("employee", employee);
		return "employee/EmployeeTabEdit";
	}

	@RequestMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		LOGGER.info("Deleting employee with id {}", id);
		employeeService.deleteEmployeeById(id);
		return "redirect:/EmployeeTabEdit";
	}

	@RequestMapping("/editEmployee/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		LOGGER.info("Editing employee with id {}", id);
		Employee e = employeeService.getEmployeeById(id);
		//employeeService.save(e);
		model.addAttribute("employee", e);
		
		return "employee/EditEmployee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute Employee e, BindingResult result) {
		LOGGER.info("Saving employee: {}", e);
		System.out.println(e);
		//employeeService.save(e);
		if (result.hasErrors()) {
			return "employee/EditEmployee"; // return to the form page if there are errors
		}
		employeeService.save(e);
		return "redirect:/EmployeeView";
	}
}
