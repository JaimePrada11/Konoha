
package com.mycompany.konoha.Modelo.Clases;

import java.io.Serializable;


public class Aldea implements Serializable {
    
    private Integer idAldea;
    private String Nombre;

    public Aldea() {
    }

    public Aldea(Integer idAldea, String Nombre) {
        this.idAldea = idAldea;
        this.Nombre = Nombre;
    }

    public Aldea(Integer idAldea) {
        this.idAldea = idAldea;
    }

    public Aldea(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getIdAldea() {
        return idAldea;
    }

    public void setIdAldea(Integer idAldea) {
        this.idAldea = idAldea;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Aldea{" + "idAldea=" + idAldea + ", Nombre=" + Nombre + '}';
    }
    
    
    
}
