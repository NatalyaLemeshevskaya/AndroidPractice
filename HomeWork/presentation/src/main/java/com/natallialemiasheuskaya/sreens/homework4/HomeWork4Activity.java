package com.natallialemiasheuskaya.sreens.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.natallialemiasheuskaya.sreens.homework1.R;

public class HomeWork4Activity extends AppCompatActivity implements View.OnClickListener{

    Button owlButton,clockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work4);

        owlButton = (Button) findViewById(R.id.owlButton);
        owlButton.setOnClickListener(this);

        clockButton = (Button) findViewById(R.id.clockButton);
        clockButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()){

            case R.id.owlButton:{
                intent = new Intent(this,OwlActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
            }
            case R.id.clockButton:{
                intent = new Intent(this,ClockActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
            }



        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

    }
}
