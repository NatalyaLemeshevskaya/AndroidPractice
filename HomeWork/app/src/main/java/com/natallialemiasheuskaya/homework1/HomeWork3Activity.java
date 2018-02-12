package com.natallialemiasheuskaya.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HomeWork3Activity extends AppCompatActivity {

    Button buttonClick;
    ImageView imageCat;
    EditText uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work3);

        buttonClick = (Button)findViewById(R.id.buttonClick);
        imageCat = (ImageView)findViewById(R.id.imageCat);
        uri = (EditText) findViewById(R.id.uri);
        uri.setText("http://foto-cat.ru/wp-content/uploads/2015/07/Kot_v_sapogah_416605.jpg");

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(HomeWork3Activity.this).load(uri.getText().toString()).into(imageCat);

            }
        });


    }




}
