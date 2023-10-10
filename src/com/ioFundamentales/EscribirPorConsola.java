
package com.ioFundamentales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscribirPorConsola {
     public static void main(String[] args) {
        // Crear un BufferedReader para leer desde la consola
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Por favor, introduce algo desde la consola: ");

        try {
            String entrada=null;
            
            // Leer una línea de texto desde la consola
            while((entrada = reader.readLine()) != null){
                if(entrada.equals("x")){
                    System.exit(0);
                    
                }
                // Mostrar el texto ingresado por el usuario
                System.out.println("Has introducido: " + entrada);
                
            }
           
            
         
        } catch (IOException e) {
            System.out.println("Error al leer desde la consola: " + e.getMessage());
        } finally {
            try {
                // Cerrar el BufferedReader después de su uso
                reader.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el BufferedReader: " + e.getMessage());
            }
        }
    }
}
