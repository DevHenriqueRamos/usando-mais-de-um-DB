package main.java.br.com.hramos.dao;

import main.java.br.com.hramos.dao.generics.GenericDB1DAO;
import main.java.br.com.hramos.domain.Aluno;

public class AlunoDAO extends GenericDB1DAO<Aluno> implements IAlunoDAO {

    public AlunoDAO() {
        super(Aluno.class);
    }
}
