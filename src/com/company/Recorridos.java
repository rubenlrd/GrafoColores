package com.company;

import java.util.ArrayList;

/**
 * Created by Rubén on 31/10/2015.
 */
public class Recorridos {

    public void bfs(Nodo r) {
        //******crear control para saber si existe el nodo q nos pasan******
        r.setVisitado(true);
        ArrayList<Nodo> cola = new ArrayList<Nodo>();
        cola.add(r);
        while (!cola.isEmpty()) {
            System.out.println("mostrando " + cola.get(0));
            Nodo p = cola.get(0);
            cola.remove(0);
            for (Nodo f : p.getVecinos()) {
                if (!f.esVisitado()) {
                    f.setVisitado(true);
                    cola.add(f);

                }
            }
        }
    }
}
