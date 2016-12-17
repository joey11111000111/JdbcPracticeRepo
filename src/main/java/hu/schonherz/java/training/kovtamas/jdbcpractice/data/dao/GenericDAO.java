package hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao;

import java.util.Collection;

public interface GenericDAO<T> {

    Collection<T> findAll();

    T findById(int id);

    int save(T dto);

}
