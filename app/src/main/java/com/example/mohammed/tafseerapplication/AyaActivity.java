package com.example.mohammed.tafseerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import models.Aya;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Callback;
import retrofit2.Response;

public class AyaActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aya);


        textView=findViewById(R.id.tafseer_txt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AyaActivity.this,TafseerActivity.class));
                finish();
            }
        });


        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<Aya> call = apiServices.getAya(1, 2);
        call.enqueue(new Callback<Aya>() {
            @Override
            public void onResponse(retrofit2.Call<Aya> call, Response<Aya> response) {
//                Toast.makeText(AyaActivity.this, "" + response.body().getSuraIndex(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AyaActivity.this, "" + response.body().getSuraName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AyaActivity.this, " الآيه رقم " + response.body().getAyahNumber(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AyaActivity.this, "" + response.body().getAyaText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<Aya> call, Throwable t) {
                Toast.makeText(AyaActivity.this, "" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
