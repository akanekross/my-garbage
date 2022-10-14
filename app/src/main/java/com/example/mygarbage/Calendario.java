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
import android.widget.Toast;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calendario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calendario extends Fragment {
    private EditText ptTitulo,ptDescripcion;
    private Button btCalendario;
    private TextView tvFecha;
    int Dia,Mes,Anio;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calendario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calendario.
     */
    // TODO: Rename and change types and number of parameters
    public static Calendario newInstance(String param1, String param2) {
        Calendario fragment = new Calendario();
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
        InicializarVariables();
    }

   public void InicializarVariables() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);
        tvFecha=(TextView) v.findViewById(R.id.tvFecha);
        btCalendario = (Button) v.findViewById(R.id.btCalendario);
        btCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        return v;
    }
}