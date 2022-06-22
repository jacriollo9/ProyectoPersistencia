package Clases;

/**
 * @author José Adrián Criollo Jiménez
 * Fecha: 15-06-2022
 */

public class Avion {
    String matricula;
    String modelo;
    String nombre;

    public Avion(String matricula, String modelo, String nombre) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
