package com.KayStudio.android.linearalgebracalculator;

/**
 * Created by kajus on 18.3.12.
 */

public class NormalFormPlane extends NormalFormLine {

    public double n3, p3;

    public NormalFormPlane(double n1In, double n2In, double n3In, double p1In, double p2In, double p3In){
        super(n1In,n2In,p1In,p2In);
        n3 = n3In;
        p3 = p3In;
    }

    @Override
    public GeneralFormPlane convertToGen(){

        double a,b,c,d;

        a = n1;
        b = n2;
        c = n3;
        d = n1*p1 + n2*p2 + n3*p3;

        GeneralFormPlane p = new GeneralFormPlane(a,b,c,d);
        return p;
    }

    @Override
    public VectorFormPlane convertToVec(){
        GeneralFormPlane p = convertToGen();
        VectorFormPlane v = p.convertToVec();
        return v;
    }
}
