package main.java.br.com.hramos;

import main.java.br.com.hramos.dao.AlunoDAO;
import main.java.br.com.hramos.dao.CursoDAO;
import main.java.br.com.hramos.dao.IMatriculaDAO;
import main.java.br.com.hramos.dao.MatriculaDAO;
import main.java.br.com.hramos.domain.Aluno;
import main.java.br.com.hramos.domain.Curso;
import main.java.br.com.hramos.domain.Matricula;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Collection;

public class MatriculaTest {

    private IMatriculaDAO matriculaDAO;
    private CursoDAO cursoDAO;
    private AlunoDAO alunoDAO;

    private Matricula matricula;
    private Curso curso;
    private Aluno aluno;

    public MatriculaTest() {
        matriculaDAO = new MatriculaDAO();
        cursoDAO = new CursoDAO();
        alunoDAO = new AlunoDAO();
    }

    @Before
    public void setUp() {
        cadastrarCurso();
        cadastrarAluno();
        matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(20000D);
        matricula.setStatus("ATIVA");
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        matricula = matriculaDAO.cadastrar(matricula);
    }

    @After
    public void tearDown() {

        Collection<Matricula> matriculas = matriculaDAO.consultarTodos();
        for (Matricula matricula : matriculas) {
            matricula.setAluno(aluno);
            matriculaDAO.excluir(matricula);
        }
        alunoDAO.excluir(aluno);
        cursoDAO.excluir(curso);
    }

    private void cadastrarCurso() {
        curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso Java backend");
        curso.setDescricao("aprenda java rapidamente");
        curso = cursoDAO.cadastrar(curso);
    }

    private void cadastrarAluno() {
        aluno = new Aluno();
        aluno.setCodigo("A1");
        aluno.setNome("John doe");
        aluno.setMatricula(matricula);
        aluno = alunoDAO.cadastrar(aluno);
    }

    @Test
    public void cadastrar() {
        Assert.assertNotNull(matricula);
        Assert.assertNotNull(matricula.getId());
    }

    @Test
    public void consultar() {

        Matricula matriculaConsultada = matriculaDAO.consultar(matricula.getId());

        Assert.assertNotNull(matriculaConsultada);
        Assert.assertEquals(matricula.getId(),matriculaConsultada.getId());
        Assert.assertEquals("A1",matriculaConsultada.getCodigo());
    }

    @Test
    public void consultarTodos() {
        Matricula matricula2 = new Matricula();
        matricula2.setCodigo("A2");
        matricula2.setDataMatricula(Instant.now());
        matricula2.setValor(20000D);
        matricula2.setStatus("ATIVA");
        matricula2.setCurso(curso);
        matriculaDAO.cadastrar(matricula2);

        Collection<Matricula> matriculas = matriculaDAO.consultarTodos();

        Assert.assertNotNull(matriculas);
        Assert.assertEquals(2, matriculas.size());
    }

    @Test
    public void atualizar() {

        matricula.setStatus("CANCELADA");

        Matricula updatedMatricula = matriculaDAO.atualizar(matricula);

        Assert.assertNotNull(updatedMatricula);
        Assert.assertNotEquals("ATIVA",updatedMatricula.getStatus());
        Assert.assertEquals(matricula.getId(), updatedMatricula.getId());
    }

    @Test
    public void excluir() {

        matriculaDAO.excluir(matricula);

        Matricula matriculaConsultada = matriculaDAO.consultar(matricula.getId());
        Assert.assertNull(matriculaConsultada);
    }
}
