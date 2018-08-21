package com.KayStudio.android.linearalgebracalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LinesPlanesForm extends AppCompatActivity {

    int selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines_planes_form);

        Spinner sp = (Spinner) findViewById(R.id.select);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout planeGen = (LinearLayout) findViewById(R.id.planeGen);
                LinearLayout planeNorm = (LinearLayout) findViewById(R.id.planeNorm);
                LinearLayout planeVec = (LinearLayout) findViewById(R.id.planeVec);

                LinearLayout lineGen = (LinearLayout) findViewById(R.id.lineGen);
                LinearLayout lineNorm = (LinearLayout) findViewById(R.id.lineNorm);
                LinearLayout lineVec = (LinearLayout) findViewById(R.id.lineVec);

                selection = position;

                switch (position) {
                    case 0:
                        lineGen.setVisibility(view.VISIBLE);
                        lineNorm.setVisibility(view.INVISIBLE);
                        lineVec.setVisibility(view.INVISIBLE);
                        planeGen.setVisibility(view.INVISIBLE);
                        planeNorm.setVisibility(view.INVISIBLE);
                        planeVec.setVisibility(view.INVISIBLE);
                        break;
                    case 1:
                        lineGen.setVisibility(view.INVISIBLE);
                        lineNorm.setVisibility(view.VISIBLE);
                        lineVec.setVisibility(view.INVISIBLE);
                        planeGen.setVisibility(view.INVISIBLE);
                        planeNorm.setVisibility(view.INVISIBLE);
                        planeVec.setVisibility(view.INVISIBLE);
                        break;
                    case 2:
                        lineGen.setVisibility(view.INVISIBLE);
                        lineNorm.setVisibility(view.INVISIBLE);
                        lineVec.setVisibility(view.VISIBLE);
                        planeGen.setVisibility(view.INVISIBLE);
                        planeNorm.setVisibility(view.INVISIBLE);
                        planeVec.setVisibility(view.INVISIBLE);
                        break;
                    case 3:
                        lineGen.setVisibility(view.INVISIBLE);
                        lineNorm.setVisibility(view.INVISIBLE);
                        lineVec.setVisibility(view.INVISIBLE);
                        planeGen.setVisibility(view.VISIBLE);
                        planeNorm.setVisibility(view.INVISIBLE);
                        planeVec.setVisibility(view.INVISIBLE);
                        break;
                    case 4:
                        lineGen.setVisibility(view.INVISIBLE);
                        lineNorm.setVisibility(view.INVISIBLE);
                        lineVec.setVisibility(view.INVISIBLE);
                        planeGen.setVisibility(view.INVISIBLE);
                        planeNorm.setVisibility(view.VISIBLE);
                        planeVec.setVisibility(view.INVISIBLE);
                        break;
                    case 5:
                        lineGen.setVisibility(view.INVISIBLE);
                        lineNorm.setVisibility(view.INVISIBLE);
                        lineVec.setVisibility(view.INVISIBLE);
                        planeGen.setVisibility(view.INVISIBLE);
                        planeNorm.setVisibility(view.INVISIBLE);
                        planeVec.setVisibility(view.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void calculateLinePlaneForm(View view) {
        switch (selection) {
            case 0:
                lineGenConvert();
                break;
            case 1:
                lineNormConvert();
                break;
            case 2:
                lineVecConvert();
                break;
            case 3:
                planeGenConvert();
                break;
            case 4:
                planeNormConvert();
                break;
            case 5:
                planeVecConvert();
                break;
        }
    }

    private void lineGenConvert() {

        EditText aIn, bIn, cIn;
        double a, b, c;
        try {
            aIn = (EditText) findViewById(R.id.aGenConvLine);
            bIn = (EditText) findViewById(R.id.bGenConvLine);
            cIn = (EditText) findViewById(R.id.cGenConvLine);
            a = Double.parseDouble(aIn.getText().toString());
            b = Double.parseDouble(bIn.getText().toString());
            c = Double.parseDouble(cIn.getText().toString());

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Incorrect input.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if ((a == b && a == 0)) {
            Toast.makeText(getApplicationContext(), "Please enter a valid line.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        TextView genToNormLine = (TextView) findViewById(R.id.genToNormLine);
        TextView genToVecLine = (TextView) findViewById(R.id.genToVecLine);

        GeneralFormLine genLine = new GeneralFormLine(a,b,c);

        VectorFormLine vecLine = genLine.convertToVec();
        NormalFormLine normLine = genLine.convertToNorm();

        genToNormLine.setText("The normal form is : nx = np, where n = [" + normLine.n1 + ", " + normLine.n2 + "] and p = [" + String.format("%.2f", normLine.p1) + ", " + String.format("%.2f", normLine.p2) + "]");
        genToVecLine.setText("The vector form is : p + td, where p = [" + String.format("%.2f", vecLine.p1) + ", " + String.format("%.2f", vecLine.p2) + "] and d = [" + String.format("%.2f", vecLine.d1) + ", " + String.format("%.2f", vecLine.d2) + "]");

    }

    private void lineVecConvert() {
        EditText p1In, p2In, d1In, d2In;

        double p1, p2, d1, d2;

        p1In = (EditText) findViewById(R.id.x1VecConvLine);
        p2In = (EditText) findViewById(R.id.y1VecConvLine);
        d1In = (EditText) findViewById(R.id.x2VecConvLine);
        d2In = (EditText) findViewById(R.id.y2VecConvLine);

        try {
            p1 = Double.parseDouble(p1In.getText().toString());
            p2 = Double.parseDouble(p2In.getText().toString());
            d1 = Double.parseDouble(d1In.getText().toString());
            d2 = Double.parseDouble(d2In.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Incorrect input.",
                    Toast.LENGTH_LONG).show();
            return;

        }

        if(d1==0 && d2==0){
            Toast.makeText(getApplicationContext(), "Please enter a valid line.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        TextView vecToNormLine = (TextView) findViewById(R.id.vecToNormLine);
        TextView vecToGenLine = (TextView) findViewById(R.id.vecToGenLine);

        VectorFormLine vecLine = new VectorFormLine(p1,p2,d1,d2);
        GeneralFormLine genLine = vecLine.convertToGen();
        NormalFormLine normLine = vecLine.convertToNorm();

        vecToNormLine.setText("The normal form is : nx = np, where n = [" + normLine.n1 + ", " + normLine.n2 + "] and p = [" + String.format("%.2f", normLine.p1) + ", " + String.format("%.2f", normLine.p2) + "]");
        vecToGenLine.setText("The general form is : " + genLine.a + "x + " + genLine.b + "y = " + genLine.d);
    }

    private void lineNormConvert(){
        EditText n1In, n2In, p1In, p2In;

        double n1,n2,p1,p2;

        n1In = (EditText) findViewById(R.id.x1NormConvLine);
        n2In = (EditText) findViewById(R.id.y1NormConvLine);
        p1In = (EditText) findViewById(R.id.x2NormConvLine);
        p2In = (EditText) findViewById(R.id.y2NormConvLine);

        try {
            n1 = Double.parseDouble(n1In.getText().toString());
            n2 = Double.parseDouble(n2In.getText().toString());
            p1 = Double.parseDouble(p1In.getText().toString());
            p2 = Double.parseDouble(p2In.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Incorrect input.",
                    Toast.LENGTH_LONG).show();
            return;

        }

        if(n1==0 && n2==0){
            Toast.makeText(getApplicationContext(), "Please enter a valid line.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        TextView normToGenLine = (TextView) findViewById(R.id.normToGenLine);
        TextView normToVecLine = (TextView) findViewById(R.id.normToVecLine);

        NormalFormLine normLine = new NormalFormLine(n1,n2,p1,p2);
        VectorFormLine vecLine = normLine.convertToVec();
        GeneralFormLine genLine = normLine.convertToGen();

        normToGenLine.setText("The general form is : " + genLine.a + "x + " + genLine.b + "y = " + genLine.d);
        normToVecLine.setText("The vector form is : p + td, where p = [" + String.format("%.2f", vecLine.p1) + ", " + String.format("%.2f", vecLine.p2) + "] and d = [" + String.format("%.2f", vecLine.d1) + ", " + String.format("%.2f", vecLine.d2) + "]");

    }

    private void planeGenConvert(){
        EditText aIn, bIn, cIn, dIn;
        double a,b,c,d;

        aIn = (EditText) findViewById(R.id.aGenConv);
        bIn = (EditText) findViewById(R.id.bGenConv);
        cIn = (EditText) findViewById(R.id.cGenConv);
        dIn = (EditText) findViewById(R.id.dGenConv);

        try {
            a = Double.parseDouble(aIn.getText().toString());
            b = Double.parseDouble(bIn.getText().toString());
            c = Double.parseDouble(cIn.getText().toString());
            d = Double.parseDouble(dIn.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Incorrect input.",
                    Toast.LENGTH_LONG).show();
            return;

        }

        if(a==0 && b==0 && c==0){
            Toast.makeText(getApplicationContext(), "Please enter a valid plane.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        TextView genToNormPlane = findViewById(R.id.genToNormPlane);
        TextView genToVecPlane = findViewById(R.id.genToVecPlane);

        GeneralFormPlane genPlane = new GeneralFormPlane(a,b,c,d);
        NormalFormPlane normPlane = genPlane.convertToNorm();
        VectorFormPlane vecPlane = genPlane.convertToVec();

        genToNormPlane.setText("The normal form is : nx = np, where n = [" + normPlane.n1 + ", " + normPlane.n2 + ", " + normPlane.n3 + "] and p = [" + String.format("%.2f", normPlane.p1) + ", " + String.format("%.2f", normPlane.p2) + ", " + String.format("%.2f", normPlane.p3) + "]");
        genToVecPlane.setText("The vector form is : p + td + ks, where p = [" + String.format("%.2f", vecPlane.p1) + ", " + String.format("%.2f", vecPlane.p2) + ", " + String.format("%.2f", vecPlane.p3) +  "] and d = [" + String.format("%.2f", vecPlane.d1) + ", " + String.format("%.2f", vecPlane.d2)+ ", " + String.format("%.2f", vecPlane.d3) + "] and s = [" + String.format("%.2f", vecPlane.s1) + ", " + String.format("%.2f", vecPlane.s2)+ ", " + String.format("%.2f", vecPlane.s3) + "]");

    }

    private void planeNormConvert(){
        EditText n1In, n2In, n3In, p1In, p2In, p3In;

        double n1,n2,n3,p1,p2,p3;

        n1In = (EditText) findViewById(R.id.x1NormConv);
        n2In = (EditText) findViewById(R.id.y1NormConv);
        n3In = (EditText) findViewById(R.id.z1NormConv);

        p1In = (EditText) findViewById(R.id.x2NormConv);
        p2In = (EditText) findViewById(R.id.y2NormConv);
        p3In = (EditText) findViewById(R.id.z2NormConv);

        try {
            n1 = Double.parseDouble(n1In.getText().toString());
            n2 = Double.parseDouble(n2In.getText().toString());
            n3 = Double.parseDouble(n3In.getText().toString());

            p1 = Double.parseDouble(p1In.getText().toString());
            p2 = Double.parseDouble(p2In.getText().toString());
            p3 = Double.parseDouble(p3In.getText().toString());

        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Incorrect input.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (n1==0 && n2==0 && n3==0){
            Toast.makeText(getApplicationContext(), "Please enter a valid plane.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        TextView normToGenPlane = (TextView) findViewById(R.id.normToGenPlane);
        TextView normToVecPlane = (TextView) findViewById(R.id.normToVecPlane);

        NormalFormPlane normPlane = new NormalFormPlane(n1,n2,n3,p1,p2,p3);
        GeneralFormPlane genPlane = normPlane.convertToGen();
        VectorFormPlane vecPlane = normPlane.convertToVec();

        normToGenPlane.setText("The general form is : " + genPlane.a + "x + " + genPlane.b + "y + " + genPlane.c + "z = " + genPlane.d);
        normToVecPlane.setText("The vector form is : p + td + ks, where p = [" + String.format("%.2f", vecPlane.p1) + ", " + String.format("%.2f", vecPlane.p2) + ", " + String.format("%.2f", vecPlane.p3) +  "] and d = [" + String.format("%.2f", vecPlane.d1) + ", " + String.format("%.2f", vecPlane.d2)+ ", " + String.format("%.2f", vecPlane.d3) + "] and s = [" + String.format("%.2f", vecPlane.s1) + ", " + String.format("%.2f", vecPlane.s2)+ ", " + String.format("%.2f", vecPlane.s3) + "]");

    }

    private void planeVecConvert(){ //pds
        EditText p1In,p2In,p3In,d1In,d2In,d3In,s1In,s2In,s3In;
        double p1,p2,p3,d1,d2,d3,s1,s2,s3;

        p1In = (EditText) findViewById(R.id.x1VecConv);
        p2In = (EditText) findViewById(R.id.y1VecConv);
        p3In = (EditText) findViewById(R.id.z1VecConv);

        d1In = (EditText) findViewById(R.id.x2VecConv);
        d2In = (EditText) findViewById(R.id.y2VecConv);
        d3In = (EditText) findViewById(R.id.z2VecConv);

        s1In = (EditText) findViewById(R.id.x3VecConv);
        s2In = (EditText) findViewById(R.id.y3VecConv);
        s3In = (EditText) findViewById(R.id.z3VecConv);

        try {

            p1 = Double.parseDouble(p1In.getText().toString());
            p2 = Double.parseDouble(p2In.getText().toString());
            p3 = Double.parseDouble(p3In.getText().toString());

            d1 = Double.parseDouble(d1In.getText().toString());
            d2 = Double.parseDouble(d2In.getText().toString());
            d3 = Double.parseDouble(d3In.getText().toString());

            s1 = Double.parseDouble(s1In.getText().toString());
            s2 = Double.parseDouble(s2In.getText().toString());
            s3 = Double.parseDouble(s3In.getText().toString());

        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Incorrect input.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if( (d1==0 && d2==0 && d3==0) || (s1==0 && s2==0 && s3==0) || ((d2*s3 == d3*s2) &&  (d3*s1 == d1*s3) && (d1*s2 == d2*s1)) ){
            Toast.makeText(getApplicationContext(), "Please enter a valid plane.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        TextView vecToGenPlane = (TextView) findViewById(R.id.vecToGenPlane);
        TextView vecToNormPlane = (TextView) findViewById(R.id.vecToNormPlane);

        VectorFormPlane vecPlane = new VectorFormPlane(p1,p2,p3,d1,d2,d3,s1,s2,s3);
        NormalFormPlane normPlane = vecPlane.convertToNorm();
        GeneralFormPlane genPlane = vecPlane.convertToGen();

        vecToGenPlane.setText("The general form is : " + genPlane.a + "x + " + genPlane.b + "y + " + genPlane.c + "z = " + genPlane.d);
        vecToNormPlane.setText("The normal form is : nx = np, where n = [" + normPlane.n1 + ", " + normPlane.n2 + ", " + normPlane.n3 + "] and p = [" + String.format("%.2f", normPlane.p1) + ", " + String.format("%.2f", normPlane.p2) + ", " + String.format("%.2f", normPlane.p3) + "]");
    }
}