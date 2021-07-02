package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;
    TextView txtVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();
        String sNom = intent.getStringExtra("Nombre");
        Double dSal = intent.getDoubleExtra("Salario",0.0);
        int iEstado = intent.getIntExtra("Estado_Civil",0);
        TextView txtVw;
        txtVw = findViewById(R.id.txtVw);
        txtVw.append("Nombre: \n");
        txtVw.append(sNom + "\n");
        txtVw.append("Salario: \n");
        txtVw.append(dSal + "\n");

        //RadioButton rdTemp = findViewById(iEstado);
        txtVw.append("Estado Civil: \n");
        //txtVw.append(rdTemp.getText() + "\n");
        txtVw.append(iEstado + "\n");
    }
    public void onClickSal(View view){
        
        finish();
    }
}