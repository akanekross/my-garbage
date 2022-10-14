package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Calendario c = new Calendario();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,c).commit();
        TabLayout tl = (TabLayout) findViewById(R.id.tablayout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override //codificar cosas a ejecutar cuando le das tab  a un tab
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0://calendario
                        Calendario c = new Calendario();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,c).commit();
                        //Toast.makeText(getApplicationContext(), "Calendario", Toast.LENGTH_SHORT).show();
                        break;
                    case 1://basura
                        Basura b = new Basura();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,b).commit();
                        //Toast.makeText(getApplicationContext(), "Basura", Toast.LENGTH_SHORT).show();
                        break;
                    case 2://agregar dispositivos
                        AgregarDispositivo11 ad = new AgregarDispositivo11();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,ad).commit();
                        //Toast.makeText(getApplicationContext(), "Dispositivos", Toast.LENGTH_SHORT).show();
                        break;
                    case 3://opciones
                        Opciones o = new Opciones();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,o).commit();
                        //Toast.makeText(getApplicationContext(), "opciones", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override//codificar cosas a ejecutar cuando un tab deja de estar seleccionado
            //un fragmento es una pequeña parte de un activity
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override// codificar cosas a ejecutar cuando un tab se vuelve a seleccionar
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}