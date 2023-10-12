package com.ioFundamentales.practica.practica2;

import java.io.Serializable;

public class Articulo implements Serializable {
    private static final long serialVersionUID = 42L; // (1) Número de versión para la serialización.
    private int id; // (2) Identificador del artículo.
    private String descripcion; // (3) Descripción del artículo.
    private double costo; // (4) Costo del artículo.

    public Articulo(int id, String descripcion, double costo) { // (5) Constructor de la clase.
        this.id = id; // (6) Inicialización del identificador.
        this.descripcion = descripcion; // (7) Inicialización de la descripción.
        this.costo = costo; // (8) Inicialización del costo.
    }

    public double getCosto() { // (9) Método para obtener el costo del artículo.
        return costo;
    }

    public void setCosto(double costo) { // (10) Método para establecer el costo del artículo.
        this.costo = costo;
    }

    public String getDescripcion() { // (11) Método para obtener la descripción del artículo.
        return descripcion;
    }

    public void setDescripcion(String descripcion) { // (12) Método para establecer la descripción del artículo.
        this.descripcion = descripcion;
    }

    public int getId() { // (13) Método para obtener el identificador del artículo.
        return id;
    }

    public void setId(int id) { // (14) Método para establecer el identificador del artículo.
        this.id = id;
    }

    @Override
    public String toString() { // (15) Método para convertir el objeto a una representación de cadena.
        return ("ID del Artículo: " + id + " Descripción: " + descripcion + " Costo: " + costo);
    }
}



