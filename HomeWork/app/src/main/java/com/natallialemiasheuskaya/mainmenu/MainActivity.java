package com.natallialemiasheuskaya.mainmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.natallialemiasheuskaya.homework1.HomeWork1Activity;
import com.natallialemiasheuskaya.homework1.R;
import com.natallialemiasheuskaya.homework2.HomeWork2Activity;
import com.natallialemiasheuskaya.homework3.HomeWork3Activity;
import com.natallialemiasheuskaya.homework4.HomeWork4Activity;
import com.natallialemiasheuskaya.homework5.HomeWork5Activity;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_hw1,b_hw2,b_hw3,b_hw4,b_hw5;

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
            default:
                break;

        }



    }
}
