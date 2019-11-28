package by.epam.ellipse.dao.impl;

import by.epam.ellipse.dao.Repository;
import by.epam.ellipse.dao.Specification;
import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.dao.util.FileManipulator;
import by.epam.ellipse.service.registrar.EllipseRegistrar;

import java.util.List;

public class EllipseRepository implements Repository<EllipseRegistrar> {
FileManipulator instance = FileManipulator.getInstance();

    @Override
    public void add(EllipseRegistrar item) {
        String request = "registrars.base";
        try {
            instance.addEntry(request, item.toString()); //refactor
        } catch (DAOexception daOexception) {
            daOexception.printStackTrace();
        }
    }

    @Override
    public void update(EllipseRegistrar item) {

    }

    @Override
    public void remove(EllipseRegistrar item) {

    }

    @Override
    public List<EllipseRegistrar> takeAll(Specification specification) {
        return null;
    }

    @Override
    public EllipseRegistrar take(Specification specification) {
        return null;
    }
}
