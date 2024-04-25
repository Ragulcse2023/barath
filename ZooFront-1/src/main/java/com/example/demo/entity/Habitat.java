package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitat {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name can only contain letters and spaces")
    private String name;

    @Column
    @NotEmpty(message = "Cleanliness status cannot be empty")
    private String cleanliness;

    @Column
    @NotNull(message = "Employee ID cannot be empty")
    @Positive(message = "Employee ID must be a positive number")
    private int employee_id;
}
