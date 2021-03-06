package com.example.motivation.if_hackathon;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TitleActivity extends AppCompatActivity {

    Button btnStart;
    ActionBar actionBar;
    String sfName = "myFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        actionBar = getSupportActionBar();
        actionBar.hide();

        SharedPreferences sf = getSharedPreferences(sfName, 0);
        final boolean isFirstLaunchAppChecked = sf.getBoolean("isFirstLaunchAppChecked",true);

        btnStart = (Button) findViewById(R.id.title_btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFirstLaunchAppChecked == true) {
                    Intent intent = new Intent(TitleActivity.this, TutorialAcitivty.class);
                    startActivity(intent);
                    finish();
                }else if(isFirstLaunchAppChecked == false){
                    Intent intent = new Intent(TitleActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE},
                        100);
            }
        }
    }
}
