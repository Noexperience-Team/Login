package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Temperature extends AppCompatActivity {
TextView val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        val=(TextView)findViewById(R.id.value);
        Intent intent=getIntent();
        float temp=intent.getFloatExtra("temp",0);
        boolean c=intent.getBooleanExtra("c",false);
        if (c){
            val.setText(String.valueOf((temp-32)*5/9)+"C");
        }else {
            val.setText(String.valueOf((temp*9/5)+32)+" F");
        }

    }
}