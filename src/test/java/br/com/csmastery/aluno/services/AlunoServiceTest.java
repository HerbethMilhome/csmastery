package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.repository.AlunoRepository;
import br.com.csmastery.aluno.services.impl.AlunoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Mock
    private AlunoRepository repository;

    @InjectMocks
    private AlunoServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void given_getAllAlunos_return_allData() {
        List<Aluno> list = new ArrayList<>();
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        list.add(a1);
        list.add(a2);

        Mockito.when(repository.findAll()).thenReturn(list);
        Assertions.assertEquals(2, service.getAllAlunos().size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void given_saveAluno_return_aluno() {
        Aluno a1 = new Aluno();

        Mockito.when(repository.save(a1)).thenReturn(a1);
        Assertions.assertEquals(a1, service.saveAluno(a1));
        Mockito.verify(repository, Mockito.times(1)).save(a1);
    }

    @Test
    void given_updateAlunoNulo_return_nulo() {
        Aluno a1 = new Aluno();

        Mockito.when(repository.save(null)).thenReturn(null);
        Assertions.assertEquals(null, service.updateAluno(null));
        Mockito.verify(repository, Mockito.times(0)).save(a1);
    }

    @Test
    void given_deleteAluno_return_void() {
        Mockito.doNothing().when(repository).deleteById("1");
        service.deleteAluno("1");
        Mockito.verify(repository, Mockito.times(1)).deleteById("1");
    }

//    @Test
//    void given_ufindById_return_aluno() {
//        Aluno a1 = new Aluno();
//        AlunoRequest ar = new AlunoRequest("1", "nome", null,
//                null,null,null,null,null,null,
//                null,null,null,null,null,null,
//                null,null,null,null,null,
//                null,null,null,null,null,null);
//
//        Mockito.when(repository.findById("1")).thenReturn(Optional.of(Mockito.any()));
//        Assertions.assertNotNull(service.findById("1"));
//        Mockito.verify(repository, Mockito.times(1)).findById("1");
//    }

}
