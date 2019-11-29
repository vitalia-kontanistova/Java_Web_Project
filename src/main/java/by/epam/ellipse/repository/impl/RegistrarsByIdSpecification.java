package by.epam.ellipse.repository.impl;

import by.epam.ellipse.repository.FileSpecification;
import by.epam.ellipse.comparator.IdComparator;
import by.epam.ellipse.registrar.EllipseObservable;

import java.util.List;

public class RegistrarsByIdSpecification implements FileSpecification<EllipseObservable> {
    @Override
    public List<EllipseObservable> sortBy(List<EllipseObservable> items) {
//        IdComparator idComparator = new IdComparator();
//        items.sort(idComparator);
        return items;
    }

}
