package by.epam.ellipse;

public class Main {
    public static void main(String[] args) {
        double axisX = 5;
        double axisY = 2.5;
        System.out.println(Math.PI * (3 * (axisX + axisY) - Math.sqrt((3 * axisX + axisY) * (axisX + 3 * axisY))));
    }
}