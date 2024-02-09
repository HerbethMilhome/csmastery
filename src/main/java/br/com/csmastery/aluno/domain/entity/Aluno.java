package br.com.csmastery.aluno.domain.entity;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "alunos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String email;
    @NotNull
    private String telefone;
    @JsonProperty("nome_socio")
    private String nomeSocio;
    @JsonProperty("email_socio")
    private String emailSocio;
    @JsonProperty("telefone_socio")
    private String telefoneSocio;
    @JsonProperty("status_financeiro")
    private String statusFinanceiro;
    @JsonProperty("nota_acompanhamento")
    private String nota;
    private String satisfacao;
    private String responsavel;
    @JsonProperty("data_entrada")
    private Timestamp dataEntrada;
    @JsonProperty("data_criacao")
    private Timestamp dataCriacao;
    @JsonProperty("data_renovacao")
    private Timestamp dataRenovacao;
    @JsonProperty("data_ultimo_contrato")
    private Timestamp dataUltimoContrato;
    @JsonProperty("data_ultimo_acompanhamento")
    private Timestamp ultimoAcompanhamento;
    @JsonProperty("data_proximo_contato")
    private Timestamp proximoContato;
    @JsonProperty("vigencia_contrato")
    private Integer vigenciaContrato;
    @JsonProperty("ultima_resposta")
    private Integer ultimaResposta;
    private Integer mentoria;
    @JsonProperty("ciclo_matricula")
    private Integer cicloMatricula;
    private Integer renovado;

    public Aluno(AlunoRequest aluno) {

        aluno.id().ifPresent(id -> this.id = id);

        this.nome = aluno.nome();
        this.cpf = aluno.cpf();
        this.email = aluno.email();
        this.telefone = aluno.telefone();

        aluno.nomeSocio().ifPresent(n -> this.nomeSocio = n);
        aluno.emailSocio().ifPresent(e -> this.emailSocio = e);
        aluno.telefoneSocio().ifPresent(t -> this.telefoneSocio = t);
        aluno.statusFinanceiro().ifPresent(s -> this.statusFinanceiro = s);
        aluno.nota().ifPresent(n -> this.nota = n);
        aluno.satisfacao().ifPresent(s -> this.satisfacao = s);
        aluno.responsavel().ifPresent(r -> this.responsavel = r);
        aluno.dataEntrada().ifPresent(d -> this.dataEntrada = d);
        aluno.dataCriacao().ifPresent(d -> this.dataCriacao = d);
        aluno.dataRenovacao().ifPresent(d -> this.dataRenovacao = d);
        aluno.dataUltimoContrato().ifPresent(d -> this.dataUltimoContrato = d);
        aluno.ultimoAcompanhamento().ifPresent(u -> this.ultimoAcompanhamento = u);
        aluno.proximoContato().ifPresent(p -> this.proximoContato = p);
        aluno.vigenciaContrato().ifPresent(v -> this.vigenciaContrato = v);
        aluno.ultimaResposta().ifPresent(u -> this.ultimaResposta = u);
        aluno.mentoria().ifPresent(m -> this.mentoria = m);
        aluno.cicloMatricula().ifPresent(c -> this.cicloMatricula = c);
        aluno.renovado().ifPresent(r -> this.renovado = r);

    }

}
