
package com.ioFundamentales.practica.practica2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainCarritoDeCompras {

    public static void main(String[] args) {
        // Crear un carrito de compras
        CarritoDeCompras carrito = new CarritoDeCompras(1);

        // Agregar artículos al carrito
        Articulo articulo1 = new Articulo(1, "Producto 1", 25.99);
        Articulo articulo2 = new Articulo(2, "Producto 2", 14.50);

        carrito.agregarArticulo(articulo1);
        carrito.agregarArticulo(articulo2);

        // Mostrar la cantidad de artículos y el total del carrito
        System.out.println("Cantidad de artículos en el carrito: " + carrito.getCantidadArticulos());
        System.out.println("Total del carrito: $" + carrito.getTotalCarrito());

        // Serializar el carrito de compras
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files//carrito.ser"))) {
            oos.writeObject(carrito);
            System.out.println("Carrito de compras serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar el carrito de compras
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files//carrito.ser"))) {
            CarritoDeCompras carritoDeserializado = (CarritoDeCompras) ois.readObject();
            System.out.println("Carrito de compras deserializado.");

            // Mostrar la cantidad de artículos y el total del carrito después de la deserialización
            System.out.println("Cantidad de artículos en el carrito: " + carritoDeserializado.getCantidadArticulos());
            System.out.println("Total del carrito: $" + carritoDeserializado.getTotalCarrito());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

