package seriaalizacionObjetos.ejerciciosSerializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio1Serializar {
    public static void main(String[] args) {
        ArrayList<Ejercicio1Peliculas> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Ejercicio1Peliculas("Twilight","Drama"));
        listaPeliculas.add(new Ejercicio1Peliculas("Call me By your name","Romance"));
        listaPeliculas.add(new Ejercicio1Peliculas("Deadpool","Acción"));
        int contador = 1;
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/clase_prueba.ser"));
            out.writeObject(listaPeliculas);
            out.close();
            System.out.println("lista de películas");
            for (Ejercicio1Peliculas p:listaPeliculas){
                System.out.println("Película "+contador+": "+p);
                contador++;
            }
        }catch (IOException e){
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }
        System.out.println("Objeto serializado en clase_prueba.ser");
    }
}
