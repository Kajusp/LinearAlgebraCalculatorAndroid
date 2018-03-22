package com.KayStudio.android.linearalgebracalculator;

/**
 * Created by kajus on 18.3.12.
 */

public class GeneralFormLine {

    public double a, b, d;

    public GeneralFormLine(double aIn, double bIn, double dIn) {
        a = aIn;
        b = bIn;
        d = dIn;
    }

    public VectorFormLine convertToVec(){


        Point2D p1, p2, dir;


        if (b!=0){
            p1 = new Point2D(0, d/b);
            p2 = new Point2D(1, ((d-a)/b));
        }
        else{
            p1 = new Point2D(d/a, 0);
            p2 = new Point2D((d-b)/a,1);
        }

        dir = p2.minus(p1);

        VectorFormLine v = new VectorFormLine(p1.x, p1.y, p2.x, p2.y);
        return v;
    }

    public NormalFormLine convertToNorm(){

        Point2D p1;
        if (b!=0){
            p1 = new Point2D(0, d/b);
        }
        else{
            p1 = new Point2D(d/a, 0);
        }

        NormalFormLine n = new NormalFormLine(a,b,p1.x,p1.y);

        return n;
    }

}
