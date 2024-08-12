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

    Aluno updateAluno(Aluno aluno);

    void deleteAluno(String id);

    AlunoRequest findById(String id);
}
