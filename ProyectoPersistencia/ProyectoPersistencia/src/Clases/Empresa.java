package Clases;

/**
 * @author José Adrián Criollo Jiménez
 * Fecha: 15-06-2022
 */

public class Empresa {
    String nombre;
    String ruc;
    String ciudad;

    public Empresa(String nombre, String ruc, String ciudad) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", ruc='" + ruc + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
