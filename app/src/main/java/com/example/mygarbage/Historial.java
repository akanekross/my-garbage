package com.example.mygarbage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mygarbage.Modulo.historial1;
import com.example.mygarbage.Modulo.lista;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {
    ListView lvhistorial1;
    ArrayList<historial1> historial1s;
    ArrayAdapter<historial1> adaptadorHistorial;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        lvhistorial1 = (ListView) findViewById(R.id.lvHistorial);
        historial1s = new ArrayList<historial1>();
        cargarBD();
    }

    private void cargarBD() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference Historialref = database.getReference("Calendario");
        ValueEventListener HistorialListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d: snapshot.getChildren()){
                    String titulo = d.child("titulo").getValue().toString();
                    String fecha = d.child("fecha").getValue().toString();
                    String descripcion = d.child("descripcion").getValue().toString();
                    historial1 a = new historial1(titulo,fecha,descripcion);
                    historial1s.add(a);

                }
                adaptadorHistorial = new ArrayAdapter<historial1>(getApplicationContext(), android.R.layout.simple_list_item_1,historial1s);
                lvhistorial1.setAdapter(adaptadorHistorial);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Historialref.addValueEventListener(HistorialListener);

    }
}