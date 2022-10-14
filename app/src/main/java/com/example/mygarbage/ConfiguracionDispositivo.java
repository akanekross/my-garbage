package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ConfiguracionDispositivo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_dispositivo);
    }
    public void Configurar(View v){
        RadioGroup rgTamano=(RadioGroup) findViewById(R.id.rgTamano);

        int id=rgTamano.getCheckedRadioButtonId();
        String Tamano="";
        switch (id){
            case R.id.rgGrande:
                Tamano="Grande";
                Intent i=new Intent(this,AgregarDispositivo11.class);
                startActivity(i);
                break;
            case R.id.rgMediano:
                Tamano="Mediano";
                Intent a=new Intent(this,AgregarDispositivo11.class);
                startActivity(a);
                break;
            case R.id.rgPequeño:
                Tamano="Pequeño";
                Intent b=new Intent(this,AgregarDispositivo11.class);
                startActivity(b);
            default:
                Toast.makeText(this,"Error en la selección de tamaño",Toast.LENGTH_SHORT).show();



        }
        Spinner spNivel = (Spinner) findViewById(R.id.spNivel);
        String nivel =spNivel.getSelectedItem().toString();






    }

}