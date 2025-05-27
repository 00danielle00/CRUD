package JSON.ejemploApuntes.Practica1;

import java.util.ArrayList;
import java.util.List;

public class Videojuegos {
    private String nombre;
    private String plataforma;
    private int precio;
    private boolean disponible;
    private List<String> listaGeneros;

    public Videojuegos(){}

    public Videojuegos(String nombre, String plataforma, int precio, boolean disponible, List<String> listaGeneros) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.listaGeneros = listaGeneros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<String> getListaGeneros() {
        return listaGeneros;
    }

    @Override
    public String toString() {
        return "Videojuegos{" +
                "nombre='" + nombre + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", listaGeneros=" + listaGeneros +
                '}';
    }
}
