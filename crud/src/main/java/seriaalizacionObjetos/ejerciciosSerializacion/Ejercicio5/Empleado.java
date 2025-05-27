package seriaalizacionObjetos.ejerciciosSerializacion.Ejercicio5;

import java.io.Serializable;

public class Empleado implements Serializable {
    private String nombre;
    private int salario;

    public Empleado(String nombre, int salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", salario: " + salario;
    }
}
