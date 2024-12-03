package model;

import java.util.ArrayList;

public class listaEntrenamientos {
    public  ArrayList<entrenamiento> entrenamientos;

    public listaEntrenamientos(ArrayList<entrenamiento> entrenamientos) {
        this.entrenamientos = new ArrayList<entrenamiento>();
    }

    public ArrayList<entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(ArrayList<entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }
}
