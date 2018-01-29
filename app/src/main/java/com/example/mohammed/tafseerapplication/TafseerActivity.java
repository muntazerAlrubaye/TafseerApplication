package com.example.mohammed.tafseerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import adapter.SuraAdapter;
import adapter.TafseerAdapter;
import models.Sura;
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

        final RecyclerView recyclerView = findViewById(R.id.recycler_view_tafseer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Tafseer>> call = apiServices.getTafseerName();
        call.enqueue(new Callback<List<Tafseer>>() {
            @Override
            public void onResponse(Call<List<Tafseer>> call, Response<List<Tafseer>> response) {

                Toast.makeText(TafseerActivity.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Tafseer> tafseers = response.body();
                recyclerView.setAdapter(new TafseerAdapter(tafseers, R.layout.tafseer_row_item,getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Tafseer>> call, Throwable t) {
                Log.e("+++++++",t.getMessage()) ;
                Toast.makeText(TafseerActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();

            }

        });

    }
}
