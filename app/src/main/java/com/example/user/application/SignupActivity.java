package com.example.user.application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        btn_cancel = (Button) findViewById(R.id.button9);
        btn_save = (Button) findViewById(R.id.button10);
        et_id = (EditText) findViewById(R.id.editText3);
        et_pw = (EditText) findViewById(R.id.editText4);
        et_name = (EditText) findViewById(R.id.editText5);
        et_age = (EditText) findViewById(R.id.editText6);
        et_email = (EditText) findViewById(R.id.editText7);
        et_addr = (EditText) findViewById(R.id.editText8);
        et_phone = (EditText) findViewById(R.id.editText9);
        rb_male = (RadioButton) findViewById(R.id.radioButton);
        rb_female = (RadioButton) findViewById(R.id.radioButton2);


//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);

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
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MemberDataModel data_temp = new MemberDataModel();
                    data_temp.id = et_id.getText().toString();
                    data_temp.pw = et_pw.getText().toString();
                    data_temp.name = et_name.getText().toString();
                    data_temp.age = Integer.parseInt(et_age.getText().toString());
                    data_temp.email = et_email.getText().toString();
                    data_temp.addr = et_addr.getText().toString();
                    data_temp.phone = Integer.parseInt(et_phone.getText().toString());

                  //  MemberDataModel.add(0, data_temp);
                  //  adapter.notifyDataSetChanged();
//////////////////////////
                    retrofit = new Retrofit.Builder()
                            .baseUrl(MemberApiService.API_URL)
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    MemberApiService memberapiService = retrofit.create(MemberApiService.class);
                    //  Call<ResponseJson> comment = apiService.getComment(x);
                    final MemberDataModel datamodel = data_temp;

                    Call<MemberResponseJson> call = memberapiService.getComment(datamodel);

                    call.enqueue(new Callback<MemberResponseJson>() {
                        @Override
                        public void onResponse(Call<MemberResponseJson> call, Response<MemberResponseJson> response) {
                            /*
                            Log.d("Response", response.body().toString());
                            MemberResponseJson responseJson = response.body();

                            Log.v("ResponseJson", "" + responseJson.getResponse_flavor_1() + responseJson
                                    .getResponse_flavor_2() + responseJson.getResponse_flavor_3() + responseJson.getResponse_flavor_4());

                            Log.i("Response", response.toString());
                            */
                            Toast.makeText(getApplicationContext(), "통신 성공", Toast.LENGTH_SHORT).show();

                            AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                            builder.setTitle("축하합니다. 가입되었습니다.");
                            AlertDialog.Builder 예 = builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                            /*
                            btn_flaovr_1.setText(String.valueOf(flavor_1 = 0));
                            btn_flaovr_2.setText(String.valueOf(flavor_2 = 0));
                            btn_flaovr_3.setText(String.valueOf(flavor_3 = 0));
                            btn_flaovr_4.setText(String.valueOf(flavor_4 = 0));
                            */
                        }

                        @Override
                        public void onFailure(Call<MemberResponseJson> call, Throwable t) {
                            Log.v("Response", "Fail");
                            Toast.makeText(getApplicationContext(), "통신 실패", Toast.LENGTH_SHORT).show();
                        }
                    });
/////////////////////////
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "정보를 올바르게 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
// Toast.makeText(getApplicationContext(), "축하합니다. 가입되었습니다.", Toast.LENGTH_SHORT).show();
