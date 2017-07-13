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

public class TranimList extends AppCompatActivity {

    @BindView(R.id.tvTranimOloLelSediik)
    TextView tvTranimOloLelSediik;
    @BindView(R.id.tvTranimAalyLfook)
    TextView tvTranimAalyLfook;
    @BindView(R.id.tvTranimGhnoM3aia)
    TextView tvTranimGhnoM3aia;
    @BindView(R.id.tvTranimAnaHafra7Beek)
    TextView tvTranimAnaHafra7Beek;
    @BindView(R.id.tvTranimBemrahemElrab)
    TextView tvTranimBemrahemElrab;
    @BindView(R.id.tvTranimFar7etAlbyYoumMa2bltk)
    TextView tvTranimFar7etAlbyYoumMa2bltk;
    @BindView(R.id.tvTranimFarhanBeek)
    TextView tvTranimFarhanBeek;
    @BindView(R.id.tvTranimM3aEnElEtneen)
    TextView tvTranimM3aEnElEtneen;
    @BindView(R.id.tvTranimOmryMaDo2t)
    TextView tvTranimOmryMaDo2t;
    @BindView(R.id.tvTranimYerwinyBhnana)
    TextView tvTranimYerwinyBhnana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranim_list);

        ButterKnife.bind(this);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Mirza-Regular.ttf");

        tvTranimOloLelSediik.setTypeface(custom_font);
        tvTranimAalyLfook.setTypeface(custom_font);
        tvTranimGhnoM3aia.setTypeface(custom_font);

        tvTranimAnaHafra7Beek.setTypeface(custom_font);
        tvTranimBemrahemElrab.setTypeface(custom_font);
        tvTranimFar7etAlbyYoumMa2bltk.setTypeface(custom_font);
        tvTranimFarhanBeek.setTypeface(custom_font);
        tvTranimM3aEnElEtneen.setTypeface(custom_font);
        tvTranimOmryMaDo2t.setTypeface(custom_font);
        tvTranimYerwinyBhnana.setTypeface(custom_font);


    }

    @OnClick(R.id.tvTranimOloLelSediik)
    void onclicktvTranimOloLelSediik() {

        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/2olo_lel_sdek.html");
        startActivity(new Intent(this, ProgrammeHtml.class));

    }

    @OnClick(R.id.tvTranimAalyLfook)
    void onclicktvTranimAalyLfook() {

        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/3aly_lfo2.html");
        startActivity(new Intent(this, ProgrammeHtml.class));

    }

    @OnClick(R.id.tvTranimGhnoM3aia)
    void onclicktvTranimGhnoM3aia() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/5no_ma3ia.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimAnaHafra7Beek)
    void onclicktvTranimAnaHafra7Beek() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/ana_hafr7_beek.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimBemrahemElrab)
    void onclicktvTranimBemrahemElrab() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/bemarhem_elrab.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimFar7etAlbyYoumMa2bltk)
    void onclicktvTranimFar7etAlbyYoumMa2bltk() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/far7et_alby_youm ma2bltk.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimFarhanBeek)
    void onclicktvTranimFarhanBeek() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/frhan_beek.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimM3aEnElEtneen)
    void onclicktvTranimM3aEnElEtneen() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/m3a_en_eltenen.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimOmryMaDo2t)
    void onclicktvTranimOmryMaDo2t() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/omry_mado2t_sa3ada.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

    @OnClick(R.id.tvTranimYerwinyBhnana)
    void onclicktvTranimYerwinyBhnana() {
        Singletone.Instance().setHtmlUrL("file:///android_asset/Tranem/yaroweny_be7nank.html");
        startActivity(new Intent(this, ProgrammeHtml.class));
    }

}
