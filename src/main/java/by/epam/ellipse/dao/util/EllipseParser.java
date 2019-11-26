package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;

public class EllipseParser {
    private static final EllipseParser instance = new EllipseParser();

    private EllipseParser() {
    }

    public static EllipseParser getInstance() {
        return instance;
    }

    public double[] parseCoordinates(String ellipse) throws DAOexception {
        EllipseDataValidator ellipseDataValidator = EllipseDataValidator.getInstance();

        String[] coordinatesStr;
        double[] coordinates = new double[4];

        try {
            if (ellipseDataValidator.isValidFormat(ellipse)) {
                coordinatesStr = ellipse.split("\\s");
            } else {
                throw new DAOexception("EllipseParser: parseCoordinates(): Incorrect string ellipse format.");
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
}