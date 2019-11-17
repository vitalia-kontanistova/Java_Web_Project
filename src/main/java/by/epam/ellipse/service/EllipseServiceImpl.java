package by.epam.ellipse.service;

import by.epam.ellipse.entity.Ellipse;

public class EllipseServiceImpl implements EllipseService {
    public double findPerimeter(Ellipse ellipse) {
        double perimeter = 0;
        double axisX;
        double axisY;

        if (isEllipseExist(ellipse)) {
            axisX = findAxisX(ellipse);
            axisY = findAxisY(ellipse);
            perimeter = 2 * Math.PI * Math.sqrt((axisX * axisX) + (axisY * axisY) / 8);
        }
        return perimeter;
    }

    public double findArea(Ellipse ellipse) {
        double area = 0;
        double axisX;
        double axisY;

        if (isEllipseExist(ellipse)) {
            axisX = findAxisX(ellipse);
            axisY = findAxisY(ellipse);
            area = Math.PI * (axisX / 2) * (axisY / 2);
        }
        return area;
    }

    public boolean isCircle(Ellipse ellipse) {
        double axisX = 0;
        double axisY = 0;
        if (isEllipseExist(ellipse)) {

            axisX = findAxisX(ellipse);
            axisY = findAxisY(ellipse);
        }
        return Math.abs(axisX - axisY) < 0.01;
    }

    public boolean isCrossX(Ellipse ellipse) {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        double xA = 0;
        double xB = 0;

        if (isEllipseExist(ellipse)) {
            xA = a.getX();
            xB = b.getX();
        }

        return (xA * xB) <= 0;
    }

    public boolean isCrossY(Ellipse ellipse) {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        double yA = 0;
        double yB = 0;

        if (isEllipseExist(ellipse)) {
            yA = a.getY();
            yB = b.getY();
        }

        return (yA * yB) <= 0;
    }

    private double findAxisX(Ellipse ellipse) {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        return findDeltaX(a, b);
    }

    private double findAxisY(Ellipse ellipse) {
        Ellipse.Point a = ellipse.getPointA();
        Ellipse.Point b = ellipse.getPointB();

        return findDeltaY(a, b);
    }

    private double findDeltaX(Ellipse.Point a, Ellipse.Point b) {
        double xA = a.getX();
        double xB = b.getX();

        return Math.abs(xA - xB);
    }

    private double findDeltaY(Ellipse.Point a, Ellipse.Point b) {
        double yA = a.getY();
        double yB = b.getY();

        return Math.abs(yA - yB);
    }

    private boolean isEllipseExist(Ellipse ellipse) {
        double axisX = findAxisX(ellipse);
        double axisY = findAxisY(ellipse);

        return axisX > 0.1 && axisY > 0.1;
    }
}