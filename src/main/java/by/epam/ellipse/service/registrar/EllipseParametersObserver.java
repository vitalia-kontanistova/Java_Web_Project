package by.epam.ellipse.service.registrar;

import by.epam.ellipse.entity.Ellipse;

public class EllipseParametersObserver implements Observer { // НУЖНО ЛИ ЭТОТ КЛАСС СОЗДАВАТЬ КАК СИНГЛТОН?

    private EllipseRegistrar ellipseRegistrar;
    private Ellipse ellipse;
    private double area;
    private double perimeter;

    public EllipseParametersObserver(EllipseRegistrar ellipseReg) {
        this.ellipseRegistrar = ellipseReg;
        this.ellipseRegistrar.add(this);
    }

    public Ellipse returnEllipse() {
        return this.ellipse;
    }

    public double returnArea() {
        return this.area;
    }

    public double returnPerimeter() {
        return this.perimeter;
    }

    @Override
    public void update() {
        this.ellipse = ellipseRegistrar.returnEllipse();
        this.area = ellipseRegistrar.returnArea();
        this.perimeter = ellipseRegistrar.returnPerimeter();
    }

    @Override
    public String toString() {//НУЖНО ЛИ ЗДЕСЬ (В ТАКИХ КЛАССАХ) ПЕРЕОПРЕДЕЛЯТЬ ЭТИ ТРИ МЕТОДА? ОНИ ВРОДЕ НЕ БИНЫ, НО ДАННЫЕ ХРАНЯТ.
        return "EllipseParametersObserver{" +
                ", ellipse=" + ellipse +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParametersObserver that = (EllipseParametersObserver) o;

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