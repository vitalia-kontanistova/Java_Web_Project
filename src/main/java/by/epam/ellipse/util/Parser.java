package by.epam.ellipse.util;

import by.epam.ellipse.dao.exception.DAOexception;

public class Parser {
    private static final Parser instance = new Parser();
    private Parser() {
    }
    public static Parser getInstance() {
        return instance;
    }


    public double[] parseCoordinates(String coordinatesEntry) throws DAOexception {
        DataValidator dataValidator = DataValidator.getInstance();

        try {
            double[] coordinates = new double[4];
            String[] coordinatesStr;

            if (dataValidator.isEllipseValid(coordinatesEntry)) {
                coordinatesStr = coordinatesEntry.split("\\s");
            } else {
                throw new DAOexception("Parser: parseCoordinates(): Incorrect string coordinatesEntry format.");
            }

            int i = 0;
            for (String s : coordinatesStr) {
                coordinates[i] = Double.parseDouble(s);
                i++;
            }
            return coordinates;

        } catch (NullPointerException e) {
            throw new DAOexception("Parser: parseCoordinates(): " + e.getMessage());
        }
    }

//    public int parseId(String objectEntry) throws DAOexception {
//        try {
//            String pointer1 = "id=";
//            String pointer2 = ",";
//            int index1 = objectEntry.indexOf(pointer1) + pointer1.length();
//            int index2 = objectEntry.indexOf(pointer2);
//
//            return Integer.parseInt(objectEntry.substring(index1, index2));
//
//        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException e) {
//            throw new DAOexception("Parser: parseId(): " + e.getMessage());
//        }
//    }

//    public String turnIntoEntry(EllipseObservable registrar, int id) {
//        Ellipse ellipse = registrar.returnEllipse();
//        List<Observer> observers = registrar.returnObservers();
//
//        Ellipse.Point pointA = ellipse.getPointA();
//        double aX = pointA.getX();
//        double aY = pointA.getY();
//
//        Ellipse.Point pointB = ellipse.getPointB();
//        double bX = pointB.getX();
//        double bY = pointB.getY();
//
//
//        Parameters parameters = (Parameters) observers.get(0);
//        double area = parameters.getArea();
//        double perimeter = parameters.getPerimeter();
//
//        boolean circle = parameters.isCircle();
//        boolean crossingX = parameters.isCrossingX();
//        boolean crossingY = parameters.isCrossingY();
//
//        return "Ellipse={id=" + id +
//                ", pointA={x=" + aX + ", y=" + aY + "}" +
//                ", pointB={x=" + bX + ", y=" + bY + "}}, " +
//                "Parameters={area=" + area + ", perimeter=" + perimeter +
//                ", circle=" + circle +
//                ", crossingX=" + crossingX +
//                ", crossingY=" + crossingY +
//                "}} ";
//    }
}