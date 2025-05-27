package seriaalizacionObjetos.ejerciciosSerializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio4 {
    public static void main(String[] args) {
        TreeMap<String, Peliculas> mapaPeliculas = new TreeMap();
        mapaPeliculas.put("Pelicula del año", new Peliculas("Twilight", "Romance"));
        mapaPeliculas.put("Pelicula del mes", new Peliculas("DeadPool", "Acción"));
        mapaPeliculas.put("Pelicula del siglo", new Peliculas("Lilo&Stitch", "Romance"));

        System.out.println("Serialización de peliculas:");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/mapa.ser"));
            out.writeObject(mapaPeliculas);
            out.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        System.out.println("Deserialización de peliculas:");

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/mapa.ser"));
            TreeMap<String, Peliculas> p = (TreeMap<String, Peliculas>) in.readObject();
            in.close();
            System.out.println("lista de peliculas ordenadas por clave:");
            for (Map.Entry<String,Peliculas> pe:p.entrySet()) {
                System.out.println(pe.getKey()+", "+pe.getValue());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }
        System.out.println("deserializacion completada.");

    }
}
