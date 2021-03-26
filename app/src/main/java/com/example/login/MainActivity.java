package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button Login;
EditText Name;
EditText Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login=(Button) findViewById(R.id.button);
        Name=(EditText) findViewById(R.id.Name);
        Pass=(EditText) findViewById(R.id.Password);
        Login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         if (Name.getText().toString().equals("admin")&&Pass.getText().toString().equals("1234")){
                                                Intent i =new Intent(MainActivity.this,Second.class);
                                                i.putExtra("name",Name.getText().toString());
                                                startActivity(i);
                                         }
                                     }
                                 }
        );
    }
}
