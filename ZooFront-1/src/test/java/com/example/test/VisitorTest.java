package com.example.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

@ExtendWith(MockitoExtension.class)
public class VisitorTest {

    @InjectMocks
    VisitorService visitorService;

    @Mock
    VisitorRepository visitorRepo;

    @Test
    public void testGetAllVisitors() {
        Visitor visitor1 = new Visitor(1, "John Doe", 5, "john@example.com", 2500, new Date(System.currentTimeMillis()));
        Visitor visitor2 = new Visitor(2, "Jane Doe", 3, "jane@example.com", 1500, new Date(System.currentTimeMillis()));
        List<Visitor> visitors = Arrays.asList(visitor1, visitor2);

        when(visitorRepo.findAll()).thenReturn(visitors);

        List<Visitor> result = visitorService.getAllVisitors();
        assertEquals(2, result.size());
    }

    @Test
    public void testSaveVisitor() {
        Visitor visitor = new Visitor(1, "John Doe", 5, "john@example.com", 2500, new Date(System.currentTimeMillis()));
        visitorService.save(visitor);
        verify(visitorRepo, times(1)).save(visitor);
    }

    @Test
    public void testVisitorExists() {
        Visitor visitor = new Visitor(1, "John Doe", 5, "john@example.com", 2500, new Date(System.currentTimeMillis()));
        when(visitorRepo.findById(1)).thenReturn(Optional.of(visitor));
        boolean exists = visitorService.visitorExists(1);
        assertEquals(true, exists);
    }

    @Test
    public void testDeleteVisitorById() {
        visitorService.deleteVisitorById(1);
        verify(visitorRepo, times(1)).deleteById(1);
    }

    @Test
    public void testGetVisitorById() {
        Visitor visitor = new Visitor(1, "John Doe", 5, "john@example.com", 2500, new Date(System.currentTimeMillis()));
        when(visitorRepo.findById(1)).thenReturn(Optional.of(visitor));
        Visitor result = visitorService.getVisitorById(1);
        assertEquals("John Doe", result.getName());
    }
}
