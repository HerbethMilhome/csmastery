package br.com.csmastery.aluno.domain.entity;

import br.com.csmastery.atendente.domain.entity.Atendente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;

@Entity
@Table(name = "alunos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE alunos SET removido = 1 WHERE id = ?")
@Where(clause = "removido = 0")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Column(length = 100, nullable = false)
    private String nome;

    private String cpf;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
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

    private Integer removido;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aluno")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "situacao_id")
    private SituacaoAluno situacaoAluno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "atendente_id")
    @JsonBackReference
    private Atendente atendente;

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        if (endereco != null) {
            endereco.setAluno(this);
        }
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
        if (atendente != null) {
            atendente.getAlunos().add(this);
        }
    }

}
