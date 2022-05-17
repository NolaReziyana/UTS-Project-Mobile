package com.example.resepku;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import api.InsertAPI;
import model.ModelResep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InputResep extends AppCompatActivity {

    EditText resepbaru, ket;
    ImageView imageView;
    Button btnsimpan, opencamera;
    private String baseURL="https://procurable-masses.000webhostapp.com/";
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_resep);

        resepbaru = findViewById(R.id.namaresep);
        ket = findViewById(R.id.keterangan);
        imageView = findViewById(R.id.ambilgambar);
        opencamera = findViewById(R.id.opencamera);
        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera,100);
            }
        });

        btnsimpan = findViewById(R.id.btnSimpan);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputResepBaru();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(photo);
    }

    private void inputResepBaru(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InsertAPI insertAPI = retrofit.create(InsertAPI.class);
        Call<ModelResep> call = insertAPI.inputResep(resepbaru.getText().toString(), ket.getText().toString());
                call.enqueue(new Callback<ModelResep>() {
                    @Override
                    public void onResponse(Call<ModelResep> call, Response<ModelResep> response) {
                        resepbaru.setText("");
                        ket.setText("");
                        Toast.makeText(getApplicationContext(), response.toString()
                                , Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ModelResep> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString()
                                , Toast.LENGTH_SHORT).show();

                    }
                });
    }

}