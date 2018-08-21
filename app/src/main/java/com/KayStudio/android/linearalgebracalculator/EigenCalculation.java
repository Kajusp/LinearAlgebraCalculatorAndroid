package com.KayStudio.android.linearalgebracalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import Jama.EigenvalueDecomposition;
import Jama.Matrix;

public class EigenCalculation extends AppCompatActivity {

    ArrayList<EditText> matrixInputs = new ArrayList<EditText>();

    int selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigen_calculation);
        formInput();
        Spinner sp = (Spinner) findViewById(R.id.selectMatrixInverse);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int
                    position, long id) {

                selection = position;
                for (int i=0; i<6; i++){
                    for (int j=0; j<6; j++){
                        if (i<selection+2 && j<selection+2)
                            matrixInputs.get(i*6+j).setVisibility(View.VISIBLE);
                        else
                            matrixInputs.get(i*6+j).setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void calculateEigen(View view){

        double[][] m = new double[selection+2][selection+2];
        try {
            for (int i = 0; i < selection + 2; i++) {
                for (int j = 0; j < selection + 2; j++) {
                    m[i][j] = Double.parseDouble(matrixInputs.get(i * 6 + j).getText().toString());
                }
            }
        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Incorrect input." ,
                    Toast.LENGTH_LONG).show();

            return;
        }
        eigenDecomposition(m);
    }

    public void eigenDecomposition(double [][] M){
        Matrix JM = new Matrix(M);
        EigenvalueDecomposition eigenJM = JM.eig();
        Matrix eigenvalues = eigenJM.getD();
        Matrix eigenvectors = eigenJM.getV();

        double[][] eigValues = new double[selection+2][selection+2];
        double[][] eigVectors = new double[selection+2][selection+2];

        for (int i=0; i<selection+2; i++){
            for (int j=0; j<selection+2; j++){
                eigVectors[i][j]=eigenvectors.get(i,j);
                if(i==j)
                    eigValues[i][j]=eigenvalues.get(i,j);
                else
                    eigValues[i][j]=0;
            }
        }
        eigVectors = normalise(eigVectors);

        Intent intent = new Intent(this, EigenCalculationAnswer.class);
        Bundle b=new Bundle();
        b.putSerializable("answerval", eigValues);
        b.putSerializable("answervec", eigVectors);
        intent.putExtras(b);
        int passableSize=selection+2;
        intent.putExtra("size", passableSize);
        startActivity(intent);

    }

    public double[][] normalise(double[][] m){
        for (int i=0; i<selection+2; i++){
            double closestToZero=1;

            for (int j=0; j<selection+2; j++){
                if (Math.abs(m[j][i])<closestToZero && m[j][i]!=0){
                    closestToZero = Math.abs(m[j][i]);
                }
            }

            for (int j=0; j<selection+2; j++){
                m[j][i]=m[j][i]/closestToZero;
            }
        }

        return m;
    }

    public void formInput(){
        matrixInputs.add((EditText) findViewById(R.id.invMat11));
        matrixInputs.add((EditText) findViewById(R.id.invMat12));
        matrixInputs.add((EditText) findViewById(R.id.invMat13));
        matrixInputs.add((EditText) findViewById(R.id.invMat14));
        matrixInputs.add((EditText) findViewById(R.id.invMat15));
        matrixInputs.add((EditText) findViewById(R.id.invMat16));
        matrixInputs.add((EditText) findViewById(R.id.invMat21));
        matrixInputs.add((EditText) findViewById(R.id.invMat22));
        matrixInputs.add((EditText) findViewById(R.id.invMat23));
        matrixInputs.add((EditText) findViewById(R.id.invMat24));
        matrixInputs.add((EditText) findViewById(R.id.invMat25));
        matrixInputs.add((EditText) findViewById(R.id.invMat26));
        matrixInputs.add((EditText) findViewById(R.id.invMat31));
        matrixInputs.add((EditText) findViewById(R.id.invMat32));
        matrixInputs.add((EditText) findViewById(R.id.invMat33));
        matrixInputs.add((EditText) findViewById(R.id.invMat34));
        matrixInputs.add((EditText) findViewById(R.id.invMat35));
        matrixInputs.add((EditText) findViewById(R.id.invMat36));
        matrixInputs.add((EditText) findViewById(R.id.invMat41));
        matrixInputs.add((EditText) findViewById(R.id.invMat42));
        matrixInputs.add((EditText) findViewById(R.id.invMat43));
        matrixInputs.add((EditText) findViewById(R.id.invMat44));
        matrixInputs.add((EditText) findViewById(R.id.invMat45));
        matrixInputs.add((EditText) findViewById(R.id.invMat46));
        matrixInputs.add((EditText) findViewById(R.id.invMat51));
        matrixInputs.add((EditText) findViewById(R.id.invMat52));
        matrixInputs.add((EditText) findViewById(R.id.invMat53));
        matrixInputs.add((EditText) findViewById(R.id.invMat54));
        matrixInputs.add((EditText) findViewById(R.id.invMat55));
        matrixInputs.add((EditText) findViewById(R.id.invMat56));
        matrixInputs.add((EditText) findViewById(R.id.invMat61));
        matrixInputs.add((EditText) findViewById(R.id.invMat62));
        matrixInputs.add((EditText) findViewById(R.id.invMat63));
        matrixInputs.add((EditText) findViewById(R.id.invMat64));
        matrixInputs.add((EditText) findViewById(R.id.invMat65));
        matrixInputs.add((EditText) findViewById(R.id.invMat66));

    }
}
