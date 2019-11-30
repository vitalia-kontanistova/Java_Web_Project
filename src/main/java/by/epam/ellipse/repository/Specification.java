package by.epam.ellipse.repository;

import java.util.List;

public interface Specification<T> {
    List<T> sortBy(List<T> items);

}
