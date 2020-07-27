package com.tsc.leonid.android_geekbrains;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonGW;
    private TextView textRes;
    private EditText textLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setOnButtonGWClickBehaviour();
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
}