
package com.ioFundamentales;

import java.util.Scanner;

public class ScannerLeer {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
         System.out.println("Ingrese un numero");
         
         int numero = scanner.nextInt();
         
         System.out.println("Usted ingreso el numero "+ numero);
         
         System.out.println("Ingrese el segundo numero");
         
         int numero2 = scanner.nextInt();
         System.out.println("Usted ingreso el numero "+ numero2);
         
         
         int suma = numero + numero2;
         System.out.println("LA SUMA ES: "+ suma);
         
    }
}
