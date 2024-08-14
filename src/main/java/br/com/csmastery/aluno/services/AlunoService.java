package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.dto.AlunoPageDto;
import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public interface AlunoService {

    public AlunoPageDto getAllAlunos(@PositiveOrZero int page, @Positive @Max(100) int pageSize);

    public Aluno saveAluno(Aluno aluno);

    public void importListAluno(List<Aluno> alunos);

    public Aluno updateAluno(Aluno aluno);

    public void deleteAluno(String id);

    public AlunoRequest findById(String id);

    public AlunoPageDto findByNomeContainingIgnoreCase(String filter, int page, int pageSize);
}
