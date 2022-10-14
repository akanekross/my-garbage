package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void login(View v){
        EditText campo1 = this.findViewById(R.id.idCorreo);
        String idCorreo = campo1.getText().toString();

        EditText campo2 = this.findViewById(R.id.idContra);
        String idContra = campo2.getText().toString();

        if (idCorreo.equals("eli")&& idContra.equals("123")) {
            CheckBox cbRecuerdame = (CheckBox) findViewById(R.id.cbRecuerdame);
            boolean chequeado = cbRecuerdame.isChecked();
            if (chequeado == true){
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor=datos.edit();
                editor.putString("correo",idCorreo);
                editor.apply();
            }


            Intent i = new Intent(this,principal.class);
            startActivity(i);



        }else {
            Toast.makeText(this, "Error de cotraseña o de usuario", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        String correo = datos.getString("correo","");
        if (!correo.equals("")){

            Intent i = new Intent(this,principal.class);
            startActivity(i);

        }

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