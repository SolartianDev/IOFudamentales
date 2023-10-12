
package com.ioFundamentales;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearCopiaDeArchivo {
    public static void main(String[] args) {
        // Ruta del archivo de imagen original y el nuevo archivo de copia
        String rutaArchivoOriginal = "files//java.jpg";
        String rutaArchivoCopia = "files//java_copia.jpg";

        try {
            // Crear un FileInputStream para el archivo de imagen original
            FileInputStream fileInputStream = new FileInputStream(rutaArchivoOriginal);

            // Crear un FileOutputStream para el nuevo archivo de copia
            FileOutputStream fileOutputStream = new FileOutputStream(rutaArchivoCopia);

            // Crear un buffer para almacenar los bytes leídos
            byte[] buffer = new byte[664064];
            
            // Variable para almacenar la cantidad de bytes leídos
            int bytesRead;
            
            
            int contador=fileInputStream.available();
            System.out.println(contador);
            
            
           // Leer bytes del archivo original y escribirlos en el archivo de copia
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                // Escribir los bytes en el archivo de copia
               
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            // Cerrar FileInputStream y FileOutputStream después de su uso
            fileInputStream.close();
            fileOutputStream.close();
            
            System.out.println("La copia del archivo se ha creado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}
