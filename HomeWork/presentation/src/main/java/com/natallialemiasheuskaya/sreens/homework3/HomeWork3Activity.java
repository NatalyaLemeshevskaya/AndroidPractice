package com.natallialemiasheuskaya.sreens.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.natallialemiasheuskaya.sreens.homework1.BuildConfig;
import com.natallialemiasheuskaya.sreens.homework1.R;
import com.squareup.picasso.Picasso;

public class HomeWork3Activity extends AppCompatActivity {

    Button buttonTree;
    ImageView imageTree;
    EditText uri;
    TextView textWow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work3);

        buttonTree = (Button)findViewById(R.id.buttonTree);
        imageTree = (ImageView)findViewById(R.id.imageTree);
        textWow = (TextView) findViewById(R.id.textWow);

        uri = (EditText) findViewById(R.id.uri);
        uri.setText("https://us.123rf.com/450wm/smileus/smileus1504/smileus150400005/39155225-идеальный-ясень-с-пышной-зеленой-листвой-и-хорошей-форме-изолированных-на-чистом-белом-фоне.jpg?ver=6");

        buttonTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(HomeWork3Activity.this).load(uri.getText().toString()).transform(new CircularTransformation()).into(imageTree);

                textWow.setText(BuildConfig.API_ENDPOINT);


            }
        });


    }




}
