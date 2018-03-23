package com.natallialemiasheuskaya.presentation.sreens.homework4;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.natallialemiasheuskaya.presentation.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.presentation.sreens.homework1.R;
import com.natallialemiasheuskaya.presentation.sreens.homework1.databinding.ActivityOwlBinding;

public class OwlActivity extends BaseMVVMActivity<ActivityOwlBinding,OwlViewModel> {

    ImageView owlImage;
    Button owl_start,owl_stop;
    AnimationDrawable animationDrawable;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_owl;
    }

    @Override
    public OwlViewModel provideViewModel() {
        return new OwlViewModel();
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owl);

        owlImage = (ImageView) findViewById(R.id.owlImage);
        owl_start = (Button) findViewById(R.id.owl_start);
        owl_stop = (Button) findViewById(R.id.owl_stop);


        owlImage.setBackgroundResource(R.drawable.owl_animation);
        animationDrawable = (AnimationDrawable) owlImage.getBackground();

        owl_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.start();
            }
        });
        owl_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
