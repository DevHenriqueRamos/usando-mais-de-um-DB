package main.java.br.com.hramos.dao;

import main.java.br.com.hramos.dao.generics.GenericDB1DAO;
import main.java.br.com.hramos.domain.Matricula;

public class MatriculaDAO extends GenericDB1DAO<Matricula> implements IMatriculaDAO{

    public MatriculaDAO() {
        super(Matricula.class);
    }
}
