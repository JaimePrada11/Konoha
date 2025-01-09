package com.mycompany.konoha.Modelo.Clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mision implements Serializable{

    private Integer idMision;
    private String descripcion;
    private Rango rango;
    private String recompensas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Ninja> ninjas;
    private boolean estado;

    public Mision() {
        this.ninjas = new ArrayList<>();

    }

    public Mision(Integer idMision, String descripcion, Rango rango, String recompensas, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idMision = idMision;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensas = recompensas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ninjas = new ArrayList<>();
    }

    public Mision(String descripcion, Rango rango, String recompensas, LocalDate fechaInicio) {
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensas = recompensas;
        this.fechaInicio = fechaInicio;
        this.ninjas = new ArrayList<>();

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
        if (this.fechaFin != null && fechaInicio != null && fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        if (this.fechaInicio != null && fechaFin != null && fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
        this.fechaFin = fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void addNinja(Ninja ninja) {
        ninjas.add(ninja);
    }

    public void removeNinja(Ninja ninja) {
        ninjas.remove(ninja);
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    @Override
    public String toString() {
        return "Mision{" + "idMision=" + idMision + ", descripcion=" + descripcion + ", rango=" + rango + ", recompensas=" + recompensas + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", ninjas=" + ninjas + ", estado=" + estado + '}';
    }

}
