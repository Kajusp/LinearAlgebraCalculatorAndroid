package com.KayStudio.android.linearalgebracalculator;

public class VectorFormLine {
    public double p1,p2,d1,d2;

    public VectorFormLine(double p1In, double p2In, double d1In, double d2In){
        p1 = p1In;
        p2 = p2In;
        d1 = d1In;
        d2 = d2In;
    }

    public NormalFormLine convertToNorm(){

        double n1, n2=1;

        if (d1!=0) {

            n1 = -n2 * d2 / d1;

            if(n1<1 && n1>-1 && n1!=0){
                n2=n2/n1;
                n1=1;
            }
        }
        else{
            n1=1;
            n2=0;
        }

        NormalFormLine n = new NormalFormLine(n1,n2,p1,p2);
        return n;
    }

    public GeneralFormLine convertToGen(){

        NormalFormLine n = convertToNorm();
        GeneralFormLine g = n.convertToGen();

        return g;
    }
}
