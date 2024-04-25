package com.example.demo.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Visitor;
import com.example.demo.repository.VisitorRepository;


@Service
public class VisitorService {
	
	@Autowired
	private VisitorRepository visitorRepo;
	
	public void save(Visitor v) {
		visitorRepo.save(v);
	}
	public boolean visitorExists(int id) {
	    return visitorRepo.findById(id).isPresent();
	}
	
	
	public List<Visitor> getAllVisitors(){
		return visitorRepo.findAll();
	}
	
	public Visitor getVisitorById(int id) {
		return visitorRepo.findById(id).get();
	}
	public void deleteVisitorById(int id) {
		visitorRepo.deleteById(id);
	}
	
	public List<Visitor> getVisitorsByDate(Date date) {
	    return visitorRepo.findByVisitDate(date);
	}

}
