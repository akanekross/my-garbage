package com.example.mygarbage.Modulo;

public class Usuario1 {
    public String key;
    public String Nombre;
    public String Apellido;
    public String Correo;
    public String Contra1;
    public String Contra2;
    public String spCiudad1;

    public Usuario1(String Key, String Nombre, String Apellido, String Correo, String Contra1, String Contra2,String spCiudad1) {
        this.key = Key;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Contra1 = Contra1;
        this.Contra2 = Contra2;
        this.spCiudad1= spCiudad1;


    }

    @Override
    public String toString(){
        return "Nombre: "+this.Nombre+
                "Apellido: "+this.Apellido+"Correo: "+this.Correo+"Contra1"+this.Contra1+"Contra2"+this.Contra2;
    }

}
