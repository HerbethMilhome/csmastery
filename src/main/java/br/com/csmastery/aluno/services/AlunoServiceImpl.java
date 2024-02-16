package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.domain.entity.Endereco;
import br.com.csmastery.aluno.repository.AlunoRepository;
import br.com.csmastery.exception.RecordNotFindException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service(value = "AlunoService")
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Override
    public List<Aluno> getAllAlunos(){
        return repository.findAll();
    }

    @Override
    public Aluno saveAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public Aluno updateAluno(@NotNull Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public void deleteAluno(@NotNull String id) {
        repository.deleteById(id);
    }

    @Override
    public Aluno findById(@NotNull String id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFindException(id));
    }
}
