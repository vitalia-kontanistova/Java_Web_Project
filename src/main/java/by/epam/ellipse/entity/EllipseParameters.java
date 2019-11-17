package by.epam.ellipse.entity;

import by.epam.ellipse.service.EllipseServiceImpl;

public class EllipseParameters {
    private EllipseServiceImpl instance = EllipseServiceImpl.getInstance();

    private Ellipse ellipse;
    private double area;
    private double perimeter;

    public EllipseParameters(Ellipse ellipse) {
        this.ellipse = ellipse;
        this.area = instance.findArea(ellipse);
        this.perimeter = instance.findPerimeter(ellipse);
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
        setArea(ellipse);
        setPerimeter(ellipse);
    }

    public double getArea() {
        return area;
    }

    private void setArea(Ellipse ellipse) {
        this.area = instance.findArea(ellipse);
        ;
    }

    public double getPerimeter() {
        return perimeter;
    }

    private void setPerimeter(Ellipse ellipse) {
        this.perimeter = instance.findPerimeter(ellipse);
        ;
    }

    @Override
    public String toString() {
        return "EllipseParameters{" +
                ", ellipse=" + ellipse +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParameters that = (EllipseParameters) o;

        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0 &&
                ellipse.equals(that.ellipse);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + ellipse.hashCode();
        result = result * 31 + (int) Double.doubleToLongBits(area);
        result = result * 31 + (int) Double.doubleToLongBits(perimeter);
        return result;
    }
}