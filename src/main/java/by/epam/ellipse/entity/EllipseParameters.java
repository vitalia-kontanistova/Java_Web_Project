package by.epam.ellipse.entity;

public class EllipseParameters {
    private Ellipse ellipse;
    private double area;
    private double perimeter;

    public EllipseParameters(Ellipse ellipse) {
        this.ellipse = ellipse;
        //this.area
        //this.perimeter
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
//        setArea(ellipse);
    }

//    public double getArea() {
//        return area;
//    }
//
//    public void setArea(Ellipse ellipse) {
//        this.area = area;
//    }
//
//    public double getPerimeter() {
//        return perimeter;
//    }
//
//    public void setPerimeter(Ellipse ellipse) {
//        this.perimeter = perimeter;
//    }
}
