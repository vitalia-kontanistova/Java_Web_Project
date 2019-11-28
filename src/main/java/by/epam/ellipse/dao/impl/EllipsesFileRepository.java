package by.epam.ellipse.dao.impl;

import by.epam.ellipse.dao.Repository;
import by.epam.ellipse.dao.Specification;
import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.dao.util.EllipseParser;
import by.epam.ellipse.dao.util.FileManipulator;
import by.epam.ellipse.service.exception.ServiceException;
import by.epam.ellipse.service.registrar.EllipseRegistrar;
import by.epam.ellipse.service.util.IdGenerator;

import java.util.List;

public class EllipsesFileRepository implements Repository<EllipseRegistrar> {
    FileManipulator instance = FileManipulator.getInstance();

    @Override
    public void add(EllipseRegistrar registrar) throws DAOexception {
        IdGenerator idGenerator = IdGenerator.getInstance();
        EllipseParser ellipseParser = EllipseParser.getInstance();
        String request = "registrars.base"; //нужно сделать логичнее

        int id;
        String entry;

        try {
            id = idGenerator.generate(request);
            entry = ellipseParser.turnIntoEntry(registrar, id);
            instance.addEntry(request, entry);
        } catch (DAOexception | ServiceException e) {
            throw new DAOexception("EllipsesFileRepository: add(): " + e.getMessage());
        }
    }

    @Override
    public void update(EllipseRegistrar item) {
    }

    @Override
    public void remove(EllipseRegistrar item) {
    }

    @Override
    public void remove(Specification specification) {
    }

    @Override
    public List<EllipseRegistrar> takeAll(Specification specification) {
        return null;
    }

    @Override
    public EllipseRegistrar takeSome(Specification specification) {
        return null;
    }
}