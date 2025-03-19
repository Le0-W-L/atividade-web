package com.example.atividade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade.models.Aluno;
import com.example.atividade.models.Curso;
import com.example.atividade.repositories.AlunoRepository;
import com.example.atividade.repositories.CursoRepository;

@SpringBootApplication
public class AtividadeApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired AlunoRepository alunoRepository) {
		return args -> {
			System.out.println("---- Inserindo Cursos ----");
			Curso curso1 = cursoRepository.inserir(new Curso(null, "Engenharia de Software"));
			Curso curso2 = cursoRepository.inserir(new Curso(null, "Ciência da Computação"));
			
			System.out.println("---- Criando Alunos ----");
			Aluno aluno1 = alunoRepository.inserir(new Aluno(null, "Carlos", 2022, curso1));
			Aluno aluno2 = alunoRepository.inserir(new Aluno(null, "Mariana", 2023, curso2));

			System.out.println("---- Listando Cursos ----");
			List<Curso> listaCursos = cursoRepository.obterTodos();
			listaCursos.forEach(System.out::println);

			System.out.println("---- Exibindo Alunos ----");
			List<Aluno> listaAlunos = alunoRepository.obterTodos();
			listaAlunos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AtividadeApplication.class, args);
	}

}