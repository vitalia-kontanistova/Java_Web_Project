package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;
import by.epam.ellipse.entity.Parameters;
import by.epam.ellipse.service.exception.ServiceException;


public class EllipseParametersObserver implements Observer { // НУЖНО ЛИ ЭТОТ КЛАСС СОЗДАВАТЬ КАК СИНГЛТОН?

    private EllipseRegistrar ellipseRegistrar;
    private Ellipse ellipse;
    private Parameters parameters;

    public EllipseParametersObserver(EllipseRegistrar ellipseReg) throws ServiceException {
        this.ellipseRegistrar = ellipseReg;
        this.ellipse = this.ellipseRegistrar.returnEllipse();
        try {
            this.parameters = new Parameters(this.ellipse);
        } catch (ServiceException e) {
            throw new ServiceException("EllipseParametersObserver(): " + e.getMessage());
        }

        this.ellipseRegistrar.add(this);

    }

    public Ellipse returnEllipse() {
        return this.ellipse;
    }

    public Parameters returnParameters() {
        return this.parameters;
    }

    @Override
    public void update() throws ServiceException {
        this.ellipse = ellipseRegistrar.returnEllipse();
        try {
            this.parameters.setEllipse(this.ellipse);
        } catch (ServiceException e) {
            throw new ServiceException("EllipseParametersObserver: update(): " + e.getMessage());
        }
    }

    @Override
    public String toString() {//НУЖНО ЛИ ЗДЕСЬ (В ТАКИХ КЛАССАХ) ПЕРЕОПРЕДЕЛЯТЬ ЭТИ ТРИ МЕТОДА? ОНИ ВРОДЕ НЕ БИНЫ, НО ДАННЫЕ ХРАНЯТ.
        return "EllipseParametersObserver{" +
                ", ellipse=" + ellipse +
                ", parameters=" + parameters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParametersObserver that = (EllipseParametersObserver) o;

        return ellipse.equals(that.ellipse) &&
                parameters.equals(that.parameters);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + ellipse.hashCode();
        result = result * 31 + parameters.hashCode();
        return result;
    }
}