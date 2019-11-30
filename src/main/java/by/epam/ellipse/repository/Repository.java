package by.epam.ellipse.repository;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.util.IdGenerator;

import java.util.List;

public interface Repository<T> {
    void add(T item, IdGenerator idGenerator) throws DAOexception;

    void update(T item); //boolean

    void remove(T item); //boolean

    void remove(Specification specification); //boolean

    List<T> takeAll(Specification specification);

    T takeSome(Specification specification);
}