package com.ioFundamentales.practica.practica2;

import java.io.FileInputStream; // (1) Importa la clase FileInputStream para leer archivos binarios.
import java.io.FileOutputStream; // (2) Importa la clase FileOutputStream para escribir archivos binarios.
import java.io.IOException; // (3) Importa la clase IOException para manejar excepciones de entrada/salida.
import java.io.ObjectInputStream; // (4) Importa la clase ObjectInputStream para leer objetos serializados.
import java.io.ObjectOutputStream; // (5) Importa la clase ObjectOutputStream para escribir objetos serializados.

public class MainCarritoDeCompras {

    public static void main(String[] args) {
        // Crear un carrito de compras
        CarritoDeCompras carrito = new CarritoDeCompras(1); // (6) Crea una instancia de la clase CarritoDeCompras con identificador 1.

        // Agregar artículos al carrito
        Articulo articulo1 = new Articulo(1, "Producto 1", 25.99); // (7) Crea una instancia de la clase Articulo.
        Articulo articulo2 = new Articulo(2, "Producto 2", 14.50); // (8) Crea otra instancia de la clase Articulo.

        carrito.agregarArticulo(articulo1); // (9) Agrega el primer artículo al carrito.
        carrito.agregarArticulo(articulo2); // (10) Agrega el segundo artículo al carrito.

        // Mostrar la cantidad de artículos y el total del carrito
        System.out.println("Cantidad de artículos en el carrito: " + carrito.getCantidadArticulos()); // (11) Muestra la cantidad de artículos en el carrito.
        System.out.println("Total del carrito: $" + carrito.getTotalCarrito()); // (12) Muestra el total del carrito.

        // Serializar el carrito de compras
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files//carrito.ser"))) { // (13) Crea un ObjectOutputStream para escribir objetos serializados en un archivo.
            oos.writeObject(carrito); // (14) Escribe el carrito en el archivo "carrito.ser".
            System.out.println("Carrito de compras serializado correctamente."); // (15) Muestra un mensaje de éxito.
        } catch (IOException e) { // (16) Captura y maneja excepciones de entrada/salida.
            e.printStackTrace();
        }

        // Deserializar el carrito de compras
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files//carrito.ser"))) { // (17) Crea un ObjectInputStream para leer objetos serializados desde el archivo.
            CarritoDeCompras carritoDeserializado = (CarritoDeCompras) ois.readObject(); // (18) Lee el carrito desde el archivo y realiza un casting al tipo CarritoDeCompras.
            System.out.println("Carrito de compras deserializado."); // (19) Muestra un mensaje de éxito.

            // Mostrar la cantidad de artículos y el total del carrito después de la deserialización
            System.out.println("Cantidad de artículos en el carrito: " + carritoDeserializado.getCantidadArticulos()); // (20) Muestra la cantidad de artículos en el carrito deserializado.
            System.out.println("Total del carrito: $" + carritoDeserializado.getTotalCarrito()); // (21) Muestra el total del carrito deserializado.
        } catch (IOException | ClassNotFoundException e) { // (22) Captura y maneja excepciones de entrada/salida y excepciones de clase no encontrada.
            e.printStackTrace();
        }
    }
}

