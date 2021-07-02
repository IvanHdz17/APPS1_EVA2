package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtxtNom, edtxtSal;
    RadioGroup rGroup1;
    Button btnEnv;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,MainActivity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtxtNom = findViewById(R.id.edtxtNom);
        edtxtSal = findViewById(R.id.edtxtSal);
        rGroup1 = findViewById(R.id.rGroup1);
    }

    public void onClick(View view){
        intent.putExtra("Nombre", edtxtNom.getText().toString());
        Double dSalario = 0.0;
        dSalario = Double.parseDouble(edtxtSal.getText().toString());
        intent.putExtra("Salario", dSalario);
        intent.putExtra("Estado_Civil", rGroup1.getCheckedRadioButtonId());
        startActivity(intent);
    }
}