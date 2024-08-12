package br.com.csmastery.aluno.services.impl;

import br.com.csmastery.aluno.domain.dto.AlunoPageDto;
import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.dto.mapper.AlunoMapper;
import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.repository.AlunoRepository;
import br.com.csmastery.aluno.services.AlunoService;
import br.com.csmastery.exception.RecordNotFindException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service(value = "AlunoService")
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoMapper alunoMapper;

    @Override
    public AlunoPageDto getAllAlunos(@PositiveOrZero int page, @Positive @Max(100) int pageSize){
        Page<Aluno> pageCourse = repository.findAll(PageRequest.of(page, pageSize));
        List<Aluno> alunos = pageCourse.get().collect(Collectors.toList());
        return new AlunoPageDto(alunos, pageCourse.getTotalElements(), pageCourse.getTotalPages());
    }

    @Override
    public Aluno saveAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public void importListAluno(List<Aluno> alunos) {

        List<Aluno> alunosEntities = new ArrayList<>();

        for(Aluno aluno : alunos) {
            aluno.setRemovido(0);
            aluno.setRenovado(0);
            aluno.setMentoria(0);
            String resultTel = aluno.getTelefone().replaceAll("\\D", "");
            aluno.setTelefone(resultTel.replace("55", ""));
            alunosEntities.add(aluno);
        }

        repository.saveAll(alunos);
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
    public AlunoRequest findById(@NotNull String id) {
        return repository.findById(id)
            .map(alunoMapper::toRequest).orElseThrow(() -> new RecordNotFindException(id));
    }
}
