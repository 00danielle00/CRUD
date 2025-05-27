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

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Ejercicio a

        List<Videojuegos> listaVideojuegos = new ArrayList<>();

        listaVideojuegos.add(new Videojuegos("Resident Evil","Xbox",40,true, Arrays.asList("Terror")));
        listaVideojuegos.add(new Videojuegos("Guitar Hero","Xbox",20,true, Arrays.asList("Musica")));
        listaVideojuegos.add(new Videojuegos("Halo","Xbox",70,true, Arrays.asList("Accion","Aventura")));

        listaVideojuegos.add(new Videojuegos("Minecraft","PC",20,true, Arrays.asList("Aventura","Sandbox")));
        listaVideojuegos.add(new Videojuegos("Age of Empires IV","PC",22,true, Arrays.asList("Estrategia")));
        listaVideojuegos.add(new Videojuegos("Valorant","PC",10,true, Arrays.asList("Shooter","Competitivo")));

        listaVideojuegos.add(new Videojuegos("Avatar","PS5",80,true, Arrays.asList("Aventura")));
        listaVideojuegos.add(new Videojuegos("Dead Space","PS5",45,true, Arrays.asList("Acción","Aventura")));
        listaVideojuegos.add(new Videojuegos("Watch Dogs","PS5",35,true, Arrays.asList("Competitivo")));


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
