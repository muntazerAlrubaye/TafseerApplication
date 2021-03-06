package com.example.mohammed.tafseerapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;

import models.Sura;
import models.SuraFull;
import rest.ApiClientSura;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohammed on 1/28/2018.
 */

public class SuraFullActivity extends AppCompatActivity {

    TextView suraFullTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_sura);

        suraFullTV = findViewById(R.id.sura_full);
        Bundle bundle = getIntent().getExtras();
        String index = bundle.getString("index");
        final ApiInterface apiServices = ApiClientSura.getAllSura().create(ApiInterface.class);
        Call<SuraFull> call = apiServices.getFullSura(index);
        call.enqueue(new Callback<SuraFull>() {
            @Override
            public void onResponse(Call<SuraFull> call, Response<SuraFull> response) {
//                Toast.makeText(SuraFullActivity.this, ""+response.body().getVerse().get("verse_1"), Toast.LENGTH_SHORT).show();
                String verses = "";
                for (int i = 0; i <= response.body().getVerse_count(); i++) {
                    verses += response.body().getVerse().get("verse_" + i) + "*";
                }
                suraFullTV.setText(verses);
            }

            @Override
            public void onFailure(Call<SuraFull> call, Throwable t) {
                Toast.makeText(SuraFullActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}