package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.entity.Parameters;
import by.epam.ellipse.service.EllipseServiceImpl;
import by.epam.ellipse.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class EllipseRegistrar implements Observable {
    private EllipseServiceImpl instance = EllipseServiceImpl.getInstance();

    private List<Observer> ellipses = new ArrayList<>();

    private Ellipse ellipse;
    private Parameters parameters;


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
                this.ellipse.setPointA(pointA);
                this.ellipse.setPointB(pointB);
                this.parameters.setEllipse(this.ellipse);
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
    Parameters returnParameters() {
        return this.parameters;
    }


    @Override
    public String toString() { //НУЖНО ЛИ ЗДЕСЬ (В ТАКИХ КЛАССАХ) ПЕРЕОПРЕДЕЛЯТЬ ЭТИ ТРИ МЕТОДА? ОНИ ВРОДЕ НЕ БИНЫ, НО ДАННЫЕ ХРАНЯТ.
        return "EllipseRegistrar{" +
                ", ellipses=" + ellipses +
                ", ellipse=" + ellipse +
                ", parameters=" + parameters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseRegistrar that = (EllipseRegistrar) o;

        return ellipses.equals(that.ellipses) &&
                ellipse.equals(that.ellipse) &&
                parameters.equals(that.parameters);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + ellipses.hashCode();
        result = result * 31 + ellipse.hashCode();
        result = result * 31 + parameters.hashCode();
        return result;
    }
}