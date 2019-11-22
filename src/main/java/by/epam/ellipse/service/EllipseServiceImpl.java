package by.epam.ellipse.service;

import by.epam.ellipse.dao.exception.DAOexception;
import by.epam.ellipse.dao.util.EllipseParser;
import by.epam.ellipse.dao.util.FileInfoExtractor;
import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;


public class EllipseServiceImpl implements EllipseService {
    private static EllipseServiceImpl instance = new EllipseServiceImpl();

    private EllipseServiceImpl() {
    }

    public static EllipseServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Ellipse createFromString(String ellipseStr) throws ServiceException {
        EllipseParser instance = EllipseParser.getInstance();
        double[] coordinates;

        Ellipse ellipse;
        Ellipse.Point pointA;
        Ellipse.Point pointB;

        try {
            coordinates = instance.parseCoordinates(ellipseStr);
            pointA = new Ellipse.Point(coordinates[0], coordinates[1]);
            pointB = new Ellipse.Point(coordinates[2], coordinates[3]);
            ellipse = new Ellipse(pointA, pointB);

        } catch (DAOexception e) {
            throw new ServiceException("EllipseServiceImpl: createFromString(): " + e.getMessage());
        }
        return ellipse;
    }

    public List<Ellipse> createFromList() throws ServiceException { //REFACTOR???
        FileInfoExtractor instance = FileInfoExtractor.getInstance();

        List<Ellipse> ellipses = new ArrayList<>();
        List<String> ellipsesStr;

        try {
            ellipsesStr = instance.extractEntriesFromFile("ellipse.base");
            for (String s : ellipsesStr) {
                ellipses.add(createFromString(s));
            }

        } catch (DAOexception e) {
            throw new ServiceException("EllipseServiceImpl: createFromString(): " + e.getMessage());
        }
        return ellipses;
    }

    @Override
    public boolean isCircle(Ellipse ellipse) throws ServiceException {
        double axisX = 0;
        double axisY = 0;
        try {
            if (isEllipseExist(ellipse)) {

                axisX = findDeltaX(ellipse);
                axisY = findDeltaY(ellipse);
            }
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: isCircle(): " + e.getMessage());
        }
        return Math.abs(axisX - axisY) < 0.01;
    }

    @Override
    public boolean isCrossX(Ellipse ellipse) throws ServiceException {
        Ellipse.Point a;
        Ellipse.Point b;

        double xA = 0;
        double xB = 0;

        try {
            a = ellipse.getPointA();
            b = ellipse.getPointB();
            if (isEllipseExist(ellipse)) {
                xA = a.getX();
                xB = b.getX();
            }
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: isCrossX(): " + e.getMessage());
        }
        return (xA * xB) <= 0;
    }

    @Override
    public boolean isCrossY(Ellipse ellipse) throws ServiceException {
        Ellipse.Point a;
        Ellipse.Point b;

        double yA = 0;
        double yB = 0;

        try {
            a = ellipse.getPointA();
            b = ellipse.getPointB();

            if (isEllipseExist(ellipse)) {
                yA = a.getY();
                yB = b.getY();
            }
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: isCrossX(): " + e.getMessage());
        }

        return (yA * yB) <= 0;
    }

    @Override
    public boolean isEllipseExist(Ellipse ellipse) throws ServiceException {
        double axisX = 0;
        double axisY = 0;

        try {
            axisX = findDeltaX(ellipse);
            axisY = findDeltaY(ellipse);
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: isEllipseExist(): " + e.getMessage());
        }
        return axisX > 0.1 && axisY > 0.1;
    }

    @Override
    public boolean isEllipseExist(Ellipse.Point pointA, Ellipse.Point pointB) throws ServiceException {
        double axisX;
        double axisY;

        try {
            axisX = findDeltaX(pointA, pointB);
            axisY = findDeltaY(pointA, pointB);

        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: isEllipseExist(): " + e.getMessage());
        }

        return axisX > 0.1 && axisY > 0.1;
    }

    //package private
    double findDeltaX(Ellipse ellipse) {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        return findDeltaX(a, b);
    }

    //package private
    double findDeltaY(Ellipse ellipse) {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        return findDeltaY(a, b);
    }

    //package private
    double findDeltaX(Ellipse.Point a, Ellipse.Point b) {
        double xA = a.getX();
        double xB = b.getX();

        return Math.abs(xA - xB);
    }

    //package private
    double findDeltaY(Ellipse.Point a, Ellipse.Point b) {
        double yA = a.getY();
        double yB = b.getY();

        return Math.abs(yA - yB);
    }
}