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
import java.util.Random;

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
      randomon();

        if (savedInstanceState != null) {

        }
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                Vi(i,j, buttons);
            }

        }


    }
    public void randomon(){
        //función para empezar el juego con Switches Random encendidos, mejorar luego
        Random r = new Random();
        int limite=0;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                boolean random= r.nextBoolean();
                if (random == true){
                    limite++;
                }
                if (limite < (buttons.length*buttons[0].length/2)){
                    buttons[i][j].setChecked(random);
                }
                changeback(buttons[i][j]);
            }

        }

    }
    public boolean win(){
        boolean win = true;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                   if(buttons[i][j].isChecked() == false){
                    win = false;
                   }
            }
        }
        return win;
    }
    public void changeback(Switch s){
        if (s.isChecked()){
            s.setBackgroundResource(R.drawable.squareon);
        }
        else {
            s.setBackgroundResource(R.drawable.squareoff);
        }
    }
    public void surround(int w, int h){
        if (w>0){
            buttons[h][w-1].setChecked(!buttons[h][w-1].isChecked());
            changeback(buttons[h][w-1]);
        }
        if (h>0){
            buttons[h-1][w].setChecked(!buttons[h-1][w].isChecked());
            changeback(buttons[h-1][w]);
        }
        if (h<buttons.length-1){
            buttons[h+1][w].setChecked(!buttons[h+1][w].isChecked());
            changeback(buttons[h+1][w]);
        }
    }

     public void Vi(int h, int w,Switch[][] buttons){

        buttons[h][w].setOnClickListener(v ->{
         if ( buttons[h][w].isChecked()) {

             if (win()){
                 System.out.println("has ganado");
             }
             else {
                 System.out.println("no has ganado");
             }
            {
                //establecer límites para que la app deje de crashear

                surround(w,h);


                for (int i = 0; i < 2; i++) {
                    if (w < buttons.length-1){
                        buttons[h][w+i].setChecked(true);
                        changeback(buttons[h][w+i]);
                    }
                    else {
                        buttons[h][w].setChecked(true);
                        changeback(buttons[h][w]);
                    }


                }

             }

         } else {
             surround(w,h);

             for (int i = 0; i < 2; i++) {
                 if (w < buttons.length-1) {
                     buttons[h][w + i].setChecked(false);
                     changeback(buttons[h][w + i]);
                 }
                 else {
                     buttons[h][w].setChecked(false);
                     changeback(buttons[h][w]);
                 }
             }

         }

     });
 }




    }






