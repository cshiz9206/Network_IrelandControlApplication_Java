package com.example.irelandcontrollerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "MainActivityLog";
    private final String URL = "http://210.102.142.30:5050"; //ethernet ipv4 addr

    private Retrofit retrofit;
    private ApiService service;

    private Button btn_get, btn_post, btn_delete, btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstInit();

        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    /**
     * Init
     */
    public void firstInit() {
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post = (Button) findViewById(R.id.btn_post);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_update = (Button) findViewById(R.id.btn_update);

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }

    /**
     * View.OnLongClickListener override method
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                Call<ResponseBody> call_get = service.getFunc("undefined");
                call_get.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            ResponseBody result = response.body();
                            try {
                                Log.v(TAG, "result = " + result.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(getApplicationContext(), "result = " + result, Toast.LENGTH_SHORT).show();
                        } else {
                            Log.v(TAG, "error = " + String.valueOf(response.code()));
                            Toast.makeText(getApplicationContext(), "error = " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.v(TAG, "Fail");
                        Toast.makeText(getApplicationContext(), "Response Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn_post:
                Call<ResponseBody> call_post = service.postFunc("on", "red", "");
                call_post.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String result = response.body().string();
                                Log.v(TAG, "result = " + result);
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.v(TAG, "error = " + String.valueOf(response.code()));
                            Toast.makeText(getApplicationContext(), "error = " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.v(TAG, "Fail");
                        Toast.makeText(getApplicationContext(), "Response Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn_update:
                int[] tmp = {1, 2};
                DataControl cmd = new DataControl("sens", "2", "3", tmp);
                service.setCmd("set", cmd).enqueue(new Callback<DataControl>() {
                    @Override
                    public void onResponse(Call<DataControl> call, Response<DataControl> response) {
                        if (response.isSuccessful()) {
                            String result = response.body().toString();
                            Log.v(TAG, "result = " + result);
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                        } else {
                            Log.v(TAG, "error = " + String.valueOf(response.code()));
                            Toast.makeText(getApplicationContext(), "error = " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DataControl> call, Throwable t) {
                        Log.v(TAG, "Fail");
                        Toast.makeText(getApplicationContext(), "Response Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn_delete:
                Call<ResponseBody> call_delete = service.deleteFunc("board");
                call_delete.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String result = response.body().string();
                                Log.v(TAG, "result = " + result);
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.v(TAG, "error = " + String.valueOf(response.code()));
                            Toast.makeText(getApplicationContext(), "error = " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.v(TAG, "Fail");
                        Toast.makeText(getApplicationContext(), "Response Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }
    }

}