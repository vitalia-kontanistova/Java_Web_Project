package by.epam.ellipse.dao.impl;

import by.epam.ellipse.dao.FileSpecification;
import by.epam.ellipse.dao.util.IdComparator;
import by.epam.ellipse.service.registrar.EllipseRegistrar;

import java.util.List;

public class RegistrarsByIdSpecification implements FileSpecification<EllipseRegistrar> {
    @Override
    public List<EllipseRegistrar> sortBy(List<EllipseRegistrar> items) {
        IdComparator idComparator = new IdComparator();
        items.sort(idComparator);
        return items;
    }

}
