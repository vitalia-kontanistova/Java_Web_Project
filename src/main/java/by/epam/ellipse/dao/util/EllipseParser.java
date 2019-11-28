package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.entity.Parameters;
import by.epam.ellipse.service.registrar.EllipseRegistrar;
import by.epam.ellipse.service.registrar.Observer;

import java.util.List;

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

    public String turnIntoEnty(EllipseRegistrar registrar, int id) {
        Ellipse ellipse = registrar.returnEllipse();
        List<Observer> observers = registrar.returnObservers();

        Ellipse.Point pointA = ellipse.getPointA();
        double aX = pointA.getX();
        double aY = pointA.getY();

        Ellipse.Point pointB = ellipse.getPointB();
        double bX = pointB.getX();
        double bY = pointB.getY();


        Parameters parameters = (Parameters) observers.get(0);
        double area = parameters.getArea();
        double perimeter = parameters.getPerimeter();

        boolean circle = parameters.isCircle();
        boolean crossingX = parameters.isCrossingX();
        boolean crossingY = parameters.isCrossingY();

        return  "Ellipse={id=" + id +
                ", pointA={x=" + aX + ", y=" + aY + "}" +
                ", pointB={x=" + bX + ", y=" + bY + "}}, " +
                "Parameters={area=" + area + ", perimeter=" + perimeter +
                ", circle=" + circle +
                ", crossingX=" + crossingX +
                ", crossingY=" + crossingY +
                "}} ";
    }
}