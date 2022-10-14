/*package com.example.mygarbage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class AgregarDispositivo extends Fragment {
    private Button btnConfigurar;
    private ArrayList<Dispositivo1> listado;




    public AgregarDispositivo() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView l =(ListView) view.findViewById(R.id.lbDispositivos);
        Adaptador1 adaptador= new Adaptador1(getContext(),cargar_datos());
        l.setAdapter(adaptador);
    }

    public ArrayList<Dispositivo1> cargar_datos(){
        listado =new ArrayList<>();
        listado.add(new Dispositivo1("Habitación 1"));
        listado.add(new Dispositivo1("Habitación 2"));
        return listado;


        /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agregar_dispositivo, container, false);
        ///configuracion boton contraseña
        btnConfigurar = v.findViewById(R.id.btConfigurar);
        btnConfigurar.setOnClickListener(new View.OnClickListener() {////Aquiiiii
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "LLegue", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), ConfiguracionDispositivo.class);
                startActivity(i);
            }
        });///aquiii
        return v;*/


