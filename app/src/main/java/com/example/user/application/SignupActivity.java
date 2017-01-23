package com.example.user.application;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignupActivity extends AppCompatActivity {

    Button btn_cancel;
    Button btn_save;
    EditText et_id;
    EditText et_pw;
    EditText et_name;
    EditText et_age;
    EditText et_email;
    EditText et_addr;
    EditText et_phone;
    RadioButton rb_male;
    RadioButton rb_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        btn_cancel = (Button) findViewById(R.id.button9);
        btn_save = (Button) findViewById(R.id.button10);
        et_id = (EditText)findViewById(R.id.editText3);
        et_pw = (EditText)findViewById(R.id.editText4);
        et_name = (EditText)findViewById(R.id.editText5);
        et_age = (EditText)findViewById(R.id.editText6);
        et_email = (EditText)findViewById(R.id.editText7);
        et_addr = (EditText)findViewById(R.id.editText8);
        et_phone = (EditText)findViewById(R.id.editText9);
        rb_male =(RadioButton)findViewById(R.id.radioButton);
        rb_female =(RadioButton)findViewById(R.id.radioButton2);

        
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText(String.valueOf(""));
                et_pw.setText(String.valueOf(""));
                et_name.setText(String.valueOf(""));
                et_age.setText(String.valueOf(""));
                et_email.setText(String.valueOf(""));
                et_addr.setText(String.valueOf(""));
                et_phone.setText(String.valueOf(""));
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setTitle("축하합니다. 가입되었습니다.");

            }
        });






    }
}
