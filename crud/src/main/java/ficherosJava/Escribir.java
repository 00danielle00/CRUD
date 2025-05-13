package ficherosJava;

import java.io.*;
import java.util.Scanner;

public class Escribir {

    public static void main(String[] args) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/prueba_escribir.txt"));

            writer.write("Primera línea escrita.");
            writer.newLine();

            // fuerza la escritura inmediata del contenido al archivo
            writer.flush();
            System.out.println("Primera línea escrita y guardada (flush).");

            // seguimos escribiendo
            writer.write("Segunda línea escrita.");
            writer.newLine();

            // finalmente cerramos (esto también hace flush implícitamente)
            writer.close();
            System.out.println("Segunda línea escrita y archivo cerrado.");

        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }

    }

    public static void ejercicio2Modificado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la carpeta en donde quieres crear los archivos:");
        String carpetaArchivos = sc.nextLine();

        File carpeta = new File(carpetaArchivos);
        if (carpeta.exists()) {
            System.out.println("La carpeta " + carpeta.getName() + " existe");
        } else {
            System.out.println("La carpeta " + carpeta.getName() + " no existe");
        }

        System.out.println("¿Cuantos archivos quieres crear?:");
        int numArchivos = sc.nextInt();
        System.out.println("¿Que nombre quieres que tengan los archivos?:");
        String nombreArchivo = sc.next();

        for (int i = 0; i < numArchivos; i++) {
            String nombreArchivo2 = nombreArchivo + i + ".txt";
            File archivo = new File(carpetaArchivos, nombreArchivo2);
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + archivo.getName());
                } else {
                    System.out.println("El archivo " + archivo.getName() + " ya existe");
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                writer.write("Este es el fichero " + nombreArchivo2);
                writer.newLine();
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void ejercicio9(File archivo) {
        if (!archivo.exists()) {
            System.out.println("El archivo " + archivo.getName() + " no existe");
            return;
        }

        File archivoTemp = new File("src/main/resources/ejercicio9.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemp));

            String linea;
            BufferedReader lector;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}