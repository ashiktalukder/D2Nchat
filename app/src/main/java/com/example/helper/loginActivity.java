package com.example.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button btn_login;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password =findViewById(R.id.password);
        btn_login =findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email= email.getText().toString();
                String txt_password= password.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(loginActivity.this,"All filed are requierd",Toast.LENGTH_SHORT).show();

                }else {
                    auth.signInWithEmailAndPassword(txt_email,txt_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){

                                        Intent intent = new Intent(loginActivity.this,chatActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                }else {
                                        Toast.makeText(loginActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    }
}
