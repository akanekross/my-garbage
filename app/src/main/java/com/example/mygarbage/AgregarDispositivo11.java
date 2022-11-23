package com.example.mygarbage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.mygarbage.Modulo.lista;
import com.example.mygarbage.Modulo.lista;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarDispositivo11#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarDispositivo11 extends Fragment {
    private Button btnAgregar;
    private Button btnAgregarFragment;
    EditText etNomDispo;
    Spinner spNivel1;
    RadioGroup rgTamano1;
    ListView listView1;
    ArrayList<lista> lista;
    ArrayAdapter<lista> adaptadorLista;
    FirebaseDatabase database;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object CrearDispositivo;


    public AgregarDispositivo11() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarDispositivo11.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarDispositivo11 newInstance(String param1, String param2) {
        AgregarDispositivo11 fragment = new AgregarDispositivo11();
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
        View v = inflater.inflate(R.layout.fragment_agregar_dispositivo11, container, false);
        etNomDispo = v.findViewById(R.id.etNomDispositivo);
        spNivel1 = v.findViewById(R.id.spNivel);
        rgTamano1 = v.findViewById(R.id.rgTamano);
        ////////////
        listView1 = (ListView) v.findViewById(R.id.listView1);
        lista = new ArrayList<lista>();
        cargarBD();




        ///configuracion boton
        btnAgregar = v.findViewById(R.id.btAgregar1);
        btnAgregar.setOnClickListener(new View.OnClickListener() {////Aquiiiii
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ConfiguracionDispositivo.class);
                startActivity(i);
            }
        });///aquiii



        return v;
    }

    private void cargarBD() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference conRef = database.getReference("ConfiguracionDispositivos");
        ValueEventListener disListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lista = new ArrayList<lista>();
                for (DataSnapshot d: snapshot.getChildren()){

                    String nivel = d.child("nivel").getValue().toString();
                    String nombreDispositivo = d.child("nombredispositivo").getValue().toString();
                    String Key = d.child("Key").getValue().toString();
                    //int Tamano = Integer.parseInt(d.child("Tamano").getValue().toString());
                    lista a = new lista(nivel,nombreDispositivo,Key);
                    lista.add(a);
                }
                adaptadorLista = new ArrayAdapter<lista>(getContext(), android.R.layout.simple_list_item_1,lista);
                listView1.setAdapter(adaptadorLista);
                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                        lista a= (lista) adapterView.getItemAtPosition(i);
                        Intent intencion = new Intent(getContext(),modificarEliminar.class);
                        Gson gson = new Gson();
                        String lista =gson.toJson(a);
                        intencion.putExtra("lista",lista);
                        startActivity(intencion);




                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        conRef.addValueEventListener(disListener);




    }
}