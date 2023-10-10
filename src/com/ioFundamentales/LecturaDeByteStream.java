
package com.ioFundamentales;

import java.io.FileInputStream;
import java.io.IOException;

public class LecturaDeByteStream {
    
 public static void main(String[] args) {
        // Ruta del archivo de imagen que vamos a leer
        String rutaArchivo = "files//java.jpg";
        String ruta = "C:/Users/mont_/Downloads/java.jpg";
        try(FileInputStream fileInputStream = new FileInputStream(rutaArchivo)) {
            // Crear un FileInputStream para el archivo de imagen
            
            int contador=fileInputStream.available();
            // Crear un buffer para almacenar los bytes leídos
            byte[] buffer = new byte[34936];
           
            // Variable para almacenar la cantidad de bytes leídos
            int bytesRead;
            
            // Leer bytes del archivo y almacenarlos en el buffer
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                // Procesar los bytes leídos (en este ejemplo, imprimirlos)
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                    
                }
               
            }

            System.out.println(contador);


        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}




