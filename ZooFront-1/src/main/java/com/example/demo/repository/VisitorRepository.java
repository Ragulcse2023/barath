package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository <Visitor,Integer> {

	List<Visitor> findByVisitDate(Date date);

}
