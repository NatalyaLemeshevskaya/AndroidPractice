package com.natallialemiasheuskaya.coinmarketcap.presentation.screens.allPortfolio;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.natallialemiasheuskaya.coinmarketcap.R;
import com.natallialemiasheuskaya.coinmarketcap.databinding.ActivityPortfolioBinding;
import com.natallialemiasheuskaya.coinmarketcap.presentation.base.BaseMVVMActivity;


public class PortfolioActivity extends BaseMVVMActivity<ActivityPortfolioBinding,PortfolioViewModel,PortfolioRouter> {

    final Context context = this;
    AlertDialog alertDialog;
    LayoutInflater li;
    View dialog;
    EditText inputText;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_portfolio;
    }

    @Override
    public PortfolioViewModel provideViewModel() {
        return new PortfolioViewModel();
    }

    @Override
    public PortfolioRouter provideRouter() {
        return new PortfolioRouter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = binding.accountRecycler;
        recyclerView.setAdapter(viewModel.portfolioAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        binding.addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                li = LayoutInflater.from(context);
                dialog = li.inflate(R.layout.dialog_window, null);


                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                mDialogBuilder.setView(dialog);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        //Вводим текст и отображаем в строке ввода на основном экране:
                                        inputText = alertDialog.findViewById(R.id.input_text);
                                        viewModel.saveAccount(inputText.getText().toString());

                                    }
                                })
                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                alertDialog = mDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
