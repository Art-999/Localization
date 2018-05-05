package com.example.arturmusayelyan.configurationlocalization;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

public class MyApplication extends android.app.Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private static Locale locale = null;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            newConfig.locale = locale;
            Locale.setDefault(locale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static void setLocale(Locale loc) {
        locale = loc;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Foreground.init(this);
//        // Init Settings
//        SaveAppSettings.readAppSettingsInfo(getApplicationContext());
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
    }
}
