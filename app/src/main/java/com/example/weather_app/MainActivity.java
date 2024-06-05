package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText searchByCity, searchByCountry;
    TextView tvResult;
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    private final String appid = "79c98147bc61b37a1d05ee66684f84e1";
    DecimalFormat df = new DecimalFormat("#.##"); // show two decimal places any number in java, #.## specifies that we are formatting up to two decimal places it also round the number
    Button btn_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tvResult = findViewById(R.id.tvResult);
        btn_get = findViewById(R.id.btn_Get);

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CityFinder.class);
                startActivity(intent);
            }
        });

//        btn_get.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                String tempUrl = "";
//                String city = searchByCity.getText().toString().trim();
//                String country = searchByCountry.getText().toString().trim();
//
//                if (city.equals("")) {
//                    tvResult.setText("City field can not be empty!");
//                }else{
//                    if (!country.equals("")) {
//                        tempUrl = url + "?q=" + city + "," + country + "&appid=" + appid;
//                    }else{
//                        tempUrl = url + "?q=" + city + "&appid=" + appid;
//                    }
//
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
////                            Log.d("response", response); // print the response in logcat
//
//                            String output = "";
//                            try {
//                                JSONObject jsonResponse = new JSONObject(response);
//                                JSONArray jsonArray = jsonResponse.getJSONArray("weather");
//                                JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
//                                String description = jsonObjectWeather.getString("description");
//                                JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
//                                double temp = jsonObjectMain.getDouble("temp") - 273.15;
//                                double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
//                                float pressure = jsonObjectMain.getInt("pressure");
//                                int humidity = jsonObjectMain.getInt("humidity");
//                                JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
//                                String wind = jsonObjectWind.getString("speed");
//                                JSONObject jsonObjectCloud = jsonResponse.getJSONObject("clouds");
//                                String clouds = jsonObjectCloud.getString("all");
//                                JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
//                                String countryName = jsonObjectSys.getString("country");
//                                String cityName = jsonResponse.getString("name");
//
//
//
//                                output += " Current weather of " + cityName + " (" + countryName + ")"
//                                        + "\n Temp: " + df.format(temp) + " °C"
//                                        + "\n Feels Like: " + df.format(feelsLike) + " °C"
//                                        + "\n Humidity: " + humidity + "%"
//                                        + "\n Description: " + description
//                                        + "\n Wind Speed: " + wind + "m/s (meteres per second)"
//                                        + "\n Cloudiness: " + clouds + "%"
//                                        + "\n Pressure: " + " hPa";
//
//                                tvResult.setText(output);
//
//                            } catch (JSONException e) {
//                                throw new RuntimeException(e);
//                            }
//
//
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//                    requestQueue.add(stringRequest);
//                }
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");

        if(city != null){
            getWeatherForNewCity(city);
        }
    }


    private void getWeatherForNewCity(String city){

            String tempUrl = "";


            if (city.equals("")) {
                tvResult.setText("City field can not be empty!");
            }else{

                tempUrl = url + "?q=" + city + "&appid=" + appid;

                StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                            Log.d("response", response); // print the response in logcat

                        String output = "";
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                            JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                            String description = jsonObjectWeather.getString("description");
                            JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                            double temp = jsonObjectMain.getDouble("temp") - 273.15;
                            double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                            float pressure = jsonObjectMain.getInt("pressure");
                            int humidity = jsonObjectMain.getInt("humidity");
                            JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                            String wind = jsonObjectWind.getString("speed");
                            JSONObject jsonObjectCloud = jsonResponse.getJSONObject("clouds");
                            String clouds = jsonObjectCloud.getString("all");
                            JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                            String countryName = jsonObjectSys.getString("country");
                            String cityName = jsonResponse.getString("name");



                            output += " Current weather of " + cityName + " (" + countryName + ")"
                                    + "\n Temp: " + df.format(temp) + " °C"
                                    + "\n Feels Like: " + df.format(feelsLike) + " °C"
                                    + "\n Humidity: " + humidity + "%"
                                    + "\n Description: " + description
                                    + "\n Wind Speed: " + wind + "m/s (meteres per second)"
                                    + "\n Cloudiness: " + clouds + "%"
                                    + "\n Pressure: " + " hPa";

                            tvResult.setText(output);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        }
    }
