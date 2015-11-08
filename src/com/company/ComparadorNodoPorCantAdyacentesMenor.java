package com.company;

import java.util.Comparator;

/**
 * Created by Rubén on 31/10/2015.
 */
public class ComparadorNodoPorCantAdyacentesMenor implements Comparator<Nodo> {

    @Override
    public int compare(Nodo nodo1, Nodo nodo2) {
        int vec1= nodo1.getVecinos().size();
        int vec2= nodo2.getVecinos().size();
        return vec1-vec2;
    }
}
