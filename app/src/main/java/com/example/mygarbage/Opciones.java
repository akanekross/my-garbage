package com.example.mygarbage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Opciones#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Opciones extends Fragment {
    private Button btnCambiarContrasenia;//aqui se declaran los botones
    private Button btnNotificacion;
    private Button btnHistorial;
    private Button btnadios;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Opciones() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Opciones.
     */
    // TODO: Rename and change types and number of parameters
    public static Opciones newInstance(String param1, String param2) {
        Opciones fragment = new Opciones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_opciones, container, false);
        ///configuracion boton contraseña
        btnCambiarContrasenia = v.findViewById(R.id.botonModificarContrasenia);
        btnCambiarContrasenia.setOnClickListener(new View.OnClickListener() {////Aquiiiii
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "LLegue", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(),ModificarContrasenia.class);
                startActivity(i);
            }
        });///aquiii
        ///configuracion boton notificacion
         btnNotificacion = v.findViewById(R.id.botonNotifiacion);
         btnNotificacion.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(getContext(),Notificaciones.class);
                 startActivity(i);
             }
         });
         //boton historial
        btnHistorial = v.findViewById(R.id.botonHistorial);
        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Historial.class);
                startActivity(i);
            }
        });//boton cerrar no funka despues preguntar
        btnadios=v.findViewById(R.id.botonAdios);
        btnadios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
                SharedPreferences.Editor editor=datos.edit();
                editor.remove("correo");
                editor.apply();
                getActivity().finish();



            }
        });





        return v;



    }
    public void ContenedorOpciones(View v){
        Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();

    }


}