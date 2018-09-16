package com.adefemikolawole.grizzlycolorapp;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
final String txtAbout = "Author: Adefemi Kolawole";

ConstraintLayout mainLayout;

TextView txtSwatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        print(txtAbout);
        // set transparency for main layout
        mainLayout = (ConstraintLayout) findViewById(R.id.mainConstraintLayout);
        mainLayout.getBackground().setAlpha(120);
//Set transparency for swatch view
        txtSwatch = (TextView) findViewById(R.id.txtSwatch);
        txtSwatch.getBackground().setAlpha(120);
    }

   public void print(String str){
        System.out.print(str);
   }
}
