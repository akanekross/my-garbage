package com.example.mygarbage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText etContra,etUsuario1;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //etCorreo = (EditText) findViewById(R.id.idCorreo);
        etUsuario1 = (EditText) findViewById(R.id.etUsuario1);
        etContra = (EditText) findViewById(R.id.idContra);


        btnIngresar = (Button) findViewById(R.id.btIngresar);

        // desde aqui se pega el codigo
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Usuario = etUsuario1.getText().toString();
                //String correo = etCorreo.getText().toString();
                String contra = etContra.getText().toString();
                if(Usuario.isEmpty() || contra.isEmpty()){
                    Toast.makeText(MainActivity.this, "Ingresa tu correo o contraseña", Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseReference ref = database.getReference("Usuarios");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot usuario:
                                 snapshot.getChildren()) {
                                String u = usuario.child("nombre").getValue().toString();
                                String c = usuario.child("contra1").getValue().toString();
                                if (Usuario.equals(u) && contra.equals(c)){
                                    Toast.makeText(MainActivity.this, "inicio exitoso", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(),principal.class);
                                    startActivity(i);

                                }else {
                                    //Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
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


///// hasta antes de este corchete debes pegar el otro codigo si no funciona el del tutorial
    }

    public void crearCuenta(View v){
        Intent i = new Intent(this,CrearCuenta.class);
        startActivity(i);

    }
    public void olvideContra(View v){
        Intent i= new Intent(this,ContraseniaOlvidada.class);
        startActivity(i);
    }
    }