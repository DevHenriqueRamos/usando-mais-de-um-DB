package main.java.br.com.hramos.dao;


import main.java.br.com.hramos.dao.generics.GenericDB3DAO;
import main.java.br.com.hramos.domain.Aluno;

public class AlunoDB3DAO extends GenericDB3DAO<Aluno> implements IAlunoDAO {

    public AlunoDB3DAO() {
        super(Aluno.class);
    }
}
