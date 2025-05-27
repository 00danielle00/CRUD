package seriaalizacionObjetos.ejerciciosSerializacion.Ejercicio5;

import seriaalizacionObjetos.Persona;

import java.io.*;
import java.util.ArrayList;

public class SerializarDeserializar {
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Empleado 1",1200));
        listaEmpleados.add(new Jefe("jefe1",1300,"Recursos humanos"));
        listaEmpleados.add(new Empleado("Empleado2",2000));
        listaEmpleados.add(new Jefe("jefe2",2400,"Logistica"));

        System.out.println("Serializacion:");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/jefe.ser"));
            out.writeObject(listaEmpleados);
            out.close();
        }catch (IOException e){
            System.out.println();
            e.printStackTrace();

        }
        System.out.println("Deserializacion:");
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/jefe.ser"));
            ArrayList<Empleado> list= (ArrayList<Empleado>) in.readObject();
            in.close();
            System.out.println("Lista de empleados y jefes:");
            for (Empleado empleado: list){
                System.out.println(empleado);
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }
    }
}
