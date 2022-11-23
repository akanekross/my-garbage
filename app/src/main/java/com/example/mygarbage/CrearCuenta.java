package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CrearCuenta extends AppCompatActivity {
    Button btnCrear1;
    EditText etUsuario,etApellido,etCorreo,etContra1,etContra2;
    Spinner spCiudad;
    DatabaseReference database; //esto es del tutorial
    //DatabaseReference database; //esta es la bd



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        btnCrear1= findViewById(R.id.btnCrear);
        database = FirebaseDatabase.getInstance().getReference();
        etUsuario = findViewById(R.id.etUsuario);
        etApellido = findViewById(R.id.etApellido);
        etCorreo = findViewById(R.id.etCorreo);
        etContra1 = findViewById(R.id.etContra1);
        etContra2 =findViewById(R.id.etContra2);

        //este es el boton
        btnCrear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre =etUsuario.getText().toString();
                String apellido=etApellido.getText().toString();
                String correo=etCorreo.getText().toString();
                String contra1=etContra1.getText().toString();
                String contra2=etContra2.getText().toString();

                CargarDatos(nombre, apellido, correo, contra1, contra2);
            }
        });


    }

    private void CargarDatos(String nombre, String apellido, String correo, String contra1, String contra2) {
        Map <String ,Object> datosUsuario = new HashMap<>();
        datosUsuario.put("nombre", nombre);
        datosUsuario.put("apellido", apellido);
        datosUsuario.put("correo", correo);
        datosUsuario.put("contra1", contra1);
        datosUsuario.put("contra2", contra2);
        // de esta forma igual funciona y el identificador unico es el nombre
        //database.child("Usuarios").child(nombre).child("nombre").setValue(nombre);
        //database.child("Usuarios").child(nombre).child("apellido").setValue(apellido);
        //database.child("Usuarios").child(nombre).child("correo").setValue(correo);
        //database.child("Usuarios").child(nombre).child("contra1").setValue(contra1);
        //database.child("Usuarios").child(nombre).child("contra2").setValue(contra2);

        database.child("Usuarios").push().setValue(datosUsuario);
        // igual funciona pero entrega un identificador unico automatico
    }
    //desde aqui debes volver a pegar el codigo que ya estaba



//antes de este codigo debe quedar el ulimo corchete al pegar lo otro
}