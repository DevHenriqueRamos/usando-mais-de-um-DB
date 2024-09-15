package main.java.br.com.hramos;

import main.java.br.com.hramos.dao.CursoDAO;
import main.java.br.com.hramos.dao.ICursoDAO;
import main.java.br.com.hramos.domain.Curso;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class CursoTest {

    private ICursoDAO cursoDAO;

    public CursoTest() {
        cursoDAO = new CursoDAO();
    }

    @After
    public void tearDown() {
        Collection<Curso> cursos = cursoDAO.consultarTodos();
        for (Curso curso : cursos) {
            cursoDAO.excluir(curso);
        }
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso Java backend");
        curso.setDescricao("aprenda java rapidamente");
        curso = cursoDAO.cadastrar(curso);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
    }

    @Test
    public void consultar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso Java backend");
        curso.setDescricao("aprenda java rapidamente");
        curso = cursoDAO.cadastrar(curso);

        Curso cursoConsultado = cursoDAO.consultar(curso.getId());

        Assert.assertNotNull(cursoConsultado);
        Assert.assertEquals(curso.getId(),cursoConsultado.getId());
        Assert.assertEquals("A1",cursoConsultado.getCodigo());
    }

    @Test
    public void consultarTodos() {
        for (int i = 1; i <= 2; i++) {
            Curso curso = new Curso();
            curso.setCodigo("A" + i);
            curso.setNome("Curso Java backend");
            curso.setDescricao("aprenda java rapidamente");
            cursoDAO.cadastrar(curso);
        }

        Collection<Curso> cursos = cursoDAO.consultarTodos();

        Assert.assertNotNull(cursos);
        Assert.assertEquals(2, cursos.size());
    }

    @Test
    public void atualizar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso Java backend");
        curso.setDescricao("aprenda java rapidamente");
        curso = cursoDAO.cadastrar(curso);

        curso.setNome("Nome atualizado");

        Curso updatedCurso = cursoDAO.atualizar(curso);

        Assert.assertNotNull(updatedCurso);
        Assert.assertNotEquals("Curso Java backend",updatedCurso.getNome());
        Assert.assertEquals(curso.getId(), updatedCurso.getId());
    }

    @Test
    public void excluir() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso Java backend");
        curso.setDescricao("aprenda java rapidamente");
        curso = cursoDAO.cadastrar(curso);

        cursoDAO.excluir(curso);

        Curso cursoConsultado = cursoDAO.consultar(curso.getId());
        Assert.assertNull(cursoConsultado);
    }
}
