package by.epam.ellipse;


public class Main {
    public static void main(String[] args) {

        double aX = 0;
        double aY = 0;
        double bX = 5;
        double bY = 10;

        int id = 5;
        double area = 15;
        double perimeter = 78;
        boolean circle = false;
        boolean crossingX = true;
        boolean crossingY = true;

        String entry = "Ellipse={id=" + id +
                ", pointA={x=" + aX + ", y=" + aY + "}" +
                ", pointB={x=" + bX + ", y=" + bY + "}}, " +
                "Parameters={area=" + area + ", perimeter=" + perimeter +
                ", circle=" + circle +
                ", crossingX=" + crossingX +
                ", crossingY=" + crossingY +
                "}} ";
        System.out.println(entry);
    }
}