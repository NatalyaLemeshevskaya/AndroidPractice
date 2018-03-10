package com.natallialemiasheuskaya.mainmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.natallialemiasheuskaya.TestActivity;
import com.natallialemiasheuskaya.homework1.HomeWork1Activity;
import com.natallialemiasheuskaya.homework1.R;
import com.natallialemiasheuskaya.homework2.HomeWork2Activity;
import com.natallialemiasheuskaya.homework3.HomeWork3Activity;
import com.natallialemiasheuskaya.homework4.HomeWork4Activity;
import com.natallialemiasheuskaya.homework5.HomeWork5Activity;
import com.natallialemiasheuskaya.homework6.HomeWork6Activity;
import com.natallialemiasheuskaya.homework7.HomeWork7Activity;
import com.natallialemiasheuskaya.homework8.HomeWork8Activity;
import com.natallialemiasheuskaya.homework9.HomeWork9Activity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_hw1,b_hw2,b_hw3,b_hw4,b_hw5,b_hw6,b_hw7,b_hw8,b_test,b_hw9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.e("hw","msg");

        b_hw1 = (Button) findViewById(R.id.b_hw1);
        b_hw1.setOnClickListener(this);

        b_hw2 = (Button) findViewById(R.id.b_hw2);
        b_hw2.setOnClickListener(this);

        b_hw3 = (Button) findViewById(R.id.b_hw3);
        b_hw3.setOnClickListener(this);

        b_hw4 = (Button) findViewById(R.id.b_hw4);
        b_hw4.setOnClickListener(this);

        b_hw5 = (Button) findViewById(R.id.b_hw5);
        b_hw5.setOnClickListener(this);

        b_hw6 = (Button) findViewById(R.id.b_hw6);
        b_hw6.setOnClickListener(this);

        b_hw7 = (Button) findViewById(R.id.b_hw7);
        b_hw7.setOnClickListener(this);

        b_hw8 = (Button) findViewById(R.id.b_hw8);
        b_hw8.setOnClickListener(this);

        b_hw9 = (Button) findViewById(R.id.b_hw9);
        b_hw9.setOnClickListener(this);

        b_test = (Button) findViewById(R.id.b_test);
        b_test.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()){

            case R.id.b_hw1:
                intent = new Intent(this,HomeWork1Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw2:
                intent = new Intent(this,HomeWork2Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw3:
                intent = new Intent(this,HomeWork3Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw4:
                intent = new Intent(this,HomeWork4Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw5:
                intent = new Intent(this,HomeWork5Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw6:
                intent = new Intent(this,HomeWork6Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw7:
                intent = new Intent(this,HomeWork7Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw8:
                intent = new Intent(this,HomeWork8Activity.class);
                startActivity(intent);
                break;
            case R.id.b_hw9:
                intent = new Intent(this,HomeWork9Activity.class);
                startActivity(intent);
                break;
            case R.id.b_test:
                intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }



    }
}
