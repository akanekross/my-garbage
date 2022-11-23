package com.example.mygarbage;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Calendario extends Fragment {
    private EditText ptTitulo,ptDescripcion;
    private Button btCalendario,btGuardar;
    private TextView tvFecha;
    int Dia,Mes,Anio;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InicializarVariables();
    }

   public void InicializarVariables() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);

        tvFecha=(TextView) v.findViewById(R.id.tvFecha);
        //agregue esto///////
        ptTitulo=(EditText) v.findViewById(R.id.ptTitulo);
        ptDescripcion= (EditText) v.findViewById(R.id.ptDescripcion);
        btGuardar = (Button) v.findViewById(R.id.btnGuardar);
        //////////////////
        btCalendario = (Button) v.findViewById(R.id.btCalendario);
        btCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///agregue esto//

                /////////////////////


                //DatePickerDialog d = new DatePickerDialog(getContext());
                //d.show();
                final Calendar calendario=Calendar.getInstance();
                Dia = calendario.get(Calendar.DAY_OF_MONTH);
                Mes = calendario.get(Calendar.MONTH);
                Anio = calendario.get(Calendar.YEAR);
                //Mes = Calendario.get(Calendar.MONTH);
                //Anio= Calendario.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog( getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int AnioSeleccionado, int MesSeleccionado, int DiaSeleccionado) {
                        String DiaFormateado,MesFormateado;
                        //Obtener día
                        if (DiaSeleccionado<10){

                            DiaFormateado="0"+String.valueOf(DiaSeleccionado);

                        }else {
                            DiaFormateado=String.valueOf(DiaSeleccionado);
                        }
                        //Obtener el mes
                        int mes1 = MesSeleccionado+1;
                        if (mes1 <10){
                            MesFormateado="0"+String.valueOf(mes1);

                        }else {
                            MesFormateado=String.valueOf(mes1);//el value of es para pasar una cadena a un entero
                        }
                        //setear fecha en textvew
                        tvFecha.setText(DiaFormateado+"/"+MesFormateado+"/"+AnioSeleccionado);
                    }
                }
                        ,Anio,Mes,Dia);
                datePickerDialog.show();
            }


        });
        // Inflate the layout for this fragment
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = ptTitulo.getText().toString().trim();
                String descripcion=ptDescripcion.getText().toString().trim();
                String fecha = tvFecha.getText().toString().trim();

                cargarDatoCalendario(titulo,descripcion,fecha);

            }
        });

        return v;
    }
 /// y agregue esto///
    private void cargarDatoCalendario(String titulo, String descripcion, String fecha) {
        Map<String ,Object> datosCalendario = new HashMap<>();
        datosCalendario.put("titulo", titulo);
        datosCalendario.put("descripcion",descripcion);
        datosCalendario.put("fecha",fecha);

        database.getReference("Calendario").push().setValue(datosCalendario);


    }
}