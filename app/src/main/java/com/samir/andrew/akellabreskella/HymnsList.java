package com.samir.andrew.akellabreskella;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HymnsList extends AppCompatActivity {

    @BindView(R.id.tvHymens)
    TextView tvHymens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymns_list);



        ButterKnife.bind(this);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Mirza-Regular.ttf");

        tvHymens.setTypeface(custom_font);


    }

    @OnClick(R.id.tvHymens)
    void onClicktvHymens() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Alahn/alhan.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

}
