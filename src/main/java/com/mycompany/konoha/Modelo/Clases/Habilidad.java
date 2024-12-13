
package com.mycompany.konoha.Modelo.Clases;


public class Habilidad {
    
    private Integer idHabilidad;
    private String Nombre;
    
    public Habilidad() {
    }
    
    public Habilidad(Integer idHabilidad, String Nombre) {
        this.idHabilidad = idHabilidad;
        this.Nombre = Nombre;
    }

    public Habilidad(String Nombre) {
        this.Nombre = Nombre;
    }


    public Habilidad(Integer idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    
    public Integer getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Integer idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Habilidad{" + "idHabilidad=" + idHabilidad + ", Nombre=" + Nombre + '}';
    }
    
    
    
}
