package com.greedygame.samplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;

    public static final String APP_DESTROY_TIME = "app_destroy_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView currentTime = (TextView) findViewById(R.id.currentTime);
        TextView lastTime = (TextView) findViewById(R.id.lastTime);
        String openTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        currentTime.setText(openTime);

        preferences= getSharedPreferences("GG_StoredTime",Context.MODE_PRIVATE);
        String pastTime= preferences.getString(APP_DESTROY_TIME,null);
        if (pastTime!=null)
        {
            lastTime.setText(pastTime);
        }
        else{}

    }

    @Override
    public void onPause()
    {
        super.onPause();
        String closeTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(APP_DESTROY_TIME,closeTime).apply();

    }

}
