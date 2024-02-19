package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import java.util.List;

public interface AlunoService {

    public List<Aluno> getAllAlunos();

    public Aluno saveAluno(Aluno aluno);

    Aluno updateAluno(Aluno aluno);
    void deleteAluno(String id);

    AlunoRequest findById(String id);
}
