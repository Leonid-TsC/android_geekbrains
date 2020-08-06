package com.tsc.leonid.android_geekbrains;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonGW;
    private TextView textRes;
    private EditText textLoc;
    private final String eventTag = String.valueOf(R.string.event_toast_oncreate);
    private final String weatherDataKey = "weatherDataKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnButtonGWClickBehaviour();

        Toast.makeText(getApplicationContext(), R.string.event_toast_oncreate, Toast.LENGTH_SHORT).show();
        String str = String.valueOf(R.string.event_toast_oncreate);
        Log.d(eventTag, str);

    }

    private void initViews(){
        buttonGW = findViewById(R.id.button);
        textRes = findViewById(R.id.textView);
        textLoc = findViewById(R.id.editTextLocation);
    }

    private void setOnButtonGWClickBehaviour(){
        buttonGW.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String res = getString(R.string.ResOfWeather);
                textRes.setText(res);
            }
        });
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