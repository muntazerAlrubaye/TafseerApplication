package com.example.mohammed.tafseerapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import models.Aya;
import models.Sura;
import models.SuraFull;
import models.SuraResponse;
import rest.ApiClient;
import rest.ApiClientSura;
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

        final ApiInterface apiServices = ApiClientSura.getAllSura().create(ApiInterface.class);
        Call<SuraFull> call = apiServices.getFullSura();
        call.enqueue(new Callback<SuraFull>() {
            @Override
            public void onResponse(Call<SuraFull> call, Response<SuraFull> response) {
                TextView textView = findViewById(R.id.sura_full);

//                textView.setText(response.body().getVerse().getString("verse_1").toString());
                Toast.makeText(SuraFullActivity.this,"" , Toast.LENGTH_SHORT).show();//add response here


            }

            @Override
            public void onFailure(Call<SuraFull> call, Throwable t) {
                Toast.makeText(SuraFullActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
