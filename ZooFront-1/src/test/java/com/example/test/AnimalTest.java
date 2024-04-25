package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Animal;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.service.AnimalService;

@ExtendWith(MockitoExtension.class)
public class AnimalTest {

    @InjectMocks
    AnimalService animalService;

    @Mock
    AnimalRepository animalRepo;

    @Test
    public void testGetAnimalById() {
        Animal animal = new Animal(1, "Lion", "Healthy", "Mammal", 101);
        when(animalRepo.findById(1)).thenReturn(Optional.of(animal));

        Animal found = animalService.getAnimalById(1);

        assertEquals("Lion", found.getName());
        assertEquals("Healthy", found.getHealth());
        assertEquals("Mammal", found.getSpecies());
        assertEquals(101, found.getEmployee_id());
    }

    @Test
    public void testSaveAnimal() {
        Animal animal = new Animal(1, "Lion", "Healthy", "Mammal", 101);
        animalService.save(animal);
        verify(animalRepo, times(1)).save(animal);
    }

    // Add more tests for other methods in AnimalService
}
