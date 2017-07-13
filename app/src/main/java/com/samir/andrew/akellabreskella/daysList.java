package com.samir.andrew.akellabreskella;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class daysList extends AppCompatActivity {

    @BindView(R.id.tvDay1)
    TextView tvDay1;
    @BindView(R.id.tvDay2)
    TextView tvDay2;
    @BindView(R.id.tvDay3)
    TextView tvDay3;

    @BindView(R.id.imgDay1)
    ImageView imgDay1;
    @BindView(R.id.imgDay2)
    ImageView imgDay2;
    @BindView(R.id.imgDay3)
    ImageView imgDay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_list);


        ButterKnife.bind(this);

        Typeface custom_font_ar_semi = Typeface.createFromAsset(getAssets(), "fonts/Mirza-SemiBold.ttf");

        tvDay1.setTypeface(custom_font_ar_semi);
        tvDay2.setTypeface(custom_font_ar_semi);
        tvDay3.setTypeface(custom_font_ar_semi);


    }

    @OnClick(R.id.imgDay1)
    void onClickImgDay1() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/first_day.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.imgDay2)
    void onClickImgDay2() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/second_day.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.imgDay3)
    void onClickImgDay3() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/third_day.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

}
