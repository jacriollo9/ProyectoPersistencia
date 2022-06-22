package Clases;

import java.io.Serializable;

/**
 * @author José Adrián Criollo Jiménez
 * Fecha: 15-06-2022
 */

public class Cliente implements Serializable {
    int id;
    String nombre;
    String fecNac;
    public Cliente() {
    }
    public Cliente(int id, String nombre, String fecNac) {
        this.id = id;
        this.nombre = nombre;
        this.fecNac = fecNac;
    }
    public int getId() {
        return id;
    }
    public void setId(int identificador) {
        this.id = identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecNac() {
        return fecNac;
    }
    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecNac=" + fecNac +
                '}';
    }
}
