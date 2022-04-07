package com.example.service;

import java.util.*;
import com.example.model.Alumno;
import com.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    //Método ListAlumnos
    public List<Alumno> listAlumnos() {
        return repository.findAll();
    }

    //Método SaveAlumno
    public Alumno saveAlumno(Alumno alumno) {
        return repository.save(alumno);
    }

    //Método GetAlumnoById
    public Alumno getAlumnoById(int id) {
        return repository.findById(id).get();
    }

    //Método DeleteAlumno
    public void deleteAlumno(int id) {
        repository.deleteById(id);
    }
}
