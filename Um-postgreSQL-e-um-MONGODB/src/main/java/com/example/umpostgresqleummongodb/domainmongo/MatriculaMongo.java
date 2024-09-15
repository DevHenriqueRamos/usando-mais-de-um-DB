package com.example.umpostgresqleummongodb.domainmongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Data
@Document(collection = "matriculas")
public class MatriculaMongo {

    @Id
    private String id;

    private String codigo;

    @Field(name = "data_matricula")
    private Instant dataMatricula;

    private Double valor;

    private String status;

    @Field(name = "curso_id")
    private String cursoId;

    @Field(name = "aluno_id")
    private String alunoId;
}
