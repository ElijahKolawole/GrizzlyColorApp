package com.adefemikolawole.grizzlycolorapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
final String txtAbout = "Author: Adefemi Kolawole\nClass: ITEC 4550\nDate: Fall 2018 (9/16/2018)";
ConstraintLayout mainLayout;

private TextView tvSwatch;
private Button btAbout, btUpdate;
private SeekBar sbR, sbG, sbB, sbA;
private TextView txtRed, txtGreen, txtBlue, txtAlpha;
private int initialColor;
private int r, g, b, a ;
String txtSwatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


        print(txtAbout);
        // set transparency for main layout
        mainLayout = findViewById(R.id.mainConstraintLayout);
        mainLayout.getBackground().setAlpha(120);
//Set transparency for swatch view
        tvSwatch = (TextView) findViewById(R.id.txtSwatch);
        //txtSwatch.getBackground().setAlpha(120);
//setInitial Color for Swatch :: inital declaration of all seekbar is 0 which is 00;
         a= 0; r= 0; g= 0; b= 0;
        setStringSwatch();
        tvSwatch.setTextColor(Color.BLACK);

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
        txtRed.setText("0");//set Initial color to inital value of seek bar which is 0. so there is absolute transparency.
        txtGreen = (TextView) findViewById(R.id.txtGreen);
        txtGreen.setText("0");//set Initial color to inital value of seek bar which is 0. so there is absolute transparency.
        txtBlue = (TextView) findViewById(R.id.txtBlue);
        txtBlue.setText("0");//set Initial color to inital value of seek bar which is 0. so there is absolute transparency.
        txtAlpha = (TextView) findViewById(R.id.txtAlpha);
        txtAlpha.setText("0");//set Initial color to inital value of seek bar which is 0. so there is absolute transparency.

        //set values for ints a, r, g, b for use in the assignemnt of color.get te progress from text view and assing to each respecitvely
        //r = Integer.parseInt( txtRed.getText().toString());

       //Button update
        btUpdate = (Button) findViewById(R.id.btUpdate);

        //set event listener got btUpdate
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   txtSwatch.setText("test" );
                //showSeekBarToast(String.valueOf(r));

               // setStringSwatch();
//tvSwatch.setBackgroundColor(Color.parseColor(txtSwatch));
                //setNewBackgroundColor(tvSwatch, txtSwatch);
                //setStringSwatch();

                setStringSwatch();
            setNewBackgroundColor();


            }
        });



        //set action listener for seekBar red
        sbR = (SeekBar)  findViewById(R.id.sbR);

        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
txtRed.setText(""+ progress);
             r = Integer.parseInt( txtRed.getText().toString());
               // setStringSwatch();
                //tvSwatch.setBackgroundColor(Color.parseColor(txtSwatch));


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
                g = Integer.parseInt( txtGreen.getText().toString());
               // setStringSwatch();
               // tvSwatch.setBackgroundColor(Color.parseColor(txtSwatch));
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
                b = Integer.parseInt( txtBlue.getText().toString());
               // setStringSwatch();
               // tvSwatch.setBackgroundColor(Color.parseColor(txtSwatch));
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
                a = Integer.parseInt( txtAlpha.getText().toString());
                //setStringSwatch();
               // tvSwatch.setBackgroundColor(Color.parseColor(txtSwatch));
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


  public void setStringSwatch(){
     // txtSwatch = "#"+"A:" + a +    " R:" + r +  " G:" + g + " B:" + b ;
      //tvSwatch.setText(txtSwatch);
     // if ( r == 0 || g ==0 || b ==0 || a ==0){

        /*  String hexR =  ""+Integer.toHexString(r);
          String hexG =  ""+Integer.toHexString(g);
          String hexB =  ""+Integer.toHexString(b);
          String hexA =  ""+Integer.toHexString(a);
          txtSwatch = "#"+hexA+hexR+hexG+hexB;*/
    //  }
    //  else
    //  {
         String hexR =  Integer.toHexString(r);
          String hexG =  Integer.toHexString(g);
          String hexB =  Integer.toHexString(b);
          String hexA =  Integer.toHexString(a);
          txtSwatch = "#"+hexA+hexR+hexG+hexB;
    //  }

      tvSwatch.setText(txtSwatch);


     // tvSwatch.setText(txtSwatch);

     }


     public void setNewBackgroundColor (){
     // tv.setBackgroundColor(Color.parseColor(hexColorCode));
//int newColor = 0;
//int color = Color.parseColor("#fffffff");

         //int alpha = Math.round(Color.alpha(a));
       /*  int red = Integer.parseInt(Integer.toHexString(r));
         int green = Integer.parseInt(Integer.toHexString(g));
         int blue = Integer.parseInt(Integer.toHexString(b));*/

        // newColor = Color.rgb( 00, 00, 00);
 /*        if (a <= 126){
             tvSwatch.setTextColor(Color.BLACK);
             tvSwatch.setBackgroundColor(Color.BLACK);
             tvSwatch.getBackground().setAlpha(a);
         }


     else{
      tvSwatch.setTextColor(Color.YELLOW);
    }*/
 Color bgColor = new Color();
        // tvSwatch.setBackgroundColor(Color.BLACK);

         //int currentBackgroundColor = Color.YELLOW;
         int currentBackgroundColor = Color.rgb(r, g, b);
         tvSwatch.setBackgroundColor(currentBackgroundColor);
         int currentTextColor = tvSwatch.getCurrentTextColor();
         //tvSwatch.setTextColor(currentBackgroundColor +a);
         tvSwatch.setTextColor(currentTextColor  +a+a);


         tvSwatch.getBackground().setAlpha(a);


}
}