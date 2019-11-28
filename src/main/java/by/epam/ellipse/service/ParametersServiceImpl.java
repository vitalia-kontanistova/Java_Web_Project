package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.exception.ServiceException;

public class ParametersServiceImpl implements ParametersService {
    private static ParametersServiceImpl instance = new ParametersServiceImpl();

    private ParametersServiceImpl() {
    }

    public static ParametersServiceImpl getInstance() {
        return instance;
    }


    @Override
    public double findPerimeter(Ellipse ellipse) throws ServiceException {
        EllipseServiceImpl instance = EllipseServiceImpl.getInstance();
        double perimeter = 0;
        double halfAxisX;
        double halfAxisY;
        try {
            if (instance.isEllipseExist(ellipse)) {
                halfAxisX = findDeltaX(ellipse) / 2;
                halfAxisY = findDeltaY(ellipse) / 2;
                perimeter = Math.PI * (3 * (halfAxisX + halfAxisY) - Math.sqrt((3 * halfAxisX + halfAxisY) * (halfAxisX + 3 * halfAxisY)));
            } else throw new ServiceException("Trying to create invalid ellipse.");
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: findPerimeter(): " + e.getMessage());
        }
        return perimeter;
    }

    @Override
    public double findArea(Ellipse ellipse) throws ServiceException {
        EllipseServiceImpl instance = EllipseServiceImpl.getInstance();
        double area = 0;
        double halfAxisX;
        double halfAxisY;

        try {
            if (instance.isEllipseExist(ellipse)) {
                halfAxisX = findDeltaX(ellipse) / 2;
                halfAxisY = findDeltaY(ellipse) / 2;
                area = Math.PI * (halfAxisX) * (halfAxisY);
            } else throw new ServiceException("Trying to create invalid ellipse.");
        } catch (NullPointerException e) {
            throw new ServiceException("EllipseServiceImpl: findArea(): " + e.getMessage());
        }
        return area;
    }


    private EllipseServiceImpl ellipseServiceImpl = EllipseServiceImpl.getInstance();

    @Override
    public boolean isCircle(Ellipse ellipse) throws ServiceException {
        double axisX;
        double axisY;
        try {
            if (ellipseServiceImpl.isEllipseExist(ellipse)) {

                axisX = findDeltaX(ellipse);
                axisY = findDeltaY(ellipse);
            } else throw new ServiceException("Trying to create invalid ellipse.");
        } catch (NullPointerException e) {
            throw new ServiceException("ParametersServiceImpl: isCircle(): " + e.getMessage());
        }
        return Math.abs(axisX - axisY) < 0.01;
    }

    @Override
    public boolean isCrossX(Ellipse ellipse) throws ServiceException {
        Ellipse.Point a;
        Ellipse.Point b;

        double xA;
        double xB;

        try {
            a = ellipse.getPointA();
            b = ellipse.getPointB();
            if (ellipseServiceImpl.isEllipseExist(ellipse)) {
                xA = a.getX();
                xB = b.getX();
            } else throw new ServiceException("Trying to create invalid ellipse.");
        } catch (NullPointerException e) {
            throw new ServiceException("ParametersServiceImpl: isCrossX(): " + e.getMessage());
        }
        return (xA * xB) <= 0;
    }

    @Override
    public boolean isCrossY(Ellipse ellipse) throws ServiceException {
        Ellipse.Point a;
        Ellipse.Point b;

        double yA;
        double yB;

        try {
            a = ellipse.getPointA();
            b = ellipse.getPointB();

            if (ellipseServiceImpl.isEllipseExist(ellipse)) {
                yA = a.getY();
                yB = b.getY();
            } else throw new ServiceException("Trying to create invalid ellipse.");
        } catch (NullPointerException e) {
            throw new ServiceException("ParametersServiceImpl: isCrossX(): " + e.getMessage());
        }

        return (yA * yB) <= 0;
    }

//package private
     double findDeltaX(Ellipse ellipse) throws NullPointerException {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        return findDeltaX(a, b);
    }
//package private
     double findDeltaY(Ellipse ellipse) throws NullPointerException {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        return findDeltaY(a, b);
    }

    private double findDeltaX(Ellipse.Point a, Ellipse.Point b) throws NullPointerException {
        double xA = a.getX();
        double xB = b.getX();

        return Math.abs(xA - xB);
    }

    private double findDeltaY(Ellipse.Point a, Ellipse.Point b) throws NullPointerException {
        double yA = a.getY();
        double yB = b.getY();

        return Math.abs(yA - yB);
    }

}