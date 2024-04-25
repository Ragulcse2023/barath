package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


    @Column
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name can only contain letters and spaces")
    private String name;

	@Column
	@NotNull(message = "Group size cannot be empty")
	@Min(value = 1, message = "Group size should not be zero")
	private int groupsize;

	@Column
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	private String email;

	private int cost;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date visitDate;

	public void computeCost() {
	    this.cost = this.groupsize * 500;
	}


}
