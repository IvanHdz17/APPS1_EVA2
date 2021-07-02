package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int Codigo_Secun = 1000;
    final static int Codigo_Contactos = 2000;
    final static int Codigo_Fotos = 3000;

    Button btn1;
    Intent intent, intentCont, intentFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,Secundaria.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentFotos = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Datos","Informacion enviada desde principal");
                startActivityForResult(intent,Codigo_Secun);
            }
        });
    }

    public void onClickCont(View view){
        startActivityForResult(intentCont,Codigo_Contactos);
    }

    public void onClickFotos(View view){
        startActivityForResult(intentFotos, Codigo_Fotos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(Codigo_Secun, resultCode, data);
        //Aqui procesamos la respuesta de la Actividad
        //1. IDENTIFICAR QUE ACTIVIDAD DEVOLVIO EL RESULTADO
        //2. IDENTICAR SI SE DEVOLVIO UN VALOR O NO
        //3. LEER LOS DATOS (INTENT)
        switch(requestCode){
            case Codigo_Secun:
                if(resultCode == Activity.RESULT_OK){//Si me devolvio un valor
                    //Leer los datos
                    Toast.makeText(this, data.getStringExtra("Valor"), Toast.LENGTH_LONG).show();
                }
                break;

                case Codigo_Contactos: //Un case para cada actividad que devuelve un valor
                   if(resultCode == Activity.RESULT_OK){
                       String returnedData = data.getDataString();
                       Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();
                   }
                    break;

                case Codigo_Fotos: //Un case para cada actividad que devuelve un valor
                   if(resultCode == Activity.RESULT_OK){
                       String returnedData = data.getDataString();
                       Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();
                }
                break;

            default:
        }

    }
}