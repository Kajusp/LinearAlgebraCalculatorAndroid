package com.KayStudio.android.linearalgebracalculator;


public class Point2D {
    public double x,y;

    public Point2D(double a, double b){
        x = a;
        y = b;
    }

    public Point2D minus(Point2D p){

        Point2D temp = new Point2D((x-p.x),(y-p.y));
        return temp;
    }
}
