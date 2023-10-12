//package com.ioFundamentales.practica.practica1;

import java.io.BufferedReader; // (1) Importa la clase BufferedReader para lectura de archivos y entrada de usuario.
import java.io.FileReader; // (2) Importa la clase FileReader para leer archivos de texto.
import java.io.IOException; // (3) Importa la clase IOException para manejar excepciones de entrada/salida.
import java.io.InputStreamReader; // (4) Importa la clase InputStreamReader para entrada de usuario.
import java.util.Scanner; // (5) Importa la clase Scanner para el procesamiento de texto.

public class EscaneoArchivoInteractivo {

    // Contar el número de ocurrencias de la cadena 'search' en el archivo especificado
    public int contarTokens(String archivo, String buscar) throws IOException {
        int contadorInstancias = 0;
        // Encadenar un FileReader a un BufferedReader a un Scanner
        try (BufferedReader br = new BufferedReader(new FileReader(archivo)); // (6) Abre el archivo especificado para lectura.

                Scanner s = new Scanner(br)) { // (7) Crea un objeto Scanner para procesar el contenido del archivo.
            s.useDelimiter("\\W"); // (8) Configura el delimitador del Scanner para dividir palabras basadas en caracteres no alfanuméricos.
            while (s.hasNext()) { // (9) Itera a través de las palabras en el archivo.
                if (buscar.equalsIgnoreCase(s.next().trim())) { // (10) Compara la palabra actual con la palabra de búsqueda, ignorando mayúsculas y minúsculas.
                    contadorInstancias++; // (11) Incrementa el contador de instancias si la palabra coincide.
                }
            }
        } // try-with-resources cerrará las conexiones automáticamente
        return contadorInstancias; // (12) Devuelve el conteo de instancias de la palabra de búsqueda en el archivo.
    }

    // Método principal
    public static void main(String[] args) {
        if (args.length < 1) { // (13) Comprueba si se proporciona al menos un argumento de línea de comandos.
            System.out.println("Uso: java EscaneoArchivoInteractivo <archivo a buscar>");
            System.exit(-1); // (14) Finaliza el programa con un código de error.
        }
        // Guardar el nombre del archivo como una cadena
        String archivo = args[0]; // (15) Obtiene el nombre del archivo desde los argumentos de línea de comandos.

        // Crear una instancia de la clase EscaneoArchivoInteractivo
        EscaneoArchivoInteractivo escaneo = new EscaneoArchivoInteractivo(); // (16) Crea una instancia de la clase para realizar el escaneo.

        // Envolver System.in InputStream con un BufferedReader para leer
        // cada línea desde el teclado.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) { // (17) Prepara la lectura desde la entrada estándar.
            String buscar = "";
            System.out.println("Buscando en el archivo: " + archivo); // (18) Muestra el nombre del archivo a buscar.
            while (true) { // (19) Bucle principal para permitir la entrada interactiva del usuario.
                System.out.print("Ingrese la cadena de búsqueda o 'q' para salir: ");
                buscar = in.readLine().trim(); // (20) Lee la cadena de búsqueda ingresada por el usuario.
                if (buscar.equalsIgnoreCase("q")) { // (21) Comprueba si el usuario desea salir.
                    break; // (22) Sale del bucle si se ingresa 'q'.
                }
                int cantidad = escaneo.contarTokens(archivo, buscar); // (23) Llama al método para contar las instancias de la palabra de búsqueda en el archivo.
                System.out.println("La palabra \"" + buscar + "\" aparece "
                        + cantidad + " veces en el archivo."); // (24) Muestra el resultado del conteo.
            }
        } catch (IOException e) { // (25) Captura y maneja excepciones de entrada/salida.
            System.out.println("Excepción: " + e);
            System.exit(-1); // (26) Finaliza el programa con un código de error en caso de excepción.
        }
    }
}


