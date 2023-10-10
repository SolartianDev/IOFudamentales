
package com.ioFundamentales.practica.practica2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarritoDeCompras implements Serializable {

    private static final long serialVersionUID = 23L;
    private int idCarrito;
    private ArrayList<Articulo> articulos;
    private transient int cantidadArticulos;
    private transient double totalCarrito;

    public CarritoDeCompras(int idCliente) {
        this.idCarrito = idCliente;
        articulos = new ArrayList<>();
        cantidadArticulos = 0;
        totalCarrito = 0;
    }

    public double getTotalCarrito() {
        return totalCarrito;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void agregarArticulo(Articulo articulo) {
        if (articulos.add(articulo)) {
            totalCarrito += articulo.getCosto();
        }
    }

    public int getCantidadArticulos() {
        return articulos.size();
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    // Este método se llama solo durante la deserialización
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // Recalcular el total si el carrito fue deserializado
        
                
        if(cantidadArticulos == 0 && (articulos.size() > 0)){
           getCantidadArticulos();
        }
        if (totalCarrito == 0 && (articulos.size() > 0)) {
            for (Articulo articulo : articulos) 
                totalCarrito += articulo.getCosto();
        }
        Date fecha = (Date) ois.readObject();
        System.out.println("Carrito de Compras restaurado desde: " + DateFormat.getDateInstance().format(fecha));
    }

    // Este método se llama solo durante la serialización
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Date());
    }
}
