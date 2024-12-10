package CapaLogica;

public class Entrenos {
    private String nombre;
    private int duracion;
    private String nivel;

    public Entrenos(){
    }
    public Entrenos(String nombre, int duracion, String nivel) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
