package com.example.atividade.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.atividade.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno inserir(Aluno aluno){
        return entityManager.merge(aluno);
    }

    @Transactional
    public Aluno editar(Integer id, Aluno alunoAtualizado) {
        Aluno alunoExistente = entityManager.find(Aluno.class, id);

        if (alunoExistente != null) {
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setAnoIngresso(alunoAtualizado.getAnoIngresso());
            alunoExistente.setCurso(alunoAtualizado.getCurso());
        }

        return entityManager.merge(alunoExistente);
    }

    @Transactional
    public void excluir(Integer id) {
        Aluno aluno = entityManager.find(Aluno.class, id);

        if (aluno != null) {
            entityManager.remove(aluno);
        }
    }

    public List<Aluno> obterTodos() {
        return entityManager.createQuery("from Aluno", Aluno.class).getResultList();
    }

    public Aluno selecionarPorId(Integer id) {
        return entityManager.find(Aluno.class, id);
    }
}