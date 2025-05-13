package ficherosJava;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File fichero = new File("src/main/resources/ejemplo1.txt");

        if (fichero.exists()) System.out.println("El fichero " + fichero.getName() + " existe");
        else System.out.println("El fichero " + fichero.getName() + " no existe");
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());

        File carpeta = new File("src/main/resources");
        if (carpeta.exists()) System.out.println("La carpeta " + carpeta.getName() + " existe");
        else System.out.println("La carpeta " + carpeta.getName() + " no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());

        try {
            if (fichero.createNewFile()) {
                System.out.println("Archivo creado: " + fichero.getName());
            } else {
                System.out.println("El archivo " + fichero.getName() + " ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }
        File archivo = new File("nuevoArchivo.txt");
        try {
            if (archivo.createNewFile()) System.out.println("Archivo creado");
            else System.out.println("El archivo ya existe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File directorio = new File("nuevoDirectorio");
        if (directorio.mkdir()) System.out.println("Directorio creado");
        else System.out.println("No se pudo crear el directorio");

        File archivoBorrar = new File("archivoParaEliminar.txt");
        if (archivoBorrar.delete()) System.out.println("Archivo eliminado");
        else System.out.println("No se pudo eliminar el archivo");

    }

    public static void crearArchivos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la carpeta en donde quieres crear los archivos:");
        String carpetaArchivos = sc.nextLine();

        File carpeta = new File(carpetaArchivos);
        if (carpeta.exists()) System.out.println("La carpeta " + carpeta.getName() + " existe");
        else System.out.println("La carpeta " + carpeta.getName() + " no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());

        System.out.println("Cuantos archivos quieres crear:");
        int numArchivos = sc.nextInt();
        System.out.println("Que nombre quieres que tengan los archivos?:");
        String nombreArchivo = sc.next();

        for (int i = 0; i < numArchivos; i++) {
            try {
                String nombreArchivo2 = nombreArchivo + i + ".txt";
                File archivo = new File(carpetaArchivos, nombreArchivo2);
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + archivo.getName());
                } else {
                    System.out.println("El archivo " + archivo.getName() + " ya existe");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void listarContenido(String rutaCarpeta, String tipoArchivo) {
        File carpeta = new File(rutaCarpeta);
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null && archivos.length > 0) {
                for (File f : archivos) {
                    if (f.isFile() && f.getName().toLowerCase().endsWith(tipoArchivo.toLowerCase())) {
                        System.out.println(f.getName() + " - " + f.length() + " bytes");
                    }
                }
            } else {
                System.out.println("No se ha encontrado ningún archivo.");
            }
        } else System.err.println("La ruta proporcionada no es una carpeta");

    }
}
