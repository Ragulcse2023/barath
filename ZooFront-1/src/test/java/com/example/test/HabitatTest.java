package com.example.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Habitat;
import com.example.demo.repository.HabitatRepository;
import com.example.demo.service.HabitatService;
@ExtendWith(MockitoExtension.class)
public class HabitatTest {

    @InjectMocks
    HabitatService habitatService;

    @Mock
    HabitatRepository habitatRepo;


    @Test
    public void testSaveHabitat() {
        Habitat habitat = new Habitat(1, "Forest", "Clean", 1);
        habitatService.save(habitat);
        verify(habitatRepo, times(1)).save(habitat);
    }

    @Test
    public void testHabitatExists() {
        when(habitatRepo.findById(1)).thenReturn(Optional.of(new Habitat()));
        assertTrue(habitatService.habitatExists(1));
    }

    @Test
    public void testHabitatDoesNotExist() {
        when(habitatRepo.findById(1)).thenReturn(Optional.empty());
        assertFalse(habitatService.habitatExists(1));
    }

    @Test
    public void testGetHabitatById() {
        Habitat habitat = new Habitat(1, "Forest", "Clean", 1);
        when(habitatRepo.findById(1)).thenReturn(Optional.of(habitat));
        Habitat found = habitatService.getHabitatById(1);
        assertEquals(habitat, found);
    }

    @Test
    public void testDeleteHabitatById() {
        habitatService.deleteHabitatById(1);
        verify(habitatRepo, times(1)).deleteById(1);
    }
}
