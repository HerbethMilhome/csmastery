package br.com.csmastery.aluno.domain.dto;

import br.com.csmastery.aluno.domain.entity.Endereco;
import br.com.csmastery.aluno.domain.entity.SituacaoAluno;
import br.com.csmastery.enums.SimNao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.Optional;

public record AlunoRequest(
        Optional<String> id,
        @NotBlank
        String nome,
        String cpf,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        Optional<String> nomeSocio,
        Optional<String> emailSocio,
        Optional<String> telefoneSocio,
        Optional<String> statusFinanceiro,
        Optional<String> nota,
        Optional<String> satisfacao,
        Optional<String> responsavel,
        Optional<Timestamp> dataEntrada,
        Optional<Timestamp> dataCriacao,
        Optional<Timestamp> dataRenovacao,
        Optional<Timestamp> dataUltimoContrato,
        Optional<Timestamp> ultimoAcompanhamento,
        Optional<Timestamp> proximoContato,
        Optional<Integer> vigenciaContrato,
        Optional<Integer> ultimaResposta,
        Optional<Integer> mentoria,
        Optional<Integer> cicloMatricula,
        Optional<Integer> renovado,
        Optional<SituacaoAluno> situacao,
        Optional<Endereco> endereco,
        Integer removido
) { }
