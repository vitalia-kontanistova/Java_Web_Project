package by.epam.ellipse.repository.impl;

import by.epam.ellipse.registrar.EllipseObservable;
import by.epam.ellipse.repository.Repository;
import by.epam.ellipse.repository.Specification;
import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.util.FileManipulator;

import java.util.List;

public class EllipsesFileRepository implements Repository<EllipseObservable> {
    FileManipulator instance = FileManipulator.getInstance();

    @Override
    public void add(EllipseObservable registrar) throws DAOexception {
//        IdGenerator idGenerator = IdGenerator.getInstance();
//        Parser ellipseParser = Parser.getInstance();
//        String request = "registrars.base"; //нужно сделать логичнее
//
//        int id;
//        String entry;
//
//        try {
//            id = idGenerator.generate(request);
//            entry = ellipseParser.turnIntoEntry(registrar, id);
//            instance.addEntry(request, entry);
//        } catch (DAOexception | ServiceException e) {
//            throw new DAOexception("EllipsesFileRepository: add(): " + e.getMessage());
//        }
    }

    @Override
    public void update(EllipseObservable item) {
    }

    @Override
    public void remove(EllipseObservable item) {
    }

    @Override
    public void remove(Specification specification) {
    }

    @Override
    public List<EllipseObservable> takeAll(Specification specification) {
        return null;
    }

    @Override
    public EllipseObservable takeSome(Specification specification) {
        return null;
    }
}