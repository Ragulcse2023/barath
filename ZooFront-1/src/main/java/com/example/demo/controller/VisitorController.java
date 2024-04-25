package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class VisitorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VisitorController.class);

	@Autowired
	private VisitorService visitorService;

	@RequestMapping("/visitor")
	public String visitor() {
		LOGGER.info("Handling /visitor request");
		return "redirect:/VisitorView";
	}

	@RequestMapping("/VisitorView")
	public String visitorView(Model model) {
		LOGGER.info("Handling /VisitorView request");
		List<Visitor> visitor = visitorService.getAllVisitors();
		model.addAttribute("visitor", visitor);
		return "visitor/VisitorView";
	}

	@PostMapping("/newVisitorDetails")
	public String addVisitor(@Valid @ModelAttribute Visitor vis, BindingResult result) {
		LOGGER.info("Handling /newVisitorDetails request with visitor: {}", vis);
		if (result.hasErrors()) {
			return "visitor/AddVisitor";
		}
		vis.computeCost();
		visitorService.save(vis);
		return "redirect:/VisitorView";
	}
	
	@GetMapping("/checkVisitorId")			///FOR AJAX
	@ResponseBody
	public String checkId(@RequestParam int id) {
		LOGGER.info("Checking if visitor with id {} exists", id);
	    if (visitorService.visitorExists(id)) {
	        return "exists";
	    } else if (id == 0) {
	        return "zero";
	    } else {
	        return "not exists";
	    }
	}

	@RequestMapping("/AddVisitor")
	public String AddVisitor(Model model) {
		LOGGER.info("Handling /AddVisitor request");
		Visitor visitor = new Visitor();
		model.addAttribute("visitor", visitor);
		return "visitor/AddVisitor";
	}

	@RequestMapping("/VisitorEditPage")
	public String visitorEdit(Model model) {
		LOGGER.info("Handling /VisitorEditPage request");
		List<Visitor> visitor = visitorService.getAllVisitors();
		model.addAttribute("visitor", visitor);
		return "visitor/VisitorEditPage";
	}

	@RequestMapping("/deleteVisitor/{id}")
	public String deleteVisitor(@PathVariable("id") int id, Model model) {
		LOGGER.info("Deleting visitor with id {}", id);
		visitorService.deleteVisitorById(id);
		return "redirect:/VisitorView";
	}

	@RequestMapping("/editVisitor/{id}")
	public String editVisitor(@PathVariable("id") int id, Model model) {
		LOGGER.info("Editing visitor with id {}", id);
		Visitor v = visitorService.getVisitorById(id);
		v.computeCost();
		visitorService.save(v);
		model.addAttribute("visitor", v);
		return "visitor/EditVisitor";
	}

	@PostMapping("/saveVisitor")
	public String AddVisitor(@Valid @ModelAttribute Visitor v, BindingResult result) {
		LOGGER.info("Saving visitor: {}", v);
		if (result.hasErrors()) {
			return "visitor/EditVisitor";
		}
		v.computeCost();
		visitorService.save(v);
		return "redirect:/VisitorEditPage";
	}

	@GetMapping("/visitors/{date}")
	@ResponseBody
	public List<Visitor> getVisitorsByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		LOGGER.info("Getting visitors by date: {}", date);
		return visitorService.getVisitorsByDate(date);
	}
}
