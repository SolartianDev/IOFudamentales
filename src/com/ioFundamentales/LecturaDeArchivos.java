
package com.ioFundamentales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaDeArchivos {
     public static void main(String[] args) {
        // Nombre del archivo que vamos a leer
        String nombreArchivo = "files//archivo.txt";
        
        try {
            // / Crear un objeto FileReader para el archivo y Envolver el FileReader en un BufferedReader para una lectura eficiente
            BufferedReader bufferedReader =new BufferedReader(new FileReader (nombreArchivo));

            // Variable para almacenar cada línea del archivo
            String linea;

            // Leer cada línea del archivo y mostrarla en la consola
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            // Cerrar BufferedReader después de su uso
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
