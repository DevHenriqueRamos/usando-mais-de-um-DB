package main.java.br.com.hramos;

import main.java.br.com.hramos.dao.AlunoDAO;
import main.java.br.com.hramos.dao.AlunoDB2DAO;
import main.java.br.com.hramos.dao.AlunoDB3DAO;
import main.java.br.com.hramos.dao.IAlunoDAO;
import main.java.br.com.hramos.domain.Aluno;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class CadastrarAlunosEmDBsDiferentes {

    private IAlunoDAO alunoDAO;
    private IAlunoDAO alunoDAO2;
    private IAlunoDAO alunoDAO3;

    private Aluno aluno;

    public CadastrarAlunosEmDBsDiferentes() {
        alunoDAO = new AlunoDAO();
        alunoDAO2 = new AlunoDB2DAO();
        alunoDAO3 = new AlunoDB3DAO();
    }

    private void excluirAluno(IAlunoDAO alunoDAOExcluir){

        Collection<Aluno> alunos = alunoDAOExcluir.consultarTodos();
        for (Aluno aluno : alunos) {
            alunoDAOExcluir.excluir(aluno);
        }
    }

    @After
    public void tearDown() {
        excluirAluno(alunoDAO);
        excluirAluno(alunoDAO2);
        excluirAluno(alunoDAO3);
    }

    private Aluno criarAluno(IAlunoDAO alunoDAOCriar){
        if (aluno == null) {
            aluno = new Aluno();
        }
        aluno.setCodigo("A1");
        aluno.setNome("John Doe");
        aluno = alunoDAOCriar.cadastrar(aluno);

        return aluno;
    }

    @Test
    public void cadastrar() {
        //Criar aluno no primeiro DB
        Aluno aluno1 = criarAluno(alunoDAO);
        Assert.assertNotNull(aluno1);
        Assert.assertNotNull(aluno1.getId());

        aluno.setId(null);

        //Criar aluno no segundo DB
        Aluno aluno2 = criarAluno(alunoDAO2);
        Assert.assertNotNull(aluno2);
        Assert.assertNotNull(aluno2.getId());

        aluno.setId(null);

        //Criar aluno no terceiro DB
        Aluno aluno3 = criarAluno(alunoDAO3);
        Assert.assertNotNull(aluno3);
        Assert.assertNotNull(aluno3.getId());
    }
}
