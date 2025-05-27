package seriaalizacionObjetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializarPersona {
    public static void main(String[] args) {
        Persona p = new Persona("Carlos",25);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/persona.ser"));
            out.writeObject(p);
            out.close();

        }catch (IOException e){
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }
        System.out.println("Objeto serializado en persona.ser");
    }
}
