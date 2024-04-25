package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Animal {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Name can only contain letters")
    private String name;

    
    @Column
    @NotEmpty(message = "Health status cannot be empty")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Health can only contain letters")
    private String health;
    
    @Column
    @NotEmpty(message = "Species cannot be empty")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Species can only contain letters")
    private String species; 
    
    @Column
    @NotNull(message = "Employee ID cannot be empty")
    private int employee_id;
}
