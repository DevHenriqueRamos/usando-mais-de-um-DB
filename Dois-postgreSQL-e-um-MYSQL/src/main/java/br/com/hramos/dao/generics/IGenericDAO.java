package main.java.br.com.hramos.dao.generics;
import main.java.br.com.hramos.domain.Persistent;

import java.util.Collection;

public interface IGenericDAO<T extends Persistent> {
    public T cadastrar(T entity);
    public T atualizar(T entity);
    public void excluir(T entity);
    public T consultar(Long id);
    public Collection<T> consultarTodos();
}
