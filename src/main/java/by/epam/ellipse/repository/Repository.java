package by.epam.ellipse.repository;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.util.IdGenerator;

import java.util.List;

public interface Repository<T> {
    void add(T item, IdGenerator idGenerator) throws DAOexception;

    void update(T item);

    void remove(T item);

    void remove(Specification specification);

    List<T> sort(Specification specification);

    List<T> takeAll(Specification specification);

    List<T> takeSome(Specification specification);

    T takeOne(Specification specification);
}