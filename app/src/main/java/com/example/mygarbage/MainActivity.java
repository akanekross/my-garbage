package com.example.mygarbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
            Intent i = new Intent(this,principal.class);
            startActivity(i);

        }else {
            Toast.makeText(this, "Error de cotraseña o de usuario", Toast.LENGTH_SHORT).show();
        }

    }
}