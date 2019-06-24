package com.example.helper;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Food extends AppCompatActivity {
    TextToSpeech t1;
    TextView txtfood1;
    TextView txtfood2;
    TextView txtfood3;
    TextView txtfood4;
    TextView txtfood5;
    TextView txtfood6;
    TextView txtfood7;
    TextView txtfood8;

    EditText edittxt;
    ImageButton imagebtnfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //find textview;
        txtfood1 =findViewById(R.id.txtfood1);
        txtfood2 =findViewById(R.id.txtfood2);
        txtfood3 =findViewById(R.id.txtfood3);
        txtfood4 =findViewById(R.id.txtfood4);
        txtfood5 =findViewById(R.id.txtfood5);
        txtfood6 =findViewById(R.id.txtfood6);
        txtfood7 =findViewById(R.id.txtfood7);
        txtfood8 =findViewById(R.id.txtfood8);

        imagebtnfood = findViewById(R.id.imagebtnfood);
        edittxt = findViewById(R.id.edittext);


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        txtfood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood1.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood2.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood3.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood4.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood5.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood6.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood7.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        txtfood8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtfood8.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}
