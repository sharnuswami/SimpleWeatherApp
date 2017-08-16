package com.example.hp_pc.weathertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static EditText place;
    static EditText temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        place= (EditText) findViewById(R.id.place);
        temp= (EditText) findViewById(R.id.temp);

        Weather getdata=new Weather();
        getdata.execute("http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=3c70f7d8f9e272cd6f73036a65228391");
    }
}
