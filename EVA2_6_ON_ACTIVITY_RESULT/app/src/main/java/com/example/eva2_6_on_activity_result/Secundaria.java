package com.example.eva2_6_on_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {

    Button btnEnviar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        //intent = new Intent();
        intent = getIntent();
        Toast.makeText(this,intent.getStringExtra("Datos"), Toast.LENGTH_LONG).show();
    }

    public void onClick(View view){
        intent.putExtra("Valor","Hola Mundo");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void onClickCancel(View view){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}