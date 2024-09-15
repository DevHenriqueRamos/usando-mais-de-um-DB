package main.java.br.com.hramos.dao;

import main.java.br.com.hramos.dao.generics.GenericDB2DAO;
import main.java.br.com.hramos.domain.Aluno;

public class AlunoDB2DAO extends GenericDB2DAO<Aluno> implements IAlunoDAO {

    public AlunoDB2DAO() {
        super(Aluno.class);
    }
}
