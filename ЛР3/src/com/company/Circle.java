package com.company;

public class Circle {
    final double Pi = 3.1415926536;

    private double x;
    private double y;
    private double r;

    private double s;
    private double p;

    Circle() {
        x = 0;
        y = 0;
        r = 0;
        s = 0;
        p = 0;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setS() {
        this.s = Pi * Math.pow(this.r, 2);
    }

    public void setP() {
        this.p = 2 * Pi * r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public double getS() {
        return s;
    }

    public double getP() {
        return p;
    }

    public boolean isSame(Circle circle) {
        if(this.x == circle.getX() && this.y == circle.getY() && this.r
                == circle.getR() && this.p == circle.getP() && this.s == circle.getS()) {
            return true;
        }
        else
            return false;
    }


    public void assignment(Circle circle) {
        this.x = circle.getX();
        this.y = circle.getY();
        this.r = circle.getR();
        this.p = circle.getP();
        this.s = circle.getS();
    }

    @Override
    public String toString() {
        return "Circle {\n"
                + "  Center: (" + x + ", " + y + ")\n"
                + "  Radius: " + r + ",\n"
                + "  Perimeter: " + p + "\n"
                + "  Square: " + s + "\n}";
    }
}
