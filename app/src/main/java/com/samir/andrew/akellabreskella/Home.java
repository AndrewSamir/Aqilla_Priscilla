package com.samir.andrew.akellabreskella;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import io.fabric.sdk.android.Fabric;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tvHappenNowHome)
    TextView tvHappenNowHome;

    @BindView(R.id.tvAya)
    TextView tvAya;

    @BindView(R.id.tvNow)
    TextView tvNow;

    @BindView(R.id.tvPlaceHome)
    TextView tvPlaceHome;

    @BindView(R.id.tvAqilla)
    TextView tvAqilla;

    FirebaseRemoteConfig mFirebaseRemoteConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);

        ButterKnife.bind(this);
        fetch();

        Typeface custom_font_en = Typeface.createFromAsset(getAssets(), "fonts/PathwayGothicOne-Regular.ttf");
        Typeface custom_font_ar_bold = Typeface.createFromAsset(getAssets(), "fonts/Mirza-Bold.ttf");
        Typeface custom_font_ar = Typeface.createFromAsset(getAssets(), "fonts/Mirza-Regular.ttf");
        Typeface custom_font_ar_semi = Typeface.createFromAsset(getAssets(), "fonts/Mirza-SemiBold.ttf");

        tvNow.setTypeface(custom_font_en);
        tvAya.setTypeface(custom_font_ar_bold);
        tvHappenNowHome.setTypeface(custom_font_ar);
        tvPlaceHome.setTypeface(custom_font_ar);
        tvAqilla.setTypeface(custom_font_ar_semi);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_st_mark) {

            startActivity(new Intent(this, daysList.class));
            // Handle the camera action
        } else if (id == R.id.nav_aqilla_priscilla_story) {
            startActivity(new Intent(this, TranimList.class));

        } else if (id == R.id.nav_meeting_summary) {
            startActivity(new Intent(this, HymnsList.class));

        } else if (id == R.id.nav_meeting_legan) {

            Singletone.Instance().setHtmlUrL("file:///android_asset/group_.html");
            startActivity(new Intent(this, ProgrammeHtml.class));

        } else if (id == R.id.nav_contact_us) {

            Singletone.Instance().setHtmlUrL("file:///android_asset/group_.html");
            startActivity(new Intent(this, ProgrammeHtml.class));

        } else if (id == R.id.nav_messages) {
           // Singletone.Instance().setHtmlUrL("file:///android_asset/57_Philipians.html");
            startActivity(new Intent(this, MessagesList.class));
        } else if (id == R.id.nav_about_us) {
            Singletone.Instance().setHtmlUrL("file:///android_asset/about_us.html");
            startActivity(new Intent(this, ProgrammeHtml.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void fetch() {
        mFirebaseRemoteConfig.fetch(3)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("fetch", "s");

                            // Once the config is successfully fetched it must be activated before newly fetched
                            // values are returned.
                            mFirebaseRemoteConfig.activateFetched();
                        } else {
                            Log.d("fetch", "f");

                        }
                        tvAya.setText(mFirebaseRemoteConfig.getString("qoute"));
                        tvHappenNowHome.setText(mFirebaseRemoteConfig.getString("now"));
                        tvPlaceHome.setText(mFirebaseRemoteConfig.getString("place"));
                    }
                });
    }
}
