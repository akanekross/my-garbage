package com.example.mygarbage.Modulo;

import androidx.annotation.NonNull;

public class historial1 {
    public String titulo;
    public String fecha;
    public String descripcion;

    public historial1(String titulo, String fecha, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "{"+
                "titulo: "+titulo+'\''+
                "fecha: "+fecha+'\''+
                "Descripción: "+descripcion+'\''+
                '}';
    }
}
