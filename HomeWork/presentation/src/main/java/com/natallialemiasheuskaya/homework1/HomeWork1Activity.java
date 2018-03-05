package com.natallialemiasheuskaya.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeWork1Activity extends AppCompatActivity  implements View.OnClickListener{

    Button b_mix;
    TextView textView1,textView2;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mix();
        }
    };

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
               mix();

            }
        });


        textView1.setOnClickListener(this);
        textView2.setOnClickListener(listener);

    }

    @Override
    public void onClick(View view) {
        mix();
    }

    public void mix(){

        String text1 = (String) textView1.getText();

        textView1.setText(textView2.getText());
        textView2.setText(text1);
    }



}
