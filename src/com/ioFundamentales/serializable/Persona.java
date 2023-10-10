
package com.ioFundamentales.serializable;

import java.io.Serializable;

/**
 *
 * @author mont_
 */
// Clase que implementa Serializable
class Persona implements Serializable {
    String nombre;
    int edad;
    transient double  salario;

    public Persona(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        asignarSalario(salario);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }
    
    public void asignarSalario(double salario){
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + '}';
    }

    
}