package com.example.user.application;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    Button btn_flaovr_1;
    Button btn_flaovr_2;
    Button btn_flaovr_3;
    Button btn_flaovr_4;
    Button btn_start;
    Button btn_reset;
    //ApiService apiService;
    Retrofit retrofit;
    Context context;
    FlavorDB_Adapter db;



    int i=0;
    int flavor_1 = 0, flavor_2 = 0, flavor_3 = 0, flavor_4 = 0;
    int idx=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        btn_flaovr_1 = (Button) findViewById(R.id.button);
        btn_flaovr_2 = (Button) findViewById(R.id.button2);
        btn_flaovr_3 = (Button) findViewById(R.id.button3);
        btn_flaovr_4 = (Button) findViewById(R.id.button4);
        btn_start = (Button) findViewById(R.id.button5);
        btn_reset = (Button) findViewById(R.id.button6);

        db = new FlavorDB_Adapter(this);
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      //  Intent intent = new Intent(this, LoginActivity.class);
      //  startActivity(intent);

        btn_flaovr_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_flaovr_1.setText(String.valueOf(++flavor_1));
            }
        });
        btn_flaovr_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_flaovr_2.setText(String.valueOf(++flavor_2));
            }
        });
        btn_flaovr_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_flaovr_3.setText(String.valueOf(++flavor_3));
            }
        });
        btn_flaovr_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_flaovr_4.setText(String.valueOf(++flavor_4));
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flavor_1 == 0 && flavor_2 == 0 && flavor_3 == 0 && flavor_4 == 0) {
                    Toast.makeText(getApplicationContext(), "향이 선택되어야 합니다.", Toast.LENGTH_SHORT).show();
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("배합하시겠습니까?");
                    AlertDialog.Builder 예 = builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CLoading.showLoading(context);    //show
                            retrofit = new Retrofit.Builder()
                                    .baseUrl(ApiService.API_URL)
                                    .addConverterFactory(GsonConverterFactory.create()).build();
                            ApiService apiService = retrofit.create(ApiService.class);
                            //  Call<ResponseJson> comment = apiService.getComment(x);
                            final DataModel datamodel = new DataModel(idx,flavor_1,flavor_2,flavor_3,flavor_4);
                            db.insert(idx,flavor_1,flavor_2,flavor_3,flavor_4);

                            Call<ResponseJson> call = apiService.getComment(datamodel);

                            call.enqueue(new Callback<ResponseJson>() {
                                @Override
                                public void onResponse(Call<ResponseJson> call, Response<ResponseJson> response) {

                                    Log.d("Response", response.body().toString());
                                    ResponseJson responseJson= response.body();

                                    Log.v("ResponseJson", "" + responseJson.getResponse_flavor_1() + responseJson
                                            .getResponse_flavor_2() + responseJson.getResponse_flavor_3() + responseJson.getResponse_flavor_4());

                                    Log.i("Response", response.toString());
                                    Toast.makeText(getApplicationContext(), "통신 성공", Toast.LENGTH_SHORT).show();

                                    btn_flaovr_1.setText(String.valueOf(flavor_1 = 0));
                                    btn_flaovr_2.setText(String.valueOf(flavor_2 = 0));
                                    btn_flaovr_3.setText(String.valueOf(flavor_3 = 0));
                                    btn_flaovr_4.setText(String.valueOf(flavor_4 = 0));
                                }

                                @Override
                                public void onFailure(Call<ResponseJson> call, Throwable t) {
                                    Log.v("Response","Fail");
                                    Toast.makeText(getApplicationContext(), "통신 실패", Toast.LENGTH_SHORT).show();
                                }
                            });

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // 5초 뒤에 작동!! -> 5s = 5000ms
                                    CLoading.hideLoading();
                                }
                            }, 5000);



                        }
                    });

                    builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });



        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_flaovr_1.setText(String.valueOf(flavor_1 = 0));
                btn_flaovr_2.setText(String.valueOf(flavor_2 = 0));
                btn_flaovr_3.setText(String.valueOf(flavor_3 = 0));
                btn_flaovr_4.setText(String.valueOf(flavor_4 = 0));

            }
        });
    }
}


