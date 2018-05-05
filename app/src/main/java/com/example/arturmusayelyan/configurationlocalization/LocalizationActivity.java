package com.example.arturmusayelyan.configurationlocalization;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LocalizationActivity extends AppCompatActivity {
    private TextView helloTv, howAreYouTv;
    private Resources resources;
    private Configuration configuration;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization);
        resources=getResources();
        configuration=resources.getConfiguration();
        displayMetrics=resources.getDisplayMetrics();
        init();
    }

    private void init() {
        helloTv = findViewById(R.id.hello_tv);
        howAreYouTv = findViewById(R.id.how_are_you_tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Locale locale;
        switch (item.getItemId()) {
            case R.id.english_item:
                Toast.makeText(this,"Selected English language",Toast.LENGTH_SHORT).show();
                locale = Locale.ENGLISH;
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration,displayMetrics);
//                finish();
//                startActivity(new Intent(this, LocalizationActivity.class));
                recreate();
                return true;
            case R.id.france_item:
                Toast.makeText(this,"Selected France language",Toast.LENGTH_SHORT).show();
                locale = Locale.FRANCE;
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration,displayMetrics);
//                finish();
//                startActivity(new Intent(this, LocalizationActivity.class));
                recreate();
                return true;
            case R.id.armenian_item:
                Toast.makeText(this,"Selected Armenian language",Toast.LENGTH_SHORT).show();
                locale = new Locale("hy");
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration,displayMetrics);
                finish();
                startActivity(new Intent(this, LocalizationActivity.class));
                //recreate();
                return true;
            default:
                Toast.makeText(this,"Selected default language",Toast.LENGTH_SHORT).show();
                locale = Locale.ENGLISH;
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration,displayMetrics);
//                finish();
//                startActivity(new Intent(this, LocalizationActivity.class));
                recreate();
                return super.onOptionsItemSelected(item);
        }

    }
    public void printLogs(View view){
        Log.d("Art", configuration.locale + "");
    }
}
