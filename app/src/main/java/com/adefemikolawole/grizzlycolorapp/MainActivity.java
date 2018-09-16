package com.adefemikolawole.grizzlycolorapp;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
final String txtAbout = "Author: Adefemi Kolawole\nClass: ITEC 4550\nDate: Fall 2018 (9/16/2018)";
ConstraintLayout mainLayout;

TextView txtSwatch;
Button btAbout;
SeekBar sbR, sbG, sbB, sbA;
TextView txtRed, txtGreen, txtBlue, txtAlpha;


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

        //set textview for seekbar progress
        txtRed = (TextView) findViewById(R.id.txtRed);
        txtGreen = (TextView) findViewById(R.id.txtGreen);
        txtBlue = (TextView) findViewById(R.id.txtBlue);
        txtAlpha = (TextView) findViewById(R.id.txtAlpha);

        //set action listener for seekBar red
        sbR = (SeekBar)  findViewById(R.id.sbR);

        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
txtRed.setText(""+ progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                showSeekBarToast("Selected Red");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //set action listener for seekBar green
        sbG = (SeekBar)  findViewById(R.id.sbG);

        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtGreen.setText(""+ progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                showSeekBarToast("Selected Green");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //set action listener for seekBar blue
        sbB = (SeekBar)  findViewById(R.id.sbB);

        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtBlue.setText(""+ progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                showSeekBarToast("Selected Blue");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //set action listener for seekBar alpha
        sbA = (SeekBar)  findViewById(R.id.sbA);

        sbA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAlpha.setText(""+ progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                showSeekBarToast("Selected Alpha");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //showSeekBarToast("Unselected A");

            }
        });

    }

   public void print(String str){
        System.out.print(str);
   }

   public void showAboutToast(){

       Toast.makeText(MainActivity.this, txtAbout, Toast.LENGTH_SHORT).show();
   }


   public void showSeekBarToast(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();

   }
  /*  public void showAboutSnackbar(){
SnackBar snackbar;
      Snackbar.make(MainActivity.this, txtAbout, Toast.LENGTH_LONG).show();
    }
*/
}
