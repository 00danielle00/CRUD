package seriaalizacionObjetos.ejerciciosSerializacion;

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/ejercicio3.ser"));
            Peliculas p = (Peliculas) in.readObject();
            in.close();
        }catch (FileNotFoundException e){
            System.out.println("El archivo no fue encontrado. Se creará un archivo con datos por defecto.");
        }catch (IOException | ClassNotFoundException exception){
            System.out.println("El archivo no fue encontrado. Se creará un archivo con datos por defecto.");
            crarArchivoDefecto();
        }

    }

    private static void crarArchivoDefecto() {
        Peliculas peliculas = new Peliculas("nombre por defecto ","genero por defecto");
        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/ejercicio3.ser"));
            out.writeObject(peliculas);
            out.close();

        }catch (IOException e){
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }

    }

}
