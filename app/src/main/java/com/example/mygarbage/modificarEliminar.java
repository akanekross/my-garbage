package com.example.mygarbage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mygarbage.Modulo.lista;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import java.util.List;
import java.util.UUID;

public class modificarEliminar extends AppCompatActivity {
     lista a;
     EditText nombreDis,etKey1;
     Spinner sNivel;
     Button btnModificar1,btnEliminar1;
     //DatabaseReference database;

     FirebaseDatabase database ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_eliminar);

        etKey1=findViewById(R.id.etKey);
        nombreDis=findViewById(R.id.etNomDispositivo2);
        btnEliminar1=(Button) findViewById(R.id.btnEliminar);
        btnModificar1=(Button) findViewById(R.id.btnModificar1) ;
        database = FirebaseDatabase.getInstance();
        obtenerlista();
        cargarlista();
        btnEliminar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("ConfiguracionDispositivos");
                ref.child(a.getKey()).removeValue();
                Toast.makeText(modificarEliminar.this, "si funciona", Toast.LENGTH_SHORT).show();

            }
        });
        btnModificar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("ConfiguracionDispositivos");
                a.setNombredispositivo(nombreDis.getText().toString().trim());
                ref.child(a.getKey()).setValue(a);


                Toast.makeText(modificarEliminar.this, "si funciona", Toast.LENGTH_SHORT).show();

            }
        });
    }


    // //database.getReference("ConfiguracionDispositivos").child("nombreDispositivo").removeValue();
    private void obtenerlista() {
       Bundle b =this.getIntent().getExtras();
        String listaString = b.getString("lista");
        Gson gson =new Gson();
        System.out.println("LISTA "+listaString);
        this.a=(lista) gson.fromJson(listaString,lista.class);
        System.out.println((this.a.Key));


    }

    private void cargarlista(){

        database = FirebaseDatabase.getInstance();
        etKey1=(EditText)findViewById(R.id.etKey);
        nombreDis=(EditText)findViewById(R.id.etNomDispositivo2);
        sNivel=(Spinner) findViewById(R.id.spNivel2);
        btnModificar1=(Button) findViewById(R.id.btnModificar1);
        btnEliminar1=(Button) findViewById(R.id.btnEliminar);
        nombreDis.setText(a.nombredispositivo);
        etKey1.setText(a.Key);




    }

}