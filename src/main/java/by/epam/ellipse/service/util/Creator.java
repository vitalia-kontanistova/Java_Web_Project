package by.epam.ellipse.service.util;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Creator {
    private static Creator instance = new Creator();

    private Creator() {
    }

    public static Creator getInstance() {
        return instance;
    }

    public Ellipse create(String ellipseStr) throws ServiceException {
        Extractor instance1 = Extractor.getInstance();
        Validator instance2 = Validator.getInstance();
        double[] coordinates;

        Ellipse.Point pointA;
        Ellipse.Point pointB;
        Ellipse ellipse = null;

        try {
            if (instance2.isValidFormat(ellipseStr)) {
                coordinates = instance1.extractCoordinates(ellipseStr);
                pointA = new Ellipse.Point(coordinates[0], coordinates[1]);
                pointB = new Ellipse.Point(coordinates[2], coordinates[3]);
                ellipse = new Ellipse(pointA, pointB);
            }
        } catch (NullPointerException | ServiceException e) {
            throw new ServiceException("Creator: create(): " + e.getMessage());
        }
        return ellipse;
    }

    public Ellipse createFromFile(String path) throws ServiceException {

        return null;
    }

    private String getFileAddress(String request) throws IOException {
        Properties property = new Properties();
        FileInputStream fis = null;
        String response;

        try {
            fis = new FileInputStream("src/main/resources/prop.properties");
            property.load(fis);

            response = property.getProperty(request);

        } catch (IOException e) {
            throw new IOException("Creator: getFileAddress(): property file is not found" + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new IOException("Creator: getFileAddress(): close thread problem; " + e.getMessage());
            }
        }
        return response;
    }

    public void createAllFromFile() throws IOException {
        String path = getFileAddress("ellipse.base");
        String entry;

        BufferedReader bufferedReader = null;
        FileReader fileReader;

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            while ((entry = bufferedReader.readLine()) != null) {
                base.add(entry);
            }

        } catch (IOException e) {
            throw new IOException("FileManipulator: extractAllEntries(): " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                throw new IOException("FileManipulator: extractAllEntries(): thread close problem; " + e.getMessage());
            }
        }
        return base;
    }


}