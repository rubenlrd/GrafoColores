package com.company;

//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

/**
 * Created by Rubén on 26/10/2015.
 */
public class Nodo {
    private int nombre;
    private Set<Nodo> vecinos;
    private boolean visitado;
    private String color;

    public Nodo(int nombre){
        vecinos = new HashSet<Nodo>();
        this.nombre = nombre;
        this.color = "Sin color";
        this.visitado = false;
    }

    public Nodo(){
        visitado = false;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Set<Nodo> getVecinos() {
        return vecinos;
    }

    public void setVecinos(Set<Nodo> vecinos) {
        this.vecinos = vecinos;
    }

    public boolean cargaVecino(Nodo vecino) {
        if(vecino==null)
            return false;
        this.vecinos.add(vecino);
        return  true;
    }
    public boolean esVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "nombre=" + nombre +
                ", Cant.Adyacentes=" + vecinos.size() +
                ", esVisitado=" + visitado +
                ", Color="+color+"}";
    }
}
