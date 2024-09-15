package main.java.br.com.hramos.dao.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import main.java.br.com.hramos.domain.Persistent;

import java.util.Collection;
import java.util.List;

public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T> {

    private static final String PERSISTENCE_UNIT_NAME = "Postgres1";

    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    private Class<T> persistentClass;

    private String persistenceUnitName;

    public GenericDAO(Class<T> persistentClass, String persistenceUnitName) {
        this.persistentClass = persistentClass;
        this.persistenceUnitName = persistenceUnitName;
    }

    protected void openConnection() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    private String getPersistenceUnitName() {
        if (persistenceUnitName != null
                && !persistenceUnitName.isEmpty()) {
            return persistenceUnitName;
        } else {
            return PERSISTENCE_UNIT_NAME;
        }
    }

    protected void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public T cadastrar(T entity) {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public T atualizar(T entity) {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public void excluir(T entity) {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public T consultar(Long id) {
        openConnection();
        T entity = entityManager.find(persistentClass, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public Collection<T> consultarTodos() {
        openConnection();
        List<T> listEntity =
                entityManager.createQuery("SELECT e FROM " + persistentClass.getSimpleName() + " e", persistentClass).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return listEntity;
    }
}
