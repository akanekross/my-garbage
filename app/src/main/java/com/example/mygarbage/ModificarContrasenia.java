package com.example.mygarbage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;


public class ModificarContrasenia extends AppCompatActivity {
    EditText contraActual11,contraNueva11,contraNueva22;
    Button btnModificar;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_contrasenia);
        contraActual11 = findViewById(R.id.etContraActual);
        contraNueva11 = findViewById(R.id.etContraNueva1);
        contraNueva22 = findViewById(R.id.etContraNueva2);
        btnModificar = findViewById(R.id.btnModificar);
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ContraseñaActual = contraActual11.getText().toString();
                String ContraseñaNueva= contraNueva11.getText().toString();
                String ContraseñaNueva2 = contraNueva22.getText().toString();
                if (ContraseñaActual.isEmpty()&& ContraseñaNueva.isEmpty()&&ContraseñaNueva2.isEmpty()){
                    Toast.makeText(ModificarContrasenia.this, "Llena los campos", Toast.LENGTH_SHORT).show();


                }else{
                    DatabaseReference ref = database.getReference("Usuarios");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot usuario:
                                    snapshot.getChildren()) {
                                String ca = usuario.child("contra1").getValue().toString(); //ca contraseña actual
                                //String cn = contraNueva11.getText().toString();
                                if (ContraseñaActual.equals(ca)){
                                    Toast.makeText(ModificarContrasenia.this, "se cambio contraseña", Toast.LENGTH_SHORT).show();


                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


            }
        });



    }
}