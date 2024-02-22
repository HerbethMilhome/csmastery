package br.com.csmastery.aluno.domain.dto;

import br.com.csmastery.aluno.domain.entity.Endereco;
import br.com.csmastery.aluno.domain.entity.SituacaoFinanceira;
import br.com.csmastery.atendente.domain.entity.Atendente;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public record AlunoRequest(
        String id,
        @NotBlank
        String nome,
        String cpf,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @JsonProperty("nome_socio")
        String nomeSocio,
        @JsonProperty("email_socio")
        String emailSocio,
        @JsonProperty("telefone_socio")
        String telefoneSocio,

        @JsonProperty("status_financeiro")
        String statusFinanceiro,
        @JsonProperty("nota_acompanhamento")
        String nota,
        String satisfacao,
        @JsonProperty("data_entrada")
        Timestamp dataEntrada,
        @JsonProperty("data_criacao")
        Timestamp dataCriacao,
        @JsonProperty("data_renovacao")
        Timestamp dataRenovacao,
        @JsonProperty("data_ultimo_contrato")
        Timestamp dataUltimoContrato,
        @JsonProperty("data_ultimo_acompanhamento")
        Timestamp ultimoAcompanhamento,

        @JsonProperty("data_proximo_contato")
        Timestamp proximoContato,
        @JsonProperty("vigencia_contrato")
        Integer vigenciaContrato,
        @JsonProperty("ultima_resposta")
        Integer ultimaResposta,
        Integer mentoria,
        @JsonProperty("ciclo_matricula")
        Integer cicloMatricula,
        Integer renovado,
        Integer removido,
        SituacaoFinanceira situacao,
        Endereco endereco,
        Atendente atendente

) {
}
