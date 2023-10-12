package com.ioFundamentales.practica.practica2;

import java.io.IOException; // (1) Importa la clase IOException para manejar excepciones de entrada/salida.
import java.io.ObjectInputStream; // (2) Importa la clase ObjectInputStream para leer objetos serializados.
import java.io.ObjectOutputStream; // (3) Importa la clase ObjectOutputStream para escribir objetos serializados.
import java.io.Serializable; // (4) Importa la interfaz Serializable para habilitar la serialización de objetos.
import java.text.DateFormat; // (5) Importa la clase DateFormat para formatear fechas.
import java.util.ArrayList; // (6) Importa la clase ArrayList para manejar una lista de objetos.
import java.util.Date; // (7) Importa la clase Date para trabajar con fechas.
import java.util.List; // (8) Importa la interfaz List para trabajar con listas.

public class CarritoDeCompras implements Serializable {
    private static final long serialVersionUID = 23L; // (9) Número de versión para la serialización.
    private int idCarrito; // (10) Identificador del carrito de compras.
    private ArrayList<Articulo> articulos; // (11) Lista de artículos en el carrito.
    private transient int cantidadArticulos; // (12) Cantidad de artículos en el carrito (transiente).
    private transient double totalCarrito; // (13) Total del carrito (transiente).

    public CarritoDeCompras(int idCliente) { // (14) Constructor de la clase.
        this.idCarrito = idCliente; // (15) Inicializa el identificador del carrito con el valor pasado como argumento.
        articulos = new ArrayList<>(); // (16) Inicializa la lista de artículos como una nueva instancia de ArrayList.
        cantidadArticulos = 0; // (17) Inicializa la cantidad de artículos en cero.
        totalCarrito = 0; // (18) Inicializa el total del carrito en cero.
    }

    public double getTotalCarrito() { // (19) Método para obtener el total del carrito.
        return totalCarrito;
    }

    public int getIdCarrito() { // (20) Método para obtener el identificador del carrito.
        return idCarrito;
    }

    public void agregarArticulo(Articulo articulo) { // (21) Método para agregar un artículo al carrito.
        if (articulos.add(articulo)) { // (22) Si el artículo se agrega con éxito a la lista.
            totalCarrito += articulo.getCosto(); // (23) Añade el costo del artículo al total del carrito.
        }
    }

    public int getCantidadArticulos() { // (24) Método para obtener la cantidad de artículos en el carrito.
        return articulos.size();
    }

    public List<Articulo> getArticulos() { // (25) Método para obtener la lista de artículos en el carrito.
        return articulos;
    }

    // Este método se llama solo durante la deserialización
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException { // (26) Método para leer el objeto durante la deserialización.
        ois.defaultReadObject(); // (27) Llama al método defaultReadObject() para realizar la deserialización predeterminada.

        // Recalcular el total si el carrito fue deserializado
        if (cantidadArticulos == 0 && (articulos.size() > 0)) { // (28) Si la cantidad de artículos es cero y la lista de artículos no está vacía.
            getCantidadArticulos(); // (29) Recalcula la cantidad de artículos en el carrito.
        }
        if (totalCarrito == 0 && (articulos.size() > 0)) { // (30) Si el total del carrito es cero y la lista de artículos no está vacía.
            for (Articulo articulo : articulos) { // (31) Itera a través de los artículos en el carrito.
                totalCarrito += articulo.getCosto(); // (32) Suma el costo de cada artículo al total del carrito.
            }
        }
        Date fecha = (Date) ois.readObject(); // (33) Lee una fecha del flujo de entrada.
        System.out.println("Carrito de Compras restaurado desde: " + DateFormat.getDateInstance().format(fecha)); // (34) Muestra un mensaje indicando la fecha de restauración del carrito.
    }

    // Este método se llama solo durante la serialización
    private void writeObject(ObjectOutputStream oos) throws IOException { // (35) Método para escribir el objeto durante la serialización.
        oos.defaultWriteObject(); // (36) Llama al método defaultWriteObject() para realizar la serialización predeterminada.
        oos.writeObject(new Date()); // (37) Escribe una fecha en el flujo de salida.
    }
}

