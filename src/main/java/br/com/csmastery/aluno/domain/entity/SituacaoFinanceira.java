package br.com.csmastery.aluno.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "situacao_financeira")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoFinanceira {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Column(length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @NotNull
    @NotBlank
    @Column(length = 20)
    private String cor;

    //@Null
    //@OneToMany(mappedBy = "situacaoFinanceira", fetch = FetchType.LAZY)
    //@JsonBackReference
    //private List<Aluno> alunos = new ArrayList<>();


}
