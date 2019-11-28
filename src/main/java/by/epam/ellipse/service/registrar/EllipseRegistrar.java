package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.service.EllipseServiceImpl;
import by.epam.ellipse.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class EllipseRegistrar implements Observable {

    private EllipseServiceImpl instance = EllipseServiceImpl.getInstance();

    private List<Observer> observers = new ArrayList<>();
    private Ellipse ellipse;

    public EllipseRegistrar(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() throws ServiceException {
        for (Observer o : observers) {
            try {
                o.update(this.ellipse);
            } catch (ServiceException e) {
                throw new ServiceException("EllipseRegistrar: notifyObservers(): " + e.getMessage());
            }
        }
    }

    public void setEllipse(Ellipse ellipse) throws ServiceException {
        try {
            if (instance.isEllipseExist(ellipse)) {
                this.ellipse = ellipse;
                notifyObservers();
            } else throw new ServiceException("Trying to create invalid ellipse.");
        } catch (ServiceException e) {
            throw new ServiceException("EllipseRegistrar: setEllipse(): " + e.getMessage());
        }
    }

    public void setPoints(Ellipse.Point pointA, Ellipse.Point pointB) throws ServiceException {
        try {
            if (instance.isEllipseExist(pointA, pointB)) {
                this.ellipse.setPointA(pointA);
                this.ellipse.setPointB(pointB);
                notifyObservers();
            } else throw new ServiceException("Trying to create invalid ellipse.");
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

    public Ellipse returnEllipse() {
        return this.ellipse;
    }

    public List<Observer> returnObservers() {
        return this.observers;
    }


    @Override
    public String toString() { //НУЖНО ЛИ ЗДЕСЬ (В ТАКИХ КЛАССАХ) ПЕРЕОПРЕДЕЛЯТЬ ЭТИ ТРИ МЕТОДА? ОНИ ВРОДЕ НЕ БИНЫ, НО ДАННЫЕ ХРАНЯТ.
        return "EllipseRegistrar{" +
                "observers=" + observers +
                ", ellipse=" + ellipse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseRegistrar that = (EllipseRegistrar) o;

        return observers.equals(that.observers) &&
                ellipse.equals(that.ellipse);
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + observers.hashCode();
        result = result * 31 + ellipse.hashCode();
        return result;
    }
}