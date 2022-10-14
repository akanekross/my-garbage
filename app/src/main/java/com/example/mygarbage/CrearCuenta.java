package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);


    }
    public void Registrar(View v){
        //recuperar view
        EditText etUsuario=(EditText) findViewById(R.id.etUsuario);
        //recuperar el valor del view
        String usuario=etUsuario.getText().toString();
        //
        EditText etApellido=(EditText) findViewById(R.id.etApellido);
        String apellido=etApellido.getText().toString();
        //
        EditText etCorreo=(EditText) findViewById(R.id.etCorreo);
        String correo=etCorreo.getText().toString();
        //


        //recuperar el radio button
        RadioGroup rbGenero=(RadioGroup) findViewById(R.id.rbGenero);
        int id=rbGenero.getCheckedRadioButtonId();
        String genero="";
        switch (id){
            case R.id.rbMasculino:
                genero="Masculino";
                break;
            case R.id.rbFemenino:
                genero="Femenino";
                break;
            default:
                Toast.makeText(this,"Error en la sección genero",Toast.LENGTH_SHORT).show();
        }
        Spinner spCiudad = (Spinner) findViewById(R.id.spCiudad);
        String ciudad =spCiudad.getSelectedItem().toString();

        EditText etContra1=(EditText) findViewById(R.id.etContra1);
        String contra1=etContra1.getText().toString();
        //
        EditText etContra2=(EditText) findViewById(R.id.etContra2);
        String contra2=etContra2.getText().toString();

        if(contra1.equals(contra2)){
            Toast.makeText(this, "Registro con exito!", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Error en las contraseñas", Toast.LENGTH_SHORT).show();
        }
    }
}