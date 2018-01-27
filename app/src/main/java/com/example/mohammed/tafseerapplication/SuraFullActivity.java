package com.example.mohammed.tafseerapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import models.Aya;
import models.Sura;
import models.SuraFull;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohammed on 1/28/2018.
 */

public class SuraFullActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_sura);

        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<List<SuraFull>> call = apiServices.getFullSura();
        call.enqueue(new Callback<List<SuraFull>>() {
            @Override
            public void onResponse(Call<List<SuraFull>> call, Response<List<SuraFull>> response) {
                Toast.makeText(SuraFullActivity.this, "" + response.body().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<SuraFull>> call, Throwable t) {
                Toast.makeText(SuraFullActivity.this, "0" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
