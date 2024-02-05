package br.com.csmastery.aluno.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "situacao_aluno")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoAluno {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

}
