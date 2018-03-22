package com.KayStudio.android.linearalgebracalculator;


public class Point3D extends Point2D {
    public double z;

    public Point3D(double a, double b, double c){
        super(a, b);
        z = c;
    }

    public Point3D minus(Point3D p){

        Point3D temp = new Point3D((x-p.x),(y-p.y), (z-p.z));
        return temp;
    }
}
