package com.mycompany.konoha.Modelo.Clases;

import java.io.Serializable;

public class Rango implements Serializable{

    private Integer idRango;
    private String nombre;
    private Tipo tipo;

    public enum Tipo {
        NINJA, MISION
    }

    public Rango() {
    }

    public Rango(Integer idRango) {
        this.idRango = idRango;
    }

    public Rango(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;

    }
    
    public Rango(String nombre) {
        this.nombre = nombre;
    }

    public Rango(Integer idRango, String nombre, Tipo tipo) {
        this.idRango = idRango;
        this.nombre = nombre;
        this.tipo = tipo;

    }

    public Integer getIdRango() {
        return idRango;
    }

    public void setIdRango(Integer idRango) {
        this.idRango = idRango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Rango{" + "idRango=" + idRango + ", nombre=" + nombre + ", tipo=" + tipo + '}';
    }

}
