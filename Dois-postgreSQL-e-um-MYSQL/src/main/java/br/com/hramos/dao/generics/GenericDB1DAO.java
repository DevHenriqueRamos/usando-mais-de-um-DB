package main.java.br.com.hramos.dao.generics;

import main.java.br.com.hramos.domain.Persistent;

public abstract class GenericDB1DAO <T extends Persistent> extends GenericDAO<T> {

    public GenericDB1DAO(Class<T> persistentClass) {
        super(persistentClass, "Postgres1");
    }
}
