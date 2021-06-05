package com.company;

public class Point {
    private double x;
    private double y;
    //x = 2t
    //y = 3 - 4t^2

    //Конструктор по умолчанию
    Point() {
        x = 0;
        y = 0;
    }

    //Конструктор
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Вычисление координат в данное время исходя из параметрического уравнения параболы
    public void setCoords(int p, int k, double t) {
        this.x = 2*t;
        this.y = p + (k * Math.pow(t, 2));
    }

    //Нахождение скорости точки
    public double getSpeed(int p, int k, double t) {
        System.out.println("From the condition:\n" +                    //Скорость - производная по х из уравнения в общем виде
                "y = " + p + " + (" + k + ") * (x/2)^2");

        double vx = 0, vy = 0, v = 0;

        vx = (2 * t) * 1 / t;                                           //Вычисление производной для уравнения по Х
        vy = (k * Math.pow(t, 2) / t) * 2;                              //Вычисление производной для уравнения по У

        v = Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2));               //Вычисление равнодействующей скорости по теореме Пифагора

        return v;
    }


    public double getAcceleration(int p, int k, double t) {
        double dvy = 0;
        //Т.к. по условию, вторая производная в уравнении по Х, равна 0
        dvy = (((k * Math.pow(t, 2) / t) * 2)) / t;                     //Находим вторую производную в уравнении по У
        //это и будет наше ускорение
        System.out.println("The acceleration with respect to X is 0. ");

        return dvy;
    }

    public double getDistance(Point other){
        double ans;
        ans = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)); //По теореме Пифагора находим расстояние
        return ans;
    }

    public boolean isCrossing(int p1, int p2, int k1, int k2) {
        double ansX = 0, ansY1 = 0, ansY2 = 0;   //Из уравнения по условию находим общий Х и У, если
        if(k2 - k1 == 0) {
            return false;
        }
        ansX = Math.sqrt(2*(p1-p2)/(k2-k1));            // они существуют - траектории пересекаются
        ansY1 = p1 + k1 * Math.pow(ansX / 2, 2);
        ansY2 = p2 + k2 * Math.pow(ansX / 2, 2);
        if(ansY1 == ansY2)
            return true;
        else
            return false;
    }

}

