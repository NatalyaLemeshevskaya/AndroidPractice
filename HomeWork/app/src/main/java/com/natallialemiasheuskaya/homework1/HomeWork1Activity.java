package com.natallialemiasheuskaya.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeWork1Activity extends AppCompatActivity  implements View.OnClickListener{

    Button b_mix;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work1);

        b_mix = (Button) findViewById(R.id.b_mix);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        b_mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = (String) textView1.getText();
                String text2 = (String) textView2.getText();

                textView1.setText(text2);
                textView2.setText(text1);

            }
        });


        textView1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String text1 = (String) textView1.getText();
        String text2 = (String) textView2.getText();

        textView1.setText(text2);
        textView2.setText(text1);
    }

    public void clickTextView2(View view){
        String text1 = (String) textView1.getText();
        String text2 = (String) textView2.getText();

        textView1.setText(text2);
        textView2.setText(text1);

    }






}
