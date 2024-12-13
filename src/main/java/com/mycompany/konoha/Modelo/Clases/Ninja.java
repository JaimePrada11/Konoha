package com.mycompany.konoha.Modelo.Clases;

import java.util.ArrayList;
import java.util.List;

public class Ninja {

    private Integer idNinja;
    private String nombre;
    private String idIdentificacion;
    private Aldea aldea;
    private Rango rango;
    private List<Habilidad> habilidades= new ArrayList<>();

    public Ninja() {
    }

    public Ninja(Integer idNinja, String nombre, String idIdentificacion, Aldea aldea, Rango rango) {
        this.idNinja = idNinja;
        this.nombre = nombre;
        this.idIdentificacion = idIdentificacion;
        this.aldea = aldea;
        this.rango = rango;
    }

    public Ninja(String nombre, String idIdentificacion, Aldea aldea, Rango rango) {
        this.nombre = nombre;
        this.idIdentificacion = idIdentificacion;
        this.aldea = aldea;
        this.rango = rango;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(String idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    
    

    public Integer getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(Integer idNinja) {
        this.idNinja = idNinja;
    }

    public Aldea getAldea() {
        return aldea;
    }

    public void setAldea(Aldea aldea) {
        this.aldea = aldea;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public void addHabilidad(Habilidad habilidad) {
        habilidades.add(habilidad);
    }

    public void removeHabilidad(Habilidad habilidad) {
        habilidades.remove(habilidad);
    }
    
    public List<Habilidad> getHabilidades(){
        return habilidades;
    }

    @Override
    public String toString() {
        return "Ninja{" + "idNinja=" + idNinja + ", aldea=" + aldea + ", rango=" + rango + ", habilidades=" + habilidades + '}';
    }
    
    

}
