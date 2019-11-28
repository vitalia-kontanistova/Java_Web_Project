package by.epam.ellipse.dao;

import java.util.List;

public interface Repository<T> {
    void add(T item); //boolean

    void update(T item); //boolean

    void remove(T item); //boolean

    List<T> takeAll(Specification specification);

    T take(Specification specification);
}