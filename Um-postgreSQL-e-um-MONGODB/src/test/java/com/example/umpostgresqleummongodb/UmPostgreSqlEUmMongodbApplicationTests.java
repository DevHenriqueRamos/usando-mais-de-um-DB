package com.example.umpostgresqleummongodb;

import com.example.umpostgresqleummongodb.domainjpa.AlunoJpa;
import com.example.umpostgresqleummongodb.domainjpa.AlunoRepositoryJpa;
import com.example.umpostgresqleummongodb.domainmongo.AlunoMongo;
import com.example.umpostgresqleummongodb.domainmongo.AlunoRepositoryMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UmPostgreSqlEUmMongodbApplicationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    AlunoRepositoryMongo alunoRepositoryMongo;

    @Autowired
    AlunoRepositoryJpa alunoRepositoryJpa;

    @Test
    public void cadastrarMongo() {
        AlunoMongo alunoMongo = new AlunoMongo();
        alunoMongo.setCodigo("A1");
        alunoMongo.setNome("John Doe");
        alunoMongo = alunoRepositoryMongo.save(alunoMongo);

        assertNotNull(alunoMongo);
        assertNotNull(alunoMongo.getId());
    }

    @Test
    public void cadastrarJpa() {
        AlunoJpa alunoJpa = new AlunoJpa();
        alunoJpa.setCodigo("A1");
        alunoJpa.setNome("John Doe");
        alunoJpa = alunoRepositoryJpa.save(alunoJpa);

        assertNotNull(alunoJpa);
        assertNotNull(alunoJpa.getId());
    }

}
