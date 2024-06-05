package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CityFinder extends AppCompatActivity {

    EditText txtCityFinder;
    Button btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);

        txtCityFinder = findViewById(R.id.txt_cityFinder);
        btnGo = findViewById(R.id.btn_Go);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cityFinder = txtCityFinder.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("city", cityFinder);
                startActivity(intent);

            }
        });
    }
}