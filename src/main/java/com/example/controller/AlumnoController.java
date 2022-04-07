package com.example.controller;

import java.util.*;
import com.example.model.Alumno;
import com.example.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class AlumnoController {
    
    @Autowired
    private AlumnoService service;
    
    @GetMapping(value = "/all")
    public List<Alumno> getAll() {
        return service.listAlumnos();
        
    }
    
    @GetMapping(value = "/find/{id}")
    public Alumno find(@PathVariable int id) {
        return service.getAlumnoById(id);
        
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Alumno> save(@RequestBody Alumno alumno) {
        Alumno obj = service.saveAlumno(alumno);
        return new ResponseEntity<>(obj, HttpStatus.OK);
        
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id) {
        service.deleteAlumno(id);
    }
}
