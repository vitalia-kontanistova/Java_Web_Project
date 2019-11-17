package by.epam.ellipse.entity;

public class Ellipse {
    private Point pointA;
    private Point pointB;

    public static class Point {
        private double x;
        private double y;

        public Point() {
            this(0, 0);
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + (int) Double.doubleToLongBits(x);
            result = result * 31 + (int) Double.doubleToLongBits(y);
            return result;
        }
    }

    public Ellipse(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return pointA.equals(ellipse.pointA) &&
                pointB.equals(ellipse.pointB);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + pointA.hashCode();
        result = result * 31 + pointB.hashCode();

        return result;
    }
}