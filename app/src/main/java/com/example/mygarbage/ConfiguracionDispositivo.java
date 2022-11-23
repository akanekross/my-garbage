package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mygarbage.Modulo.lista;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConfiguracionDispositivo extends AppCompatActivity {
    EditText etNomDispo;
    Spinner spNivel1;
    RadioGroup rgTamano1;
    Button btGuarDis;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_dispositivo);
        etNomDispo = findViewById(R.id.etNomDispositivo);
        spNivel1 = findViewById(R.id.spNivel);
        rgTamano1 = findViewById(R.id.rgTamano);
        btGuarDis = findViewById(R.id.btGuardarD);

    }
    public void Configurar(View v){
        RadioGroup rgTamano=(RadioGroup) findViewById(R.id.rgTamano);
        int id=rgTamano.getCheckedRadioButtonId();
        String Tamano="";
        switch (id){
            case R.id.rgGrande:
                Tamano="Grande";

                break;
            case R.id.rgMediano:
                Tamano="Mediano";

                break;
            case R.id.rgPequeño:
                Tamano="Pequeño";
            default:
                Toast.makeText(this,"Error en la selección de tamaño",Toast.LENGTH_SHORT).show();

        }
        Spinner spNivel = (Spinner) findViewById(R.id.spNivel);
        String nivel =spNivel.getSelectedItem().toString();

        btGuarDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreDispositivo=etNomDispo.getText().toString();
                String nivel = spNivel1.getSelectedItem().toString();
                String Key = UUID.randomUUID().toString();
                //int Tamano= rgTamano.getCheckedRadioButtonId();
                lista a = new lista(nivel,nombreDispositivo,Key);
                database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("ConfiguracionDispositivos");
                myRef.child(Key).setValue(a);
                finish();
                //                //int tamano = rgTamano1.getCheckedRadioButtonId().toString();

                //ConfDispositivo(nombreDispositivo,nivel);



            }
        });
    }

    /*private void ConfDispositivo(String nombreDispositivo, String nivel) {
        Map<String ,Object> ConfiguracionDispositivo = new HashMap<>();
        //ConfiguracionDispositivo.put("Key", Key);
        ConfiguracionDispositivo.put("nombreDispositivo", nombreDispositivo);
        ConfiguracionDispositivo.put("nivel", nivel);
        System.out.println("VALOR "+ConfiguracionDispositivo);
        database.getReference("ConfiguracionDispositivos").push().setValue(ConfiguracionDispositivo);

    }*/ //esto funciona no lo elimines

}