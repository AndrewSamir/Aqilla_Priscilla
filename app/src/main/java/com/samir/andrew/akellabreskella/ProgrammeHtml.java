package com.samir.andrew.akellabreskella;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgrammeHtml extends AppCompatActivity {

    @BindView(R.id.wvProgrammeHtml)
    WebView wvProgrammeHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme_html);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        wvProgrammeHtml.loadUrl(Singletone.Instance().getHtmlUrL());
    }

}
