package seriaalizacionObjetos.ejerciciosSerializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializarPelicula {
    public static void main(String[] args) {
        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Peliculas("Twilight","Drama"));
        listaPeliculas.add(new Peliculas("Call me By your name","Romance"));
        listaPeliculas.add(new Peliculas("Deadpool","Acción"));
        int contador = 1;
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/clase_prueba.ser"));
            out.writeObject(listaPeliculas);
            out.close();
            System.out.println("lista de películas");
            for (Peliculas p:listaPeliculas){
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
