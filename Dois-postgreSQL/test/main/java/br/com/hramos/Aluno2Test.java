package main.java.br.com.hramos;

import main.java.br.com.hramos.dao.AlunoDB2DAO;
import main.java.br.com.hramos.dao.IAlunoDAO;
import main.java.br.com.hramos.domain.Aluno;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class Aluno2Test {
    
    private IAlunoDAO alunoDAO2;

    public Aluno2Test() {
        alunoDAO2 = new AlunoDB2DAO();
    }

    @After
    public void tearDown() {
        Collection<Aluno> alunos = alunoDAO2.consultarTodos();
        for (Aluno aluno : alunos) {
            alunoDAO2.excluir(aluno);
        }
    }

    @Test
    public void cadastrar() {
        Aluno aluno = new Aluno();
        aluno.setCodigo("A1");
        aluno.setNome("John Doe");
        aluno = alunoDAO2.cadastrar(aluno);

        Assert.assertNotNull(aluno);
        Assert.assertNotNull(aluno.getId());
    }

    @Test
    public void consultar() {
        Aluno aluno = new Aluno();
        aluno.setCodigo("A1");
        aluno.setNome("John Doe");
        aluno = alunoDAO2.cadastrar(aluno);

        Aluno alunoConsultado = alunoDAO2.consultar(aluno.getId());

        Assert.assertNotNull(alunoConsultado);
        Assert.assertEquals(aluno.getId(),alunoConsultado.getId());
        Assert.assertEquals("A1",alunoConsultado.getCodigo());
    }

    @Test
    public void consultarTodos() {
        for (int i = 1; i <= 2; i++) {
            Aluno aluno = new Aluno();
            aluno.setCodigo("A" + i);
            aluno.setNome("John Doe");
            aluno = alunoDAO2.cadastrar(aluno);
        }

        Collection<Aluno> alunos = alunoDAO2.consultarTodos();

        Assert.assertNotNull(alunos);
        Assert.assertEquals(2, alunos.size());
    }

    @Test
    public void atualizar() {
        Aluno aluno = new Aluno();
        aluno.setCodigo("A1");
        aluno.setNome("John Doe");
        aluno = alunoDAO2.cadastrar(aluno);

        aluno.setNome("Nome atualizado");

        Aluno updatedAluno = alunoDAO2.atualizar(aluno);

        Assert.assertNotNull(updatedAluno);
        Assert.assertNotEquals("Aluno Java backend",updatedAluno.getNome());
        Assert.assertEquals(aluno.getId(), updatedAluno.getId());
    }

    @Test
    public void excluir() {
        Aluno aluno = new Aluno();
        aluno.setCodigo("A1");
        aluno.setNome("John Doe");
        aluno = alunoDAO2.cadastrar(aluno);

        alunoDAO2.excluir(aluno);

        Aluno alunoConsultado = alunoDAO2.consultar(aluno.getId());
        Assert.assertNull(alunoConsultado);
    }
}
