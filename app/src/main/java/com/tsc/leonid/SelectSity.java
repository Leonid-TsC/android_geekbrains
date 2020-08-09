package com.tsc.leonid.android_geekbrains;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tsc.leonid.android_geekbrains.MainActivity;


public class SelectSity extends AppCompatActivity {
    final static String sityDataKey = "sityDataKey";
    final static String windSpeedDataKey = "weatherDataKey";
    final static String pressureDataKey = "pressureDataKey";

    private TextView sityOfUser;
    private CheckBox windSpeed, pressure;
    private Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();
        setOnButtonOkClickBehaviour();
        showDataSettings();
    }

    private void initViews(){
        sityOfUser = findViewById(R.id.sityOfUser);
        windSpeed = findViewById(R.id.windSpeed);
        pressure = findViewById(R.id.pressure);
        buttonOk = findViewById(R.id.buttonOk);
    }

    private void setOnButtonOkClickBehaviour(){
        buttonOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                closeSettingsActivity();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            closeSettingsActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void closeSettingsActivity(){
        Intent intent = new Intent();
        intent.putExtra(sityDataKey, sityOfUser.getText().toString());
        intent.putExtra(windSpeedDataKey, windSpeed.isChecked());
        intent.putExtra(pressureDataKey, pressure.isChecked());

        setResult(RESULT_OK, intent);
        //finish();
        super.onBackPressed();
    }

    private void showDataSettings(){
        Intent intent = getIntent();
        String sity = intent.getStringExtra(MainActivity.sityDataKey);
        boolean chck1 = intent.getBooleanExtra(MainActivity.windSpeedDataKey, false);
        boolean ckck2 = intent.getBooleanExtra(MainActivity.pressureDataKey, false);

        sityOfUser.setText(sity);
        windSpeed.setChecked(chck1);
        pressure.setChecked(ckck2);

    }
}
