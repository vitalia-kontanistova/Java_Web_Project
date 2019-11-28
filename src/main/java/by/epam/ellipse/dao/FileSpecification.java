package by.epam.ellipse.dao;

import java.util.List;

public interface FileSpecification<T> extends Specification{
    List<T> sortBy(List<T> items);
}
