package com.KayStudio.android.linearalgebracalculator;

/**
 * Created by kajus on 18.3.12.
 */

public class NormalFormLine {
    public double n1,n2,p1,p2;

    public NormalFormLine(double n1In, double n2In, double p1In, double p2In){
        n1 = n1In;
        n2 = n2In;
        p1 = p1In;
        p2 = p2In;
    }

    public GeneralFormLine convertToGen(){


        double a = n1;
        double b = n2;
        double c = n1*p1 + n2*p2;

        GeneralFormLine g = new GeneralFormLine(a,b,c);
        return g;
    }

    public VectorFormLine convertToVec(){

        GeneralFormLine g = convertToGen();

        VectorFormLine v = g.convertToVec();

        return v;
    }

}
