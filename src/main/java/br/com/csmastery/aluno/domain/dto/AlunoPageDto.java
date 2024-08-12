package br.com.csmastery.aluno.domain.dto;

import br.com.csmastery.aluno.domain.entity.Aluno;

import java.util.List;

public record AlunoPageDto (List<Aluno> alunos, long totalElements, int totalPages){
}
