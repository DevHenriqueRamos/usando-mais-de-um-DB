package main.java.br.com.hramos.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Persistent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    @SequenceGenerator(name = "aluno_seq", sequenceName = "sq_aluno", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @OneToOne(mappedBy = "aluno")
    private Matricula matricula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
