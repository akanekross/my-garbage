package com.example.mygarbage.Modulo;

import androidx.annotation.NonNull;

public class lista {
    public String nivel;
    public String nombredispositivo;
    public String Key;
    public lista(){

    }

    public lista(String nivel, String nombredispositivo,String Key) {
        this.nivel = nivel;
        this.nombredispositivo = nombredispositivo;
        this.Key = Key;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNombredispositivo() {
        return nombredispositivo;
    }

    public void setNombredispositivo(String nombredispositivo) {
        this.nombredispositivo = nombredispositivo;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    @Override
    public String toString() {
        return "{"+
                "Nivel: "+ nivel+'\''+
                "Nombre: "+nombredispositivo+'\''+
                "key: "+Key+'\''+
                '}';

    }
}
