package by.epam.ellipse.service.util;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.dao.util.EllipseParser;
import by.epam.ellipse.dao.util.FileManipulator;
import by.epam.ellipse.service.exception.ServiceException;
import java.util.List;

public class IdGenerator {
    private FileManipulator instanceFIE = FileManipulator.getInstance();
    private EllipseParser instanceEP = EllipseParser.getInstance();

    private static IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }


    public int generate(String requestToPropFile) throws ServiceException {
        List<String> base;
        int id;

        try {
            base = instanceFIE.extractEntriesFromFile(requestToPropFile);
            if (base.size() == 0) {
                return 1;
            } else {
                int index = base.size() - 1;
                String entry = base.get(index);
                id = instanceEP.parseId(entry);
            }
        } catch (DAOexception | RuntimeException e) {
            throw new ServiceException("IdGenerator: generate(): " + e.getMessage());
        }
        return id + 1;
    }
}