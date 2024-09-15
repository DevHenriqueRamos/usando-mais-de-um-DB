package com.example.umpostgresqleummongodb.domainjpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AlunoJpa {

    private @Id @GeneratedValue Long id;

    private String codigo, nome;

    @OneToOne(mappedBy = "aluno")
    private MatriculaJpa matricula;
}
