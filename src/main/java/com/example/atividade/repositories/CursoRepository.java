package com.example.atividade.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.atividade.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso inserir(Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> obterTodos() {
        return entityManager.createQuery("from Curso", Curso.class).getResultList();
    }

    @Transactional
    public Curso editar(Integer id, Curso cursoAtualizado) {
        Curso cursoExistente = entityManager.find(Curso.class, id);

        if (cursoExistente != null) {
            cursoExistente.setNome(cursoAtualizado.getNome());
        }

        return entityManager.merge(cursoExistente);
    }

    @Transactional
    public void excluir(Integer id) {
        Curso curso = entityManager.find(Curso.class, id);

        if (curso != null) {
            entityManager.remove(curso);
        }
    }

    public Curso selecionarPorId(Integer id) {
        return entityManager.find(Curso.class, id);
    }
}