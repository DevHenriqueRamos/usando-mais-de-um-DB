package main.java.br.com.hramos.dao.generics;

import main.java.br.com.hramos.domain.Persistent;

public abstract class GenericDB3DAO<T extends Persistent> extends GenericDAO<T> {

    public GenericDB3DAO(Class<T> persistentClass) {
        super(persistentClass, "Mysql1");
    }
}
