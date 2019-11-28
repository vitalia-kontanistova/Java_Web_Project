package by.epam.ellipse.dao;

import by.epam.ellipse.dao.exception.DAOexception;

import java.util.List;

public interface Repository<T> {
    void add(T item) throws DAOexception; //boolean

    void update(T item); //boolean

    void remove(T item); //boolean

    void remove(Specification specification); //boolean

    List<T> takeAll(Specification specification);

    T takeSome(Specification specification);
}