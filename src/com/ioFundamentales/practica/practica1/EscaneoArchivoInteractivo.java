//package com.ioFundamentales.practica.practica1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EscaneoArchivoInteractivo {

    // Contar el número de ocurrencias de la cadena 'search' en el archivo especificado
    public int contarTokens(String archivo, String buscar) throws IOException {
        int contadorInstancias = 0;
        // Encadenar un FileReader a un BufferedReader a un Scanner
        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
                
                Scanner s = new Scanner(br)) {
            s.useDelimiter("\\W");
            while (s.hasNext()) {
                if (buscar.equalsIgnoreCase(s.next().trim())) {
                    contadorInstancias++;
                }
            }
        } // try-with-resources cerrará las conexiones automáticamente
        return contadorInstancias;
    }

    // Método principal
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java EscaneoArchivoInteractivo <archivo a buscar>");
            System.exit(-1);
        }
        // Guardar el nombre del archivo como una cadena
        String archivo = args[0];

        // Crear una instancia de la clase EscaneoArchivoInteractivo
        EscaneoArchivoInteractivo escaneo = new EscaneoArchivoInteractivo();

        // Envolver System.in InputStream con un BufferedReader para leer
        // cada línea desde el teclado.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // Envolver System.in InputStream con un BufferedReader para leer
            // cada línea desde el teclado.
            String buscar = "";
            System.out.println("Buscando en el archivo: " + archivo);
            while (true) {
                System.out.print("Ingrese la cadena de búsqueda o 'q' para salir: ");
                buscar = in.readLine().trim();
                if (buscar.equalsIgnoreCase("q")) {
                    break;
                }
                int cantidad = escaneo.contarTokens(archivo, buscar);
                System.out.println("La palabra \"" + buscar + "\" aparece "
                        + cantidad + " veces en el archivo.");
            }
        } catch (IOException e) { // Capturar cualquier excepción de IO.
            System.out.println("Excepción: " + e);
            System.exit(-1);
        }
    }
}

