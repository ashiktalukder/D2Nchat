package com.example.helper;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Sms extends AppCompatActivity {

    Button btnlogin;
    Button btnregister;
  FirebaseUser firebaseUser;

protected void onStart(){
    super.onStart();
    firebaseUser =FirebaseAuth.getInstance().getCurrentUser();
    if (firebaseUser != null){
        Intent intent = new Intent(Sms.this,chatActivity.class);
        startActivity(intent);
        finish();
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        btnlogin = findViewById(R.id.btnlogin);
        btnregister = findViewById(R.id.btnregister);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sms.this,loginActivity.class);
                startActivity(intent);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sms.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
}

}
