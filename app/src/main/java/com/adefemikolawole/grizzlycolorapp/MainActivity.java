package com.adefemikolawole.grizzlycolorapp;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
final String txtAbout = "Author: Adefemi Kolawole\nClass: ITEC 4550\nDate: Fall 2018 (9/16/2018)";
ConstraintLayout mainLayout;

TextView txtSwatch;
Button btAbout;


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

        //set Toast function for button about
        btAbout = (Button) findViewById(R.id.btAbout);
        btAbout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showAboutToast();
            }
        });
    }

   public void print(String str){
        System.out.print(str);
   }

   public void showAboutToast(){

       Toast.makeText(MainActivity.this, txtAbout, Toast.LENGTH_LONG).show();
   }

  /*  public void showAboutSnackbar(){
SnackBar snackbar;
      Snackbar.make(MainActivity.this, txtAbout, Toast.LENGTH_LONG).show();
    }
*/
}
