package com.example.resepku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import api.ServerAPI;
import model.ModelResep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton btnadd;
    private List<ModelResep> modelReseps;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        btnadd = findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputResep.class);
                startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(this, modelReseps);
        recyclerView.setAdapter(recyclerViewAdapter);
        showData();
    }
    public void showData(){

       ServerAPI.getSelectAPI().callResep().enqueue(new Callback<List<ModelResep>>() {
           @Override
           public void onResponse(Call<List<ModelResep>> call, Response<List<ModelResep>> response) {
               modelReseps.addAll(response.body());
               recyclerViewAdapter.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<List<ModelResep>> call, Throwable t) {
               Toast.makeText(MainActivity.this,t.getMessage().toString()
                       , Toast.LENGTH_LONG).show();

           }
       });

    }
}