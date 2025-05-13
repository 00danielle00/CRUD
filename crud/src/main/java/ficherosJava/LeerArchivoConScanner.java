package ficherosJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivoConScanner {
    public static void main(String[] args) {
        try {
            File archivo = new File("src/main/resources/datos_personas.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int edad = Integer.parseInt(partes[1]);

                System.out.println(nombre + " tiene " + edad + " años.");
            }

            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
        buscarPalabraScanner("Juan");
    }
    public static void buscarPalabraScanner(String palabra){
        int contador=0;
        try {
            File archivo = new File("src/main/resources/datos_personas.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                for (String p: partes) {
                    if (p.toLowerCase().equals(palabra.toLowerCase())){
                        contador++;
                    }
                }
            }
            System.out.println("La palabra "+palabra+" aparece "+contador+" veces.");

            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
    }
}