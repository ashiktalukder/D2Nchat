package com.example.helper;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Shopping extends AppCompatActivity {

    TextToSpeech t1;
    TextView txt1;
    TextView  txt2;
    TextView  txt3;
    TextView  txt4;
    TextView  txt5;

    ImageButton image_btn;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3= findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        edittext = findViewById(R.id.edittext);
        image_btn = findViewById(R.id.image_btn);

        image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = edittext.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt1.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt2.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt3.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt4.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt5.getText().toString();

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
