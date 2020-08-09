package com.tsc.leonid.android_geekbrains;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tsc.leonid.android_geekbrains.SelectSity;


public class MainActivity extends AppCompatActivity {
    private Button buttonGetWeight, buttonSelectSity, buttonOpenWiki;
    private TextView textRes;
    private final String eventTag = String.valueOf(R.string.event_toast_oncreate);
    private final String weatherDataKey = "weatherDataKey";

    private final int requestCodeSettings = 32167;
    final static String sityDataKey = "sityDataKey";
    final static String windSpeedDataKey = "windSpeedDataKey";
    final static String pressureDataKey = "pressureDataKey";
    private String sityOfUser;
    private boolean windSpeed, pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnbuttonGetWeightClickBehaviour();
        setOnbuttonSelectSityClickBehaviour();
        setOnbuttonOpenWikiClickBehaviour();

        Toast.makeText(getApplicationContext(), R.string.event_toast_oncreate, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_oncreate);
        Log.d(eventTag, str);

    }

    private void initViews(){
        buttonGetWeight = findViewById(R.id.buttonGW);
        buttonSelectSity = findViewById(R.id.btnSelectSity);
        buttonOpenWiki = findViewById(R.id.btnOpewWiki);
        textRes = findViewById(R.id.textView);
    }

    private void setOnbuttonGetWeightClickBehaviour(){
        buttonGetWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text1 = getString(R.string.ResOfWeather);
                String text2 = getString(R.string.ResOfWeather2);
                String res = textRes.getText().toString();
                if (res.equals(text1)) textRes.setText(text2);
                else textRes.setText(text1);
            }
        });
    }

    private void setOnbuttonSelectSityClickBehaviour(){
        buttonSelectSity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SelectSity.class);
                intent.putExtra(sityDataKey, sityOfUser);
                intent.putExtra(windSpeedDataKey, windSpeed);
                intent.putExtra(pressureDataKey, pressure);

                startActivityForResult(intent, requestCodeSettings);
            }
        });
    }

    private void setOnbuttonOpenWikiClickBehaviour(){
        buttonOpenWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wikilink = getString(R.string.wiki_link);
                wikilink += sityOfUser;

                Uri uri = Uri.parse(wikilink);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == this.requestCodeSettings && resultCode == RESULT_OK && data != null){
            sityOfUser = data.getStringExtra(SelectSity.sityDataKey);
            windSpeed = data.getBooleanExtra(SelectSity.windSpeedDataKey, false);
            pressure = data.getBooleanExtra(SelectSity.pressureDataKey, false);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        String text = textRes.getText().toString();
        savedInstanceState.putString(weatherDataKey, text);
        super.onSaveInstanceState(savedInstanceState);

        Toast.makeText(getApplicationContext(), R.string.event_toast_oncreate, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(getString(R.string.event_toast_onSaveInstanceState));
        Log.d(eventTag, str);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString(weatherDataKey);
        textRes.setText(text);

        Toast.makeText(getApplicationContext(), R.string.event_toast_oncreate, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(getString(R.string.event_toast_onRestoreInstanceState));
        Log.d(eventTag, str);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), R.string.event_toast_onstart, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_onstart);
        Log.d(eventTag, str);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplicationContext(), R.string.event_toast_onrestart, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_onrestart);
        Log.d(eventTag, str);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), R.string.event_toast_onresume, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_onresume);
        Log.d(eventTag, str);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), R.string.event_toast_onpause, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_onresume);
        Log.d(eventTag, str);
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), R.string.event_toast_onstop, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_onstop);
        Log.d(eventTag, str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), R.string.event_toast_ondestroy, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_ondestroy);
        Log.d(eventTag, str);
    }
}