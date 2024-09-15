package com.example.umpostgresqleummongodb.domainmongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "alunos")
public class AlunoMongo {

    @Id
    private String id;

    private String codigo;

    private String nome;

    @Field(name = "matricula_id")
    private String matriculaId;
}
