package com.example.mohammed.tafseerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import models.Sura;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.aya_txt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "ggjhgjgj", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AyaActivity.class));
                finish();
            }
        });

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Sura>> call = apiService.getSoura();
        call.enqueue(new Callback<List<Sura>>() {
            @Override
            public void onResponse(Call<List<Sura>> call, Response<List<Sura>> response) {
                Toast.makeText(MainActivity.this, ""+response.body().size(), Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "++++++++++", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Sura>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
