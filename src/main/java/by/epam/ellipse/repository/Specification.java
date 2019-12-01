package by.epam.ellipse.repository;

import by.epam.ellipse.registrar.EllipseObservable;

import java.util.List;

public interface Specification<T,R> {
    void remove(List<R> base, int id);

    List<T> sort(Specification specification);

    List<T> takeAll(Specification specification);

    List<T> takeSome(Specification specification);

    T takeOne(Specification specification);
}
