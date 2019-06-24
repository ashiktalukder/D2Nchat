package com.example.helper;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class comunication extends AppCompatActivity {
    TextView output;
    ImageView mic;
    EditText editText;
    String bn;
    String texts;
    //textToSpeech;
    TextToSpeech t1;
    EditText edittext2;
    ImageView speek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunication);

        edittext2 = (EditText) findViewById(R.id.edittext2);
        speek = (ImageView) findViewById(R.id.speek);

        editText = (EditText) findViewById(R.id.edittext);
        output = (TextView) findViewById(R.id.textview);
        output.setText("");
        mic = (ImageView) findViewById(R.id.mic);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });
        speek.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String toSpeak = edittext2.getText().toString();
               // Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                return false;
            }
        });




        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnToOpenMic(editText.getText().toString());
            }
        });


    }

    private void btnToOpenMic(String lan) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        if (lan==null){
            lan="en";
        }


        String languagePref = lan;
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languagePref);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,languagePref);
        intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE,languagePref);

        intent.putExtra("android.speech.extra.EXTRA_ADDITIONAL_LANGUAGES", new String[]{"en"});


        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to search");

        try {
            startActivityForResult(intent, 143);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn\\'t support speech input",
                    Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 143: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // ArrayList<String> v=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //  String d = voiceInsText.toString();

                    texts = voiceInText.get(0);
                    output.setText(texts);


                }
                break;
            }
        }


    }


}









