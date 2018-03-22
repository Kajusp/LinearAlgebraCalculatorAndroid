package com.KayStudio.android.linearalgebracalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class EigenCalculationAnswer extends AppCompatActivity {

    ArrayList<TextView> matrixOutputs = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigen_calculation_answer);

        Bundle b = getIntent().getExtras();
        double[][] eigenvalues = (double[][])b.getSerializable("answerval");
        double[][] eigenvectors = (double[][])b.getSerializable("answervec");
        int size = getIntent().getIntExtra("size", 0);


        formOutput();


        for (int i=0; i<6; i++){
            if (i>=size){
                matrixOutputs.get(i).setVisibility(View.INVISIBLE);
            }
            else{
                matrixOutputs.get(i).setText(Double.toString(Math.round(eigenvalues[i][i]*100.0)/100.0) + " with [");
                for (int j=0; j<size; j++){
                    String s = matrixOutputs.get(i).getText().toString();
                    if(j!=0){
                        matrixOutputs.get(i).setText(s + ",");
                        s = matrixOutputs.get(i).getText().toString();
                    }
                    matrixOutputs.get(i).setText(s + " " + Math.round(eigenvectors[j][i]*100.0)/100.0);
                }
                String s = matrixOutputs.get(i).getText().toString();
                matrixOutputs.get(i).setText(s + "]");
            }
        }

    }


    public void formOutput(){
        matrixOutputs.add((TextView) findViewById(R.id.eigen1));
        matrixOutputs.add((TextView) findViewById(R.id.eigen2));
        matrixOutputs.add((TextView) findViewById(R.id.eigen3));
        matrixOutputs.add((TextView) findViewById(R.id.eigen4));
        matrixOutputs.add((TextView) findViewById(R.id.eigen5));
        matrixOutputs.add((TextView) findViewById(R.id.eigen6));
    }
}
