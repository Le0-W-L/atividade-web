package com.example.atividade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade.models.Curso;
import com.example.atividade.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Curso inserir(@RequestBody Curso curso){
        return cursoRepository.inserir(curso);
    }

    @GetMapping
    public List<Curso> mostrarTodos(){
        return cursoRepository.obterTodos();
    }
}