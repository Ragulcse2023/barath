package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@Column
	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Name can only contain letters")
	private String name;
		
	@Column
	@NotEmpty(message = "Habitat or Specialization cannot be empty")
	private String habitat_or_spec;
		
	@Column(unique=false)
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	private String email;
		
	@Column
	@NotEmpty(message = "Role cannot be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Role can only contain letters")
	private String role;
}
