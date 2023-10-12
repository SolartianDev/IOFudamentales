
package com.ioFundamentales;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class CrearArchivo {
    public static void main(String[] args) {
        // Nombre del archivo que vamos a crear
        String nombreArchivo = "files//archivo.txt";
        String ruta = "C:/UsersvRYZEN/Documents/NetBeansProjects/Java IOFundamentals/files";
        
        try {
            // Crear un objeto FileWriter para el archivo
            FileWriter fileWriter = new FileWriter(nombreArchivo);

            // Envolver el FileWriter en un BufferedWriter para una escritura eficiente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // instancia en una unica linea
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter (nombreArchivo));
            
            
            // Generar texto aleatorio y escribirlo en el archivo
            Random random = new Random();
            for (int i = 0; i < 10; i++) { // Genera 10 líneas de texto aleatorio
                String textoAleatorio = generateRandomString(50); // Genera una cadena aleatoria de 50 caracteres
                bufferedWriter.write(textoAleatorio);
                bufferedWriter.newLine(); // Agrega un salto de línea después de cada línea de texto
            }

            // Cerrar BufferedWriter después de escribir en el archivo
            bufferedWriter.close();

            System.out.println("El archivo se ha creado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para generar una cadena aleatoria de longitud dada
    private static String generateRandomString(int length) {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder cadenaAleatoria = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(caracteres.length());
            cadenaAleatoria.append(caracteres.charAt(index));
        }

        return cadenaAleatoria.toString();
    }
}
