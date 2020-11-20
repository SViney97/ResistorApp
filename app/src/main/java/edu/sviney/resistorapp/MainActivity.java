package edu.sviney.resistorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double Band,ValResistor1,ValResistor2,ValResistor3,Result;
    double Tolerance = 0, PlusResult=0,MinusResult=0, percentage = 0;

    Button colour1,colour2,colour3,colour4;
    Button disableBlack,disableOrange,disableYellow,disableGray,disableWhite,disableGold,disableSilver;
    TextView DisplayResult,DisplayResultPlus,DisplayResultMinus, DisplayTolerance,DisplayTolerancePlus,DisplayToleranceMinus;
    String ohm = "\u2126";
    String plusminus="\u00B1";
    String percent="\u0025";
    String Plus = "\u002B";
    String Minus="\u2212";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link
        DisplayResult = findViewById(R.id.tvDisplay);
        DisplayTolerance = findViewById(R.id.tvTolDisplay);

        //link plus and minus result views and tolerance
        DisplayResultPlus = findViewById(R.id.tvDisplayPlus);
        DisplayResultMinus = findViewById(R.id.tvDisplayMinus);
        DisplayTolerancePlus = findViewById(R.id.tvTolDisplayPlus);
        DisplayToleranceMinus = findViewById(R.id.tvTolDisplayMinus);

        //image band clickable colour change
        colour1 = findViewById(R.id.BtnBandOne);
        colour2 = findViewById(R.id.BtnBandTwo);
        colour3 = findViewById(R.id.BtnMul);
        colour4 = findViewById(R.id.BtnTol);

        //disable colours for the band colours
        disableBlack = findViewById(R.id.btnBlack);
        disableOrange = findViewById(R.id.btnOrange);
        disableYellow = findViewById(R.id.btnYellow);
        disableGray = findViewById(R.id.btnGray);
        disableWhite = findViewById(R.id.btnWhite);
        disableGold = findViewById(R.id.btnGold);
        disableSilver = findViewById(R.id.btnSilver);

    }//end of onCreate

    // the do calculation and reset buttons
    public void DoCalculate(View view) {

        //original ohm
        Result = (int) (ValResistor1 + ValResistor2) * ValResistor3;
        DisplayResult.setText(String.valueOf(String.format("%.2f",Result)) + ohm);
        DisplayTolerance.setText(plusminus + String.format("%.2f",Tolerance) + percent);

        //ohm plus and minus calculation
        percentage = (double) Result *(Tolerance /100);

        //plus ohm
        PlusResult = Result + percentage;
        DisplayResultPlus.setText(String.valueOf(String.format("%.4f",PlusResult)) + ohm);
        DisplayTolerancePlus.setText(Plus + String.format("%.2f",Tolerance) + percent);

        //minus ohm
        MinusResult = Result - percentage;
        DisplayResultMinus.setText(String.valueOf(String.format("%.4f",MinusResult)) + ohm);
       DisplayToleranceMinus.setText(Minus + String.format("%.2f",Tolerance) + percent);

    }//end of DoCalculate

    public void DoReset(View view) {

        DisplayTolerance.setText("");
        DisplayResult.setText("");
        DisplayToleranceMinus.setText("");
        DisplayResultMinus.setText("" );
        DisplayTolerancePlus.setText("");
        DisplayResultPlus.setText("" );
        //set colour back 1
        colour1.setBackgroundColor(Color.WHITE);
        colour1.setTextColor(Color.BLACK);
        //set colour back 2
        colour2.setBackgroundColor(Color.WHITE);
        colour2.setTextColor(Color.BLACK);
        //set colour back 3
        colour3.setBackgroundColor(Color.WHITE);
        colour3.setTextColor(Color.BLACK);
        //set colour back 4
        colour4.setBackgroundColor(Color.WHITE);
        colour4.setTextColor(Color.BLACK);

        //reset the visibility for the colour buttons
        disableBlack.setVisibility(View.VISIBLE);
        disableOrange.setVisibility(View.VISIBLE);
        disableYellow.setVisibility(View.VISIBLE);
        disableGray.setVisibility(View.VISIBLE);
        disableWhite.setVisibility(View.VISIBLE);
        disableGold.setVisibility(View.VISIBLE);
        disableSilver.setVisibility(View.VISIBLE);

        //reset back to zero
        Band =0;
        ValResistor1 =0;
        ValResistor2=0;
        ValResistor3=0;
        Result=0;
        Tolerance = 0;
        PlusResult=0;
        MinusResult=0;

    }//end of DoReset

    //buttons on resistor image to select each band colour
    public void Do_B1(View view) {
        Band =1;
        disableBlack.setVisibility(View.VISIBLE);
        disableOrange.setVisibility(View.VISIBLE);
        disableYellow.setVisibility(View.VISIBLE);
        disableGray.setVisibility(View.VISIBLE);
        disableWhite.setVisibility(View.VISIBLE);
        disableGold.setVisibility(View.INVISIBLE);
        disableSilver.setVisibility(View.INVISIBLE);

    } //end of button band 1
    public void Do_B2(View view) {
        Band = 2;
        disableBlack.setVisibility(View.VISIBLE);
        disableOrange.setVisibility(View.VISIBLE);
        disableYellow.setVisibility(View.VISIBLE);
        disableGray.setVisibility(View.VISIBLE);
        disableWhite.setVisibility(View.VISIBLE);
        disableGold.setVisibility(View.INVISIBLE);
        disableSilver.setVisibility(View.INVISIBLE);

    } // end of button band 2
    public void Do_MulB3(View view) {
        Band = 3;

        disableBlack.setVisibility(View.VISIBLE);
        disableOrange.setVisibility(View.VISIBLE);
        disableYellow.setVisibility(View.VISIBLE);
        disableGray.setVisibility(View.INVISIBLE);
        disableWhite.setVisibility(View.INVISIBLE);
        disableGold.setVisibility(View.VISIBLE);
        disableSilver.setVisibility(View.VISIBLE);

    }//end of button band 3 multiply
    public void Do_TolB4(View view) {
        Band = 4;

        disableBlack.setVisibility(View.INVISIBLE);
        disableOrange.setVisibility(View.INVISIBLE);
        disableYellow.setVisibility(View.INVISIBLE);
        disableGray.setVisibility(View.VISIBLE);
        disableWhite.setVisibility(View.INVISIBLE);
        disableGold.setVisibility(View.VISIBLE);
        disableSilver.setVisibility(View.VISIBLE);

    }//end of button band 3 tolerance

    //buttons with colours
    public void Do_colourBlack(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 0;

            colour1.setBackgroundColor(Color.BLACK);
            colour1.setTextColor(Color.WHITE);
        }
        if(Band ==(2))
        {
            ValResistor2 = 0;

            colour2.setBackgroundColor(Color.BLACK);
            colour2.setTextColor(Color.WHITE);
        }
        if(Band ==(3))
        {
            ValResistor3 = 1;

            colour3.setBackgroundColor(Color.BLACK);
            colour3.setTextColor(Color.WHITE);
        }
    }//end of Do_colourBlack
    public void Do_colourBrown(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 10;

            colour1.setBackgroundColor(Color.rgb(153,51,0));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 1;
            colour2.setBackgroundColor(Color.rgb(153,51,0));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 10;
            colour3.setBackgroundColor(Color.rgb(153,51,0));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 1;
            colour4.setBackgroundColor(Color.rgb(153,51,0));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourBrown
    public void Do_colourRed(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 20;
            colour1.setBackgroundColor(Color.rgb(255,0,0));
            colour1.setTextColor(Color.BLACK);

        }
        if(Band ==(2))
        {
            ValResistor2 = 2;
            colour2.setBackgroundColor(Color.rgb(255,0,0));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 100;
            colour3.setBackgroundColor(Color.rgb(255,0,0));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 2;
            colour4.setBackgroundColor(Color.rgb(255,0,0));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourRed
    public void Do_colourOrange(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 30;
            colour1.setBackgroundColor(Color.rgb(255,165,0));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 3;
            colour2.setBackgroundColor(Color.rgb(255,165,0));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 1000;
            colour3.setBackgroundColor(Color.rgb(255,165,0));
            colour3.setTextColor(Color.BLACK);
        }
    }//end of Do_colourOrange
    public void Do_colourYellow(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 40;
            colour1.setBackgroundColor(Color.rgb(255,235,59));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 4;
            colour2.setBackgroundColor(Color.rgb(255,235,59));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 10000;
            colour3.setBackgroundColor(Color.rgb(255,235,59));
            colour3.setTextColor(Color.BLACK);
        }
    }//end of Do_colourYellow
    public void Do_colourGreen(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 50;
            colour1.setBackgroundColor(Color.rgb(76,175,80));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 5;
            colour2.setBackgroundColor(Color.rgb(76,175,80));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 100000;
            colour3.setBackgroundColor(Color.rgb(76,175,80));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 0.5;
            colour4.setBackgroundColor(Color.rgb(76,175,80));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourGreen
    public void Do_colourBlue(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 60;
            colour1.setBackgroundColor(Color.rgb(3,169,244));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 6;
            colour2.setBackgroundColor(Color.rgb(3,169,244));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 1000000;
            colour3.setBackgroundColor(Color.rgb(3,169,244));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 0.25;
            colour4.setBackgroundColor(Color.rgb(3,169,244));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourBlue
    public void Do_colourViolet(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 70;
            colour1.setBackgroundColor(Color.rgb(238,130,238));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 7;
            colour2.setBackgroundColor(Color.rgb(238,130,238));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(3))
        {
            ValResistor3 = 10000000;
            colour3.setBackgroundColor(Color.rgb(238,130,238));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 0.10;
            colour4.setBackgroundColor(Color.rgb(238,130,238));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourViolet
    public void Do_colourGray(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 80;
            colour1.setBackgroundColor(Color.rgb(128,128,128));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 8;
            colour2.setBackgroundColor(Color.rgb(128,128,128));
            colour2.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 0.05;
            colour4.setBackgroundColor(Color.rgb(128,128,128));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourGray
    public void Do_colourWhite(View view) {
        if(Band ==(1))
        {
            ValResistor1 = 90;
            colour1.setBackgroundColor(Color.rgb(255,255,255));
            colour1.setTextColor(Color.BLACK);
        }
        if(Band ==(2))
        {
            ValResistor2 = 9;
            colour2.setBackgroundColor(Color.rgb(255,255,255));
            colour2.setTextColor(Color.BLACK);
        }

    }//end of Do_colourWhite
    public void Do_colourGold(View view) {

        if(Band ==(3))
        {
            ValResistor3 = 0.1;

            colour3.setBackgroundColor(Color.rgb(255,215,0));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 5;
            colour4.setBackgroundColor(Color.rgb(255,215,0));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourGold
    public void Do_colourSilver(View view) {
        if(Band ==(3))
        {
            ValResistor3 = 0.01;
            colour3.setBackgroundColor(Color.rgb(192,192,192));
            colour3.setTextColor(Color.BLACK);
        }
        if(Band ==(4))
        {
            Tolerance = 10;
            colour4.setBackgroundColor(Color.rgb(192,192,192));
            colour4.setTextColor(Color.BLACK);
        }
    }//end of Do_colourSilver
}//end of MainActivity