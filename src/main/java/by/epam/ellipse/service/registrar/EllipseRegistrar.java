package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.EllipseServiceImpl;
import by.epam.ellipse.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class EllipseRegistrar implements Observable {
    private EllipseServiceImpl instance = EllipseServiceImpl.getInstance();

    private List<Observer> ellipses = new ArrayList<>();

    private Ellipse ellipse;
    private double area;
    private double perimeter;

    public EllipseRegistrar() {
    }

    @Override
    public void add(Observer observer) {
        ellipses.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        ellipses.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : ellipses) {
            o.update();
        }
    }

    public void setPoints(Ellipse.Point pointA, Ellipse.Point pointB) throws ServiceException {
        try {
            if (instance.isEllipseExist(pointA, pointB)) {
                this.ellipse = new Ellipse(pointA, pointB);
                this.area = instance.findArea(this.ellipse);
                this.perimeter = instance.findPerimeter(this.ellipse);

                notifyObservers();
            }
        } catch (ServiceException e) {
            throw new ServiceException("EllipseRegistrar: setPoints(): " + e.getMessage());
        }
    }

    public void setPointA(Ellipse.Point pointA) throws ServiceException {
        setPoints(pointA, ellipse.getPointB());
    }


    public void setPointB(Ellipse.Point pointB) throws ServiceException {
        setPoints(ellipse.getPointA(), pointB);
    }

    //package private
    Ellipse returnEllipse() {
        return this.ellipse;
    }

    //package private
    double returnArea() {
        return this.area;
    }

    //package private
    double returnPerimeter() {
        return this.perimeter;
    }

    @Override
    public String toString() { //НУЖНО ЛИ ЗДЕСЬ (В ТАКИХ КЛАССАХ) ПЕРЕОПРЕДЕЛЯТЬ ЭТИ ТРИ МЕТОДА? ОНИ ВРОДЕ НЕ БИНЫ, НО ДАННЫЕ ХРАНЯТ.
        return "EllipseRegistrar{" +
                ", ellipse=" + ellipse +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseRegistrar that = (EllipseRegistrar) o;

        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0 &&
                ellipse.equals(that.ellipse);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + (int) Double.doubleToLongBits(area);
        result = result * 31 + (int) Double.doubleToLongBits(perimeter);
        result = result * 31 + ellipse.hashCode();
        return result;
    }
}