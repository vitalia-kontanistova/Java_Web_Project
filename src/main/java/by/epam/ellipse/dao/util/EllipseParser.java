package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.service.exception.ServiceException;

public class EllipseParser {
    private static final EllipseParser instance = new EllipseParser();

    private EllipseParser() {
    }

    public static EllipseParser getInstance() {
        return instance;
    }

    public double[] parseCoordinates(String coordinatesEntry) throws DAOexception {
        EllipseDataValidator ellipseDataValidator = EllipseDataValidator.getInstance();

        String[] coordinatesStr;
        double[] coordinates = new double[4];

        try {
            if (ellipseDataValidator.isValidFormat(coordinatesEntry)) {
                coordinatesStr = coordinatesEntry.split("\\s");
            } else {
                throw new DAOexception("EllipseParser: parseCoordinates(): Incorrect string coordinatesEntry format.");
            }

            int i = 0;
            for (String s : coordinatesStr) {
                coordinates[i] = Double.parseDouble(s);
                i++;
            }

        } catch (NullPointerException e) {
            throw new DAOexception("EllipseParser: parseCoordinates(): " + e.getMessage());
        }
        return coordinates;
    }

    public int parseId(String objectEntry) throws DAOexception {
        int id;

        try {
            String pointer1 = "id=";
            String pointer2 = ",";
            int index1 = objectEntry.indexOf(pointer1) + pointer1.length();
            int index2 = objectEntry.indexOf(pointer2);
            id = Integer.parseInt(objectEntry.substring(index1, index2));

        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException e) {
            throw new DAOexception("EllipseParser: parseId(): " + e.getMessage());
        }
        return id;
    }

}