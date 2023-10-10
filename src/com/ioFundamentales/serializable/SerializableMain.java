 
package com.ioFundamentales.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author mont_
 */
public class SerializableMain {
    public static void main(String[] args) {
        // Serialización: Guardar objeto en un archivo
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("files//persona.ser"))) {
            Persona persona = new Persona("Brandon", 27,123.23);
            salida.writeObject(persona);
            System.out.println("Objeto serializado y guardado en persona.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialización: Leer objeto desde un archivo
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("files//persona.ser"))) {
            
            Persona personaRecuperada = (Persona)entrada.readObject();
                System.out.println(personaRecuperada);
            personaRecuperada.asignarSalario(123.23);
           System.out.println("Objeto deserializado: Nombre - " + personaRecuperada.getNombre() + ", Edad - " + personaRecuperada.getEdad()
           + ", Salario - " + personaRecuperada.getSalario());
        
            
            
           
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    } 
}
