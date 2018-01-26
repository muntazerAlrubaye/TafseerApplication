package com.example.mohammed.tafseerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import models.Tafseer;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TafseerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafseer);

        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Tafseer>> call = apiServices.getTafseerName();
        call.enqueue(new Callback<List<Tafseer>>() {
            @Override
            public void onResponse(Call<List<Tafseer>> call, Response<List<Tafseer>> response) {

                Toast.makeText(TafseerActivity.this, ""+response.body().get(1).getName().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Tafseer>> call, Throwable t) {
                Log.e("+++++++",t.getMessage()) ;
                Toast.makeText(TafseerActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();

            }

        });

    }
}
