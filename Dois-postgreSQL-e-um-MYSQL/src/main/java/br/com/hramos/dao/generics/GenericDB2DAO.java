package main.java.br.com.hramos.dao.generics;

import main.java.br.com.hramos.domain.Persistent;

public class GenericDB2DAO<T extends Persistent> extends GenericDAO<T> {

    public GenericDB2DAO(Class<T> persistentClass) {
        super(persistentClass, "Postgres2");
    }
}
