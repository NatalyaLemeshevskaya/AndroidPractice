package com.natallialemiasheuskaya.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_hw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_hw1 = (Button) findViewById(R.id.b_hw1);
        b_hw1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.b_hw1:
                Intent intentHw1 = new Intent(this,HomeWork1Activity.class);
                startActivity(intentHw1);
                break;
            default:
                break;

        }



    }
}
