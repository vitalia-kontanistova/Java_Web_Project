package by.epam.ellipse.service.util;

import by.epam.ellipse.service.exception.ServiceException;

import java.util.List;

public class Extractor {
    private static final Extractor instance = new Extractor();
    private Extractor() {
    }
    public static Extractor getInstance() {
        return instance;
    }

    public double[] extractCoordinates(String ellipse) throws NullPointerException,ServiceException {
        String[] coordinatesStr;
        double[] coordinates = new double[4];

        try {
            coordinatesStr = parse(ellipse);
            int i = 0;
            for (String s : coordinatesStr) {
                coordinates[i] = Double.parseDouble(s);
                i++;
            }

            coordinates = new double[coordinatesStr.length];
        } catch (NullPointerException e) {
            throw new NullPointerException("Extractor: extractCoordinates(): " + e.getMessage());
        } catch (ServiceException ex) {
            throw new ServiceException("Extractor: extractCoordinates(): " + ex.getMessage());
        }
        return coordinates;
    }

    //private
    public String[] parse(String ellipse) throws NullPointerException, ServiceException {
        Validator validator = Validator.getInstance();

        try {
            if (validator.isValidFormat(ellipse)) {
                return ellipse.split("\\s"); //срабатывает включая enter
            } else {
                throw new ServiceException("Incorrect ellipse (string) format.");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Extractor: parse(): " + e.getMessage());
        }
    }

}