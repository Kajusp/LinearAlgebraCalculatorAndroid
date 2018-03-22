package com.KayStudio.android.linearalgebracalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AngleBetweenPlanes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle_between_planes);
    }

    public void calculate(View view){

        EditText E1,E2,E3,E4,E5,E6,E7,E8;
        double a1, a2, b1, b2, c1, c2, d1, d2;

        try{
            E1 = (EditText) findViewById(R.id.a1);
        }
        catch (Exception e){
            return;
        }



        try {

            E1 = (EditText) findViewById(R.id.a1);
            E2 = (EditText) findViewById(R.id.a2);
            E3 = (EditText) findViewById(R.id.b1);
            E4 = (EditText) findViewById(R.id.b2);
            E5 = (EditText) findViewById(R.id.c1);
            E6 = (EditText) findViewById(R.id.c2);
            E7 = (EditText) findViewById(R.id.d1);
            E8 = (EditText) findViewById(R.id.d1);

                a1 = Double.parseDouble(E1.getText().toString());

                a2 = Double.parseDouble(E2.getText().toString());

                b1 = Double.parseDouble(E3.getText().toString());

                b2 = Double.parseDouble(E4.getText().toString());

                c1 = Double.parseDouble(E5.getText().toString());

                c2 = Double.parseDouble(E6.getText().toString());

                d1 = Double.parseDouble(E7.getText().toString());

                d2 = Double.parseDouble(E8.getText().toString());
            }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid input",
                    Toast.LENGTH_LONG).show();
            return;
        }


        if (Math.sqrt(a1*a1 + b1*b1 + c1*c1)*Math.sqrt(a2*a2 + b2*b2 + c2*c2)==0){
            Toast.makeText(getApplicationContext(), "Not a plane",
                    Toast.LENGTH_LONG).show();
            return;
        }

        double cos = (Math.abs(a1*a2 + b1*b2 + c1*c2))/(Math.sqrt(a1*a1 + b1*b1 + c1*c1)*Math.sqrt(a2*a2 + b2*b2 + c2*c2));


        TextView tw = (TextView) findViewById(R.id.cos);
        String result = String.format("%.2f", cos);
        tw.setText("Cos a = " + result);

        if (cos == -1 || cos==1) {
            tw = (TextView) findViewById(R.id.ang);
            tw.setText("Planes are parallel");
        }
        else {
            double val1 = Math.acos(cos);
            double val2 = Math.toDegrees(val1);
            tw = (TextView) findViewById(R.id.ang);

            String outVal1 = String.format("%.2f", val1);
            String outVal2 = String.format("%.2f", val2);
            tw.setText("a = " + outVal1 + " radians or " + outVal2 + " degrees");
        }
    }
}
