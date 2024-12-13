
package com.mycompany.konoha.Modelo.Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camper
 */
public class Mision {
    private Integer idMision;
    private String descripcion;
    private Rango rango;
    private String recompensas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Ninja> ninjas = new ArrayList<>();

    public Mision() {
    }

    
    
    public Mision(Integer idMision, String descripcion, Rango rango, String recompensas, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idMision = idMision;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensas = recompensas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Mision(String descripcion, Rango rango, String recompensas, LocalDate fechaInicio) {
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensas = recompensas;
        this.fechaInicio = fechaInicio;
    }

    public Integer getIdMision() {
        return idMision;
    }

    public void setIdMision(Integer idMision) {
        this.idMision = idMision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public String getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(String recompensas) {
        this.recompensas = recompensas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public void addNinja(Ninja ninja) {
        ninjas.add(ninja);
    }

    public void removeNinja(Ninja ninja) {
        ninjas.remove(ninja);
    }
    
    public List<Ninja> getNinjas(){
        return ninjas;
    }
    
    
}
