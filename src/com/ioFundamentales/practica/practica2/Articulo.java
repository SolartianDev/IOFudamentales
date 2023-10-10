package com.ioFundamentales.practica.practica2;
import java.io.Serializable;

public class Articulo implements Serializable {
    private static final long serialVersionUID = 42L;
    private int id;
    private String descripcion;
    private double costo;

    public Articulo(int id, String descripcion, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("ID del Artículo: " + id + " Descripción: " + descripcion + " Costo: " + costo);
    }
}




