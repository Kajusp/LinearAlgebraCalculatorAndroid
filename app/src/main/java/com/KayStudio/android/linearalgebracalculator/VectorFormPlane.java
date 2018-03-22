package com.KayStudio.android.linearalgebracalculator;

/**
 * Created by kajus on 18.3.12.
 */

public class VectorFormPlane extends VectorFormLine {
    public double p3, d3, s1, s2, s3;

    public VectorFormPlane(double p1In, double p2In, double p3In, double d1In, double d2In, double d3In, double s1In, double s2In, double s3In){
        super(p1In,p2In,d1In,d2In);
        p3 = p3In;
        d3 = d3In;
        s1 = s1In;
        s2 = s2In;
        s3 = s3In;

    }

    @Override
    public NormalFormPlane convertToNorm(){
        double n1, n2, n3;

        n1 = d2*s3 - d3*s2;
        n2 = d3*s1 - d1*s3;
        n3 = d1*s2 - d2*s1;

        NormalFormPlane p = new NormalFormPlane(n1,n2,n3,p1,p2,p3);

        return p;
    }

    @Override
    public GeneralFormPlane convertToGen(){
        NormalFormPlane n = convertToNorm();
        GeneralFormPlane g = n.convertToGen();
        return g;
    }


}
