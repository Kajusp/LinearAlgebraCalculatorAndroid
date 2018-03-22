package com.KayStudio.android.linearalgebracalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lpform(View view){
        Intent intent = new Intent(this, LinesPlanesForm.class);
        startActivity(intent);
    }

    public void angPlane(View view){
        Intent intent = new Intent(this, AngleBetweenPlanes.class);
        startActivity(intent);
    }

    public void matInv (View view){
        Intent intent = new Intent(this, MatrixInverse.class);
        startActivity(intent);
    }

    public void det (View view){
        Intent intent = new Intent(this, DeterminantCalculation.class);
        startActivity(intent);
    }

    public void eigen(View view){
        Intent intent = new Intent(this, EigenCalculation.class);
        startActivity(intent);
    }
}
