package com.example.helper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 private static final String TAG="MainActivity";
 private static final String[] PERMISSION ={Manifest.permission.RECORD_AUDIO};
    private Button buttoncomunication;
    private Button buttonfamily;
    private Button buttoneducation;
    private Button buttonfood;
    private Button buttonshopping;
    private Button buttonhospital;
    private Button buttontransport;
    private Button buttonsms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   checkpermisson();

        buttoncomunication = findViewById(R.id.buttoncomunication);
        buttoncomunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openComunication();
            }

            private void openComunication() {

                Intent intent = new Intent(MainActivity.this,comunication.class);
                startActivity(intent);

            }
        });
        buttonfamily = findViewById(R.id.buttonfamily);
        buttonfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFamily();
            }
            private void openFamily() {
                Intent intent = new Intent(MainActivity.this,Family.class);
                startActivity(intent);
            }
        });
        buttoneducation = findViewById(R.id.buttoneducation);
        buttoneducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEducation();
            }

            private void openEducation() {
                Intent intent = new Intent(MainActivity.this,Education.class);
                startActivity(intent);
            }
        });
        buttonfood = findViewById(R.id.buttonfood);
        buttonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfood();
            }

            private void openfood() {
                Intent intent = new Intent(MainActivity.this,Food.class);
                startActivity(intent);
            }
        });
        buttonshopping = findViewById(R.id.buttonshopping);
        buttonshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openshopping();
            }

            private void openshopping() {
                Intent intent = new Intent(MainActivity.this,Shopping.class);
                startActivity(intent);
            }
        });

        buttonhospital = findViewById(R.id.buttonhospital);
        buttonhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhospital();
            }

            private void openhospital() {
                Intent intent = new Intent(MainActivity.this,Hospital.class);
                startActivity(intent);
            }
        });
        buttontransport = findViewById(R.id.buttontransport);
        buttontransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentransport();
            }

            private void opentransport() {
                Intent intent = new Intent(MainActivity.this,Transport.class);
                startActivity(intent);
            }
        });

        buttonsms = findViewById(R.id.buttonsms);
        buttonsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensms();
            }

            private void opensms() {
                Intent intent = new Intent(MainActivity.this,Sms.class);
                startActivity(intent);
            }
        });
    }



    private void checkpermisson() {
        Log.d(TAG,"checkpermmisson");
        int permission= ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.RECORD_AUDIO);

        if(permission != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,PERMISSION,1);
        }

    }


}
