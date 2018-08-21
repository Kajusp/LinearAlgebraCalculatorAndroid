package com.KayStudio.android.linearalgebracalculator;

public class GeneralFormPlane extends GeneralFormLine {

    public double c;

    public GeneralFormPlane(double aIn, double bIn, double cIn, double dIn){
        super(aIn,  bIn,  dIn);
        c = cIn;
    }

    @Override
    public VectorFormPlane convertToVec(){

        Point3D point1, point2, point3, dir1, dir2;

        if(c!=0){
            point1 = new Point3D(0, 0, (d/c));
            point2 = new Point3D(1,1, ((d-b-a)/c));
            point3 = new Point3D(1,-1, ((d-a+b)/c));
            dir1 = point1.minus(point2);
            dir2 = point1.minus(point3);

        }
        else{
            if (b!=0){
                point1 = new Point3D(0, (d/b), 0);
                point3 = new Point3D(1,(d-a)/b, 0);
                dir1 = new Point3D(0,0,1);
                dir2 = point1.minus(point3);
            }
            else{
                point1 = new Point3D(d/a,0,0);
                dir1 = new Point3D(0,1,0);
                dir2 = new Point3D(0,0,1);
            }
        }

        VectorFormPlane v = new VectorFormPlane(point1.x,point1.y,point1.z,dir1.x,dir1.y,dir1.z,dir2.x,dir2.y,dir2.z);
        return v;
    }

    @Override
    public NormalFormPlane convertToNorm(){

        VectorFormPlane v = convertToVec();
        NormalFormPlane n = v.convertToNorm();

        n.n1=a;
        n.n2=b;
        n.n3=c;

        return n;
    }

}

