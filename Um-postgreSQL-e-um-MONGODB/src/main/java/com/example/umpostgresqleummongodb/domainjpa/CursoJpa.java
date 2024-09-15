package com.example.umpostgresqleummongodb.domainjpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class CursoJpa {

    private @Id @GeneratedValue Long id;

    private String codigo;

    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<MatriculaJpa> matriculas;
}
