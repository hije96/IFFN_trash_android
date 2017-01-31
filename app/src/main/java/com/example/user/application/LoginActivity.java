package com.example.user.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btn_signup;
    Button btn_login;
    EditText et_id;
    EditText et_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_signup = (Button) findViewById(R.id.button7);
        btn_login = (Button) findViewById(R.id.button8);
        et_id = (EditText)findViewById(R.id.editText);
        et_pw = (EditText)findViewById(R.id.editText2);

     //   Intent intent2 = new Intent(this, splash.class);
     //   startActivity(intent2);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent3 = new Intent(LoginActivity.this, SignupActivity.class);
                Intent intent3 = new Intent(getApplicationContext(), SignupActivity.class);
                //startActivity(intent3);
               // finish();
               //Intent intent3 = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent3);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
