package seriaalizacionObjetos.ejerciciosSerializacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ejercicio1Deserializar {
    public static void main(String[] args) {
        int contador = 1;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/clase_prueba.ser"));
            ArrayList<Ejercicio1Peliculas> listaPeliculas = (ArrayList<Ejercicio1Peliculas>) in.readObject();
            in.close();
            System.out.println("lista de peliculas deserializadas:");
            for (Ejercicio1Peliculas p:listaPeliculas){
                System.out.println("Pelicula "+contador+": "+p);
                contador++;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }
        System.out.println("deserializacion completada.");
    }
}
