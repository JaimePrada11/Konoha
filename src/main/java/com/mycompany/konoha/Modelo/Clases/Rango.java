
package com.mycompany.konoha.Modelo.Clases;


public class Rango {
    
    private Integer idRango;
    private String nombre;
    private String tipo;

    public Rango() {
    }

    public Rango(Integer idRango) {
        this.idRango = idRango;
    }

    public Rango(String nombre) {
        this.nombre = nombre;
    }

        
    public Rango(Integer idRango, String nombre) {
        this.idRango = idRango;
        this.nombre = nombre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    @Override
    public String toString() {
        return "Rango{" + "idRango=" + idRango + ", nombre=" + nombre + '}';
    }
    
    
}
