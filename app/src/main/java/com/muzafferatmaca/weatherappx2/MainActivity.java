package com.muzafferatmaca.weatherappx2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muzafferatmaca.weatherappx2.API.RetrofitClient;
import com.muzafferatmaca.weatherappx2.API.WeatherDao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    EditText editTextCity;
    TextView textView;
    WeatherDao weatherDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherDao = RetrofitClient.getApi().create(WeatherDao.class);


        editTextCity = findViewById(R.id.editTextCity);
        textView = findViewById(R.id.textView);


    }

    public void getWeather(View v) {

        Call<Example> exampleCall = weatherDao.getWeatherCity(editTextCity.getText().toString().trim(),RetrofitClient.KEY);

        exampleCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code() == 404) {

                    Toast.makeText(MainActivity.this, "şehir adı giriniz", Toast.LENGTH_LONG).show();

                } else if (!(response.isSuccessful())) {

                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_LONG).show();

                }

                Example myData = response.body();
                Main main = myData.getMain();

                Double temp = main.getTemp();
                Integer temperature = (int) (temp - 273.15);
                textView.setText(String.valueOf(temperature) + " Derece");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();


            }
        });
    }

}