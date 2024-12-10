package CapaLogica;

import java.util.ArrayList;
import java.util.Objects;

public class ListaEntrenos {

    public ArrayList<Entrenos> entrenos;

    public ListaEntrenos(ArrayList<Entrenos> entrenos) {
        this.entrenos = entrenos;
    }


    public ArrayList<Entrenos> getEntrenos() {
        return entrenos;
    }

    public void setEntrenos(ArrayList<Entrenos> entrenos) {
        this.entrenos = entrenos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaEntrenos that = (ListaEntrenos) o;
        return Objects.equals(entrenos, that.entrenos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrenos);
    }
}
