package seriaalizacionObjetos.ejerciciosSerializacion;

import java.io.Serializable;

public class Peliculas implements Serializable {
    private String nombre;
    private transient String genero;

    public Peliculas(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nombre+ " es una película del genero "+genero;
    }
}
