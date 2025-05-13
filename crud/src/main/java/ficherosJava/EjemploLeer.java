package ficherosJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class EjemploLeer {

    public static void main(String[] args) {

        try {

            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
        buscarPalabra("et");
    }

    public static void buscarPalabra(String palabra) {
        int contador = 0;
        try {

            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String p : palabras) {
                    p.toLowerCase();
                    if (p.toLowerCase().equals(palabra)) {
                        contador++;
                    }
                }
            }
            System.out.println("La palabra " + palabra + " aparece " + contador + " veces");
            lector.close();

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }

    }

}