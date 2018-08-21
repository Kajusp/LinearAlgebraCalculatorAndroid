package com.KayStudio.android.linearalgebracalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class MatrixInverseAnswer extends AppCompatActivity {

    ArrayList<TextView> matrixOutputs = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_inverse_answer);

        Bundle b = getIntent().getExtras();
        double[][] mAnswer = (double[][])b.getSerializable("answer");
        int size = getIntent().getIntExtra("size", 0);
        formOutput();

        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++) {
                if (i < size && j < size) {
                    matrixOutputs.get(i * 6 + j).setVisibility(View.VISIBLE);
                    matrixOutputs.get(i * 6 + j).setTextSize(15);

                    double output = Math.round(mAnswer[i][j]*100.0)/100.0;

                    matrixOutputs.get(i * 6 + j).setText(Double.toString(output));
                }
                else{
                    matrixOutputs.get(i * 6 + j).setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    public void formOutput(){
        matrixOutputs.add((TextView) findViewById(R.id.invAns11));
        matrixOutputs.add((TextView) findViewById(R.id.invAns12));
        matrixOutputs.add((TextView) findViewById(R.id.invAns13));
        matrixOutputs.add((TextView) findViewById(R.id.invAns14));
        matrixOutputs.add((TextView) findViewById(R.id.invAns15));
        matrixOutputs.add((TextView) findViewById(R.id.invAns16));

        matrixOutputs.add((TextView) findViewById(R.id.invAns21));
        matrixOutputs.add((TextView) findViewById(R.id.invAns22));
        matrixOutputs.add((TextView) findViewById(R.id.invAns23));
        matrixOutputs.add((TextView) findViewById(R.id.invAns24));
        matrixOutputs.add((TextView) findViewById(R.id.invAns25));
        matrixOutputs.add((TextView) findViewById(R.id.invAns26));

        matrixOutputs.add((TextView) findViewById(R.id.invAns31));
        matrixOutputs.add((TextView) findViewById(R.id.invAns32));
        matrixOutputs.add((TextView) findViewById(R.id.invAns33));
        matrixOutputs.add((TextView) findViewById(R.id.invAns34));
        matrixOutputs.add((TextView) findViewById(R.id.invAns35));
        matrixOutputs.add((TextView) findViewById(R.id.invAns36));

        matrixOutputs.add((TextView) findViewById(R.id.invAns41));
        matrixOutputs.add((TextView) findViewById(R.id.invAns42));
        matrixOutputs.add((TextView) findViewById(R.id.invAns43));
        matrixOutputs.add((TextView) findViewById(R.id.invAns44));
        matrixOutputs.add((TextView) findViewById(R.id.invAns45));
        matrixOutputs.add((TextView) findViewById(R.id.invAns46));

        matrixOutputs.add((TextView) findViewById(R.id.invAns51));
        matrixOutputs.add((TextView) findViewById(R.id.invAns52));
        matrixOutputs.add((TextView) findViewById(R.id.invAns53));
        matrixOutputs.add((TextView) findViewById(R.id.invAns54));
        matrixOutputs.add((TextView) findViewById(R.id.invAns55));
        matrixOutputs.add((TextView) findViewById(R.id.invAns56));

        matrixOutputs.add((TextView) findViewById(R.id.invAns61));
        matrixOutputs.add((TextView) findViewById(R.id.invAns62));
        matrixOutputs.add((TextView) findViewById(R.id.invAns63));
        matrixOutputs.add((TextView) findViewById(R.id.invAns64));
        matrixOutputs.add((TextView) findViewById(R.id.invAns65));
        matrixOutputs.add((TextView) findViewById(R.id.invAns66));

    }
}
