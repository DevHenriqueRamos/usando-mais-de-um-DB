package com.example.umpostgresqleummongodb.domainjpa;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
public class MatriculaJpa {

    private @Id @GeneratedValue Long id;

    private String codigo;

    @Column(name = "DATA_MATRICULA", nullable = false)
    private Instant dataMatricula;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn( name = "id_curso_fk",
            foreignKey = @ForeignKey( name = "fk_curso_matricula"),
            referencedColumnName = "id", nullable = false)
    private CursoJpa curso;

    @OneToOne
    @JoinColumn( name = "id_aluno_fk",
            foreignKey = @ForeignKey( name = "fk_aluno_matricula"),
            referencedColumnName = "id", nullable = false)
    private AlunoJpa aluno;
}
