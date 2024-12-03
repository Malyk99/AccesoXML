package model;

import java.util.Objects;

public class entrenamiento {

    String nombre;
    int id;
    int duracion;
    String nivel;

    public entrenamiento(int id, String nombre,int duracion, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.nivel = nivel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entrenamiento that = (entrenamiento) o;
        return id == that.id && duracion == that.duracion && Objects.equals(nombre, that.nombre) && Objects.equals(nivel, that.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, duracion, nivel);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
