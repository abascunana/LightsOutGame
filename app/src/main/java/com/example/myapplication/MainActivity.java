package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int score;
    private static final String KEY_INDEX = "index";
    private Switch[][] buttons = new Switch[5][5];
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("Land", "onSaveInstanceState");

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = this.getSharedPreferences("prefsKey", Context.MODE_PRIVATE);
        score = prefs.getInt("points", 0); // Retrieves the user's current score

        buttons[0][0] = (Switch) findViewById(R.id.bulb0);
        buttons[0][1] = (Switch) findViewById(R.id.bulb1);
        buttons[0][2] = (Switch) findViewById(R.id.bulb2);
        buttons[0][3] = (Switch) findViewById(R.id.bulb3);
        buttons[0][4] = (Switch) findViewById(R.id.bulb4);
        buttons[1][0] = (Switch) findViewById(R.id.bulb5);
        buttons[1][1] = (Switch) findViewById(R.id.bulb6);
        buttons[1][2] = (Switch) findViewById(R.id.bulb7);
        buttons[1][3] = (Switch) findViewById(R.id.bulb8);
        buttons[1][4] = (Switch) findViewById(R.id.bulb9);
        buttons[2][0] = (Switch) findViewById(R.id.bulb10);
        buttons[2][1] = (Switch) findViewById(R.id.bulb11);
        buttons[2][2] = (Switch) findViewById(R.id.bulb12);
        buttons[2][3] = (Switch) findViewById(R.id.bulb13);
        buttons[2][4] = (Switch) findViewById(R.id.bulb14);
        buttons[3][0] = (Switch) findViewById(R.id.bulb15);
        buttons[3][1] = (Switch) findViewById(R.id.bulb16);
        buttons[3][2] = (Switch) findViewById(R.id.bulb17);
        buttons[3][3] = (Switch) findViewById(R.id.bulb18);
        buttons[3][4] = (Switch) findViewById(R.id.bulb19);
        buttons[4][0] = (Switch) findViewById(R.id.bulb20);
        buttons[4][1] = (Switch) findViewById(R.id.bulb21);
        buttons[4][2] = (Switch) findViewById(R.id.bulb22);
        buttons[4][3] = (Switch) findViewById(R.id.bulb23);
        buttons[4][4] = (Switch) findViewById(R.id.bulb24);

        if (savedInstanceState != null) {

            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[0].length; j++) {
                    buttons[i][j].isChecked();
                }
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                Vi(buttons[i][j]);
            }

        }

    }

     public void Vi(Switch s){
        s.setOnClickListener(v ->{
         if (s.isChecked()) {
             s.setBackgroundResource(R.drawable.squareon);
             s.setChecked(true);

         } else {

             s.setBackgroundResource(R.drawable.squareoff);
             s.setChecked(false);
         }

     });
 }




    }






