package com.natallialemiasheuskaya.mainmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.natallialemiasheuskaya.TestActivity;
import com.natallialemiasheuskaya.base.BaseMVVMActivity;
import com.natallialemiasheuskaya.base.BaseViewModel;
import com.natallialemiasheuskaya.sreens.homework1.HomeWork1Activity;
import com.natallialemiasheuskaya.sreens.homework1.R;
import com.natallialemiasheuskaya.sreens.homework1.databinding.ActivityMainBinding;
import com.natallialemiasheuskaya.sreens.homework1.databinding.ActivityUserBinding;
import com.natallialemiasheuskaya.sreens.homework10.UserActivity;
import com.natallialemiasheuskaya.sreens.homework10.UserViewModel;
import com.natallialemiasheuskaya.sreens.homework2.HomeWork2Activity;
import com.natallialemiasheuskaya.sreens.homework3.HomeWork3Activity;
import com.natallialemiasheuskaya.sreens.homework4.HomeWork4Activity;
import com.natallialemiasheuskaya.sreens.homework5.HomeWork5Activity;
import com.natallialemiasheuskaya.sreens.homework6.HomeWork6Activity;
import com.natallialemiasheuskaya.sreens.homework7.HomeWork7Activity;
import com.natallialemiasheuskaya.sreens.homework8.HomeWork8Activity;
import com.natallialemiasheuskaya.sreens.homework9.HomeWork9Activity;


public class MainActivity extends BaseMVVMActivity<ActivityMainBinding,BaseViewModel> implements View.OnClickListener {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BaseViewModel provideViewModel() {
        return new MainViewModel();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding.bHw1.setOnClickListener(this);
        binding.bHw2.setOnClickListener(this);
        binding.bHw3.setOnClickListener(this);
        binding.bHw4.setOnClickListener(this);
        binding.bHw5.setOnClickListener(this);
        binding.bHw6.setOnClickListener(this);
        binding.bHw7.setOnClickListener(this);
        binding.bHw9.setOnClickListener(this);
        binding.bHw10.setOnClickListener(this);
        binding.bTest.setOnClickListener(this);

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
            case R.id.b_hw10:
                intent = new Intent(this,UserActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }



    }
}
