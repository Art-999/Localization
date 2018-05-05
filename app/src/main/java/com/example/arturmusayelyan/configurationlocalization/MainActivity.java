package com.example.arturmusayelyan.configurationlocalization;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private Button justClickBtn;
    private int number;
    private Configuration configuration;
    private DisplayMetrics displayMetrics;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        resources = getResources();
        configuration = resources.getConfiguration();
        displayMetrics = resources.getDisplayMetrics();

        //resources.updateConfiguration(configuration,displayMetrics);

    }

    private void init() {
        tv1 = findViewById(R.id.tv_1);
        justClickBtn = findViewById(R.id.just_click_button);
    }

    private void printLogs(Configuration configuration, DisplayMetrics displayMetrics) {
        Log.d("Art", configuration.locale + "");
        Log.d("Art", displayMetrics + "");
    }

    public void justClick(View view) {
        number++;
        tv1.setText(number + "");

        if (number == 2) {
            configuration.setLocale(new Locale("ja"));
            resources.updateConfiguration(configuration, displayMetrics);
        }

        printLogs(configuration, displayMetrics);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToLocalizationActivity(View view) {
        startActivity(new Intent(this, LocalizationActivity.class));
    }
}
