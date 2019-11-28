package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.entity.Parameters;
import by.epam.ellipse.service.exception.ServiceException;


public class EllipseParametersObserver implements Observer {

    private Parameters parameters;

    public EllipseParametersObserver(EllipseRegistrar ellipseRegistrar) throws ServiceException {
        try {
            this.parameters = new Parameters(ellipseRegistrar.returnEllipse());
        } catch (ServiceException e) {
            throw new ServiceException("EllipseParametersObserver(): " + e.getMessage());
        }

        ellipseRegistrar.add(this);
    }


    public Parameters returnParameters() {
        return this.parameters;
    }

    @Override
    public void update(Ellipse ellipse) throws ServiceException {
        try {
            this.parameters.setEllipse(ellipse);
        } catch (ServiceException e) {
            throw new ServiceException("EllipseParametersObserver: update(): " + e.getMessage());
        }
    }


    @Override
    public String toString() {//НУЖНО ЛИ ЗДЕСЬ (В ТАКИХ КЛАССАХ) ПЕРЕОПРЕДЕЛЯТЬ ЭТИ ТРИ МЕТОДА? ОНИ ВРОДЕ НЕ БИНЫ, НО ДАННЫЕ ХРАНЯТ.
        return "EllipseParametersObserver{" +
                ", parameters=" + parameters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParametersObserver that = (EllipseParametersObserver) o;

        return parameters.equals(that.parameters);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + parameters.hashCode();
        return result;
    }
}