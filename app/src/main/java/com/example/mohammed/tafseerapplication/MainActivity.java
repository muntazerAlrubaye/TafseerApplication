package com.example.mohammed.tafseerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import adapter.SuraAdapter;
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

        textView = findViewById(R.id.sura_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SuraFullActivity.class));
//                finish();
            }
        });

        final RecyclerView recyclerView = findViewById(R.id.recycler_veiw_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Sura>> call = apiService.getSoura();
        call.enqueue(new Callback<List<Sura>>() {
            @Override
            public void onResponse(Call<List<Sura>> call, Response<List<Sura>> response) {
                Toast.makeText(MainActivity.this, ""+response.body().size(), Toast.LENGTH_SHORT).show();
                List<Sura> suras = response.body();
                recyclerView.setAdapter(new SuraAdapter(suras, R.layout.recycler_row_main, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Sura>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
