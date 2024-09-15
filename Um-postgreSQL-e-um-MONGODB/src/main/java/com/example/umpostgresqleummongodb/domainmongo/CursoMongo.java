package com.example.umpostgresqleummongodb.domainmongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@Document(collection = "cursos")
public class CursoMongo {

    @Id
    private String id;

    private String codigo;

    private String nome;

    private String descricao;

    @Field(name = "matriculas")
    private Set<String> matriculaIds;
}
