package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Habitat;

@Repository
public interface HabitatRepository extends JpaRepository <Habitat,Integer> {

}
