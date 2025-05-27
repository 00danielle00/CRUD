package JSON.ejemploApuntes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class GsonEjemplo {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        PersonaJSON persona = new PersonaJSON("Luis", 23, Arrays.asList("Java", "Python"));
//        String json = gson.toJson(persona);
//        System.out.println("JSON: "+json);
//        ArrayList<PersonaJSON> listaPersonas = new ArrayList<>(Arrays.asList(new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python")), new PersonaJSON("Patricia", 40, Arrays.asList("Java", "MongoDB"))));
//        String json = gson.toJson(listaPersonas);
//        System.out.println("JSON: " + json);

        //convertir Objeto a JSON

//        ArrayList<PersonaJSON> listaPersonas = new ArrayList<>(Arrays.asList(new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python")), new PersonaJSON("Patricia", 40, Arrays.asList("Java", "MongoDB"))));
//        String json = gson.toJson(listaPersonas);
//        System.out.println("JSON: " + json);
//
//        try (FileWriter writer = new FileWriter("src/main/resources/personas.json")) {
//            gson.toJson(listaPersonas, writer);
//            System.out.println("JSON guardado en persona.json");
//        } catch (Exception e) {
//            System.out.println("Algo ha ido mal.");
//            e.printStackTrace();
//        }

        //De formato json a objeteo java

//        PersonaJSON persona = new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python"));
//        String json = gson.toJson(persona);
//        System.out.println("JSON: " + json);
//
//        // convertir JSON a objeto
//        PersonaJSON persona2 = gson.fromJson(json, PersonaJSON.class);
//        System.out.println("Nombre: " + persona2.getNombre() + ", Edad: " + persona2.getEdad() + " Lenguajes: " + persona2.getLenguajes());

        PersonaJSON persona = new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python"));
        String json = gson.toJson(persona);
        System.out.println("JSON: " + json);

        try (FileWriter writer = new FileWriter("src/main/resources/persona.json")) {
            gson.toJson(persona, writer);
            System.out.println("JSON guardado en persona.json");
        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        // convertir fichero JSON a objeto
        try {
            FileReader reader = new FileReader("src/main/resources/persona.json");
            PersonaJSON persona2 = gson.fromJson(reader, PersonaJSON.class);  // se reconstruye el objeto
            System.out.println("Nombre: " + persona2.getNombre());
            System.out.println("Edad: " + persona2.getEdad());
            System.out.println("Lenguajes: " + persona2.getLenguajes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
