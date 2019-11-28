package by.epam.ellipse.entity;

import by.epam.ellipse.service.ParametersServiceImpl;
import by.epam.ellipse.service.exception.ServiceException;

public class Parameters {
    private ParametersServiceImpl instance = ParametersServiceImpl.getInstance();

    private Ellipse ellipse;
    private double area;
    private double perimeter;
    private boolean circle;
    private boolean crossingX;
    private boolean crossingY;


    public Parameters(Ellipse ellipse) throws ServiceException {
        try {
            setEllipse(ellipse);
        } catch (ServiceException e) {
            throw new ServiceException("Parameters: Parameters(): " + e.getMessage());
        }
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) throws ServiceException {
        this.ellipse = ellipse;
        try {
            setArea(this.ellipse);
            setPerimeter(this.ellipse);
            setCircle(this.ellipse);
            setCrossingX(this.ellipse);
            setCrossingY(this.ellipse);
        } catch (ServiceException e) {
            throw new ServiceException("Parameters: setEllipse(): " + e.getMessage());
        }
    }


    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public boolean isCircle() {
        return circle;
    }

    public boolean isCrossingX() {
        return crossingX;
    }

    public boolean isCrossingY() {
        return crossingY;
    }


    private void setArea(Ellipse ellipse) throws ServiceException {
        this.area = instance.findArea(ellipse);
    }

    private void setPerimeter(Ellipse ellipse) throws ServiceException {
        this.perimeter = instance.findPerimeter(ellipse);
    }

    private void setCircle(Ellipse ellipse) throws ServiceException {
        this.circle = instance.isCircle(ellipse);
    }

    private void setCrossingX(Ellipse ellipse) throws ServiceException {
        this.crossingX = instance.isCrossX(ellipse);
    }

    private void setCrossingY(Ellipse ellipse) throws ServiceException {
        this.crossingY = instance.isCrossY(ellipse);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "ellipse=" + ellipse +
                ", area=" + area +
                ", perimeter=" + perimeter +
                ", circle=" + circle +
                ", crossingX=" + crossingX +
                ", crossingY=" + crossingY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0 &&
                ellipse.equals(that.ellipse) &&
                circle == that.circle &&
                crossingX == that.crossingX &&
                crossingY == that.crossingY;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + (int) Double.doubleToLongBits(area);
        result = result * 31 + (int) Double.doubleToLongBits(perimeter);
        result = result * 31 + ellipse.hashCode();
        result = result * 31 + ((circle) ? 1 : 0);
        result = result * 31 + ((crossingX) ? 1 : 0);
        result = result * 31 + ((crossingY) ? 1 : 0);
        return result;
    }
}