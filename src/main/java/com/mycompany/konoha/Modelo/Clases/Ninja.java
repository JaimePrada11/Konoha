package com.mycompany.konoha.Modelo.Clases;

import java.util.List;

public class Ninja {

    private Integer idNinja;
    private Aldea aldea;
    private Rango rango;
    private List<Habilidad> habilidades;

    public Ninja() {
    }

    public Ninja(Integer idNinja, Aldea aldea, Rango rango) {
        this.idNinja = idNinja;
        this.aldea = aldea;
        this.rango = rango;
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
