package JSON.ejemploApuntes.Practica1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Ejercicio a

        List<Videojuegos> listaVideojuegos = new ArrayList<>();

        System.out.println("Dime 3 videojuegos:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce videojuego ("+(i+1)+"):");
            System.out.println("Introduce el nombre: ");
            String nombre = sc.next();
            System.out.println("Introduce la plataforma(Xbox,PS5,PC):");
            String plataforma = sc.next();
            System.out.println("Introduce el precio: ");
            int precio = sc.nextInt();
            System.out.println("¿Esta disponible?(true,false)");
            boolean disponible=sc.nextBoolean();
            System.out.println("Indica los generos del videojuego (separado por comas):");
            String generos = sc.next();
            List<String> listageneros = Arrays.asList(generos.split(","));
            Videojuegos videojuego = new Videojuegos(nombre,plataforma,precio,disponible,listageneros);
            listaVideojuegos.add(videojuego);
        }

        //Ejercicio b
        String json = gson.toJson(listaVideojuegos);
        System.out.println("JSON: " + json);

        try (FileWriter writer = new FileWriter("src/main/resources/videojuegos.json")) {
            gson.toJson(listaVideojuegos, writer);
            System.out.println("JSON guardado en videojuegos.json");
        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
        //Ejercicio c
        try {
            FileReader reader = new FileReader("src/main/resources/videojuegos.json");
            Videojuegos[] videojuego = gson.fromJson(reader,Videojuegos[].class);
            List<Videojuegos>list = Arrays.asList(videojuego);  // se reconstruye el objeto
            for (Videojuegos v: list){
                System.out.println(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Ejercicio d, se reconstruye ya en el anterior

        //Ejercicio e
        Videojuegos nuevoVideojuego = new Videojuegos("RayMan","Xbox",10,true,Arrays.asList("Aventura"));
        listaVideojuegos.add(nuevoVideojuego);

        //ejercicio f
        System.out.println();
        System.out.println("Videojuegos con precio menor de 30:");
        for (Videojuegos v: listaVideojuegos){
            if (v.getPrecio()<30){
                System.out.println(v);
            }
        }
        System.out.println();

        //Ejercicio g añadir rayman a la lista.
        try (FileWriter writer = new FileWriter("src/main/resources/videojuegos.json")) {
            gson.toJson(listaVideojuegos, writer);
            System.out.println("juego guardado en videojuegos.json");
        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }



    }

}
