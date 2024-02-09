package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        //Aluno aluno = new Aluno(alunoRequest);
        return repository.save(aluno);
    }

    @Override
    public Aluno updateAluno(Aluno aluno) {
        //Aluno aluno = new Aluno(alunoRequest);
        return repository.save(aluno);
    }

    @Override
    public void deleteAluno(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Aluno> findById(String id) {
        Optional<Aluno> aluno = repository.findById(id);
        return aluno;
    }
}
