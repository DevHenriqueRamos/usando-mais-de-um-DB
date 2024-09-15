package main.java.br.com.hramos.dao;

import main.java.br.com.hramos.dao.generics.GenericDB1DAO;
import main.java.br.com.hramos.domain.Curso;

import java.util.Collection;
import java.util.List;

public class CursoDAO extends GenericDB1DAO<Curso> implements ICursoDAO {

    public CursoDAO() {
        super(Curso.class);
    }

    @Override
    public Collection<Curso> consultarTodos() {
        openConnection();
        List<Curso> cursos = entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return cursos;
    }
}
