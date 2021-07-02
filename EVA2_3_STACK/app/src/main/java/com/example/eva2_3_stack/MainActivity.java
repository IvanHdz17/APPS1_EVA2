package com.example.eva2_3_stack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent; //1.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,MainActivity2.class); //2.
    }

    public void onClickMain1(View view){
        startActivity(intent); //3. Esta estructura sirve para CREAR nuevas actividades
    }
}