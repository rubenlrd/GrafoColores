package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Rubén on 29/10/2015.
 */
public class Grafo {
    private List<Nodo> vertices = new ArrayList<Nodo>();


    public void cargarVertice(int cant) {
        Nodo nodo;
        int contador = 0;
        while (contador < cant) {
            contador++;
            int nombre = contador;
            nodo = new Nodo(nombre);
            vertices.add(nodo);
        }
    }

    public Nodo encontrarNodo(int num) {
        for (Nodo n : vertices) {
            if (n.getNombre() == num) {
                return n;
            }
        }
        return null;
    }


    public void agregarAristas(int n1, int n2) {
        Nodo nodo1 = encontrarNodo(n1);
        if (nodo1 == null) return;
        Nodo nodo2 = encontrarNodo(n2);
        if (nodo2 == null) return;
        nodo1.cargaVecino(nodo2);
        nodo2.cargaVecino(nodo1);
    }

    public void mostrarVertices() {
        for (Nodo n : vertices) {
            System.out.println("\tVertice=> " + n.getNombre() + " (Color: " + n.getColor() + ")");
        }
    }


    public void mostrarVerticesConAdyacentes() {
        for (Nodo n : vertices) {
            System.out.println("Vertice=> " + n.getNombre() + "Color: " + n.getColor());
            System.out.println("Adyacentes:");
            for (Nodo vecino : n.getVecinos() )
                System.out.println("\t\t" + vecino.getNombre() + "Color: " + vecino.getColor());
        }
    }


    public void ordenarPorAdyMayor() {
        Collections.sort(vertices, new ComparadorNodoPorCantAdyacentesMayor());
    }

    public void ordenarPorAdyMenor() {
        Collections.sort(vertices, new ComparadorNodoPorCantAdyacentesMenor());
    }
//***********************************************************************************************************
    public void colorearGreedyLDO() {
        System.out.println("\n\n==>Muestro vertices como estabanantes de ordenar ");
        this.mostrarVerticesConAdyacentes();
        //ordenamos de mayor  menor la lista de vertices de acuerdo a la cant de ady.
        this.ordenarPorAdyMayor();
        System.out.println("\n\n==>Muestro vertices ordenados s/Cant.de Adyacencias");
        this.mostrarVertices();
        //obtengo la lista de colores
        ArrayList<String> color = this.colores();
        //recorremos los nodos siguientes, consultando el color de sus adyacentes y los guardo en un set
        for (int i = 0; i < vertices.size(); i++) {
            Nodo actual = vertices.get(i);
            HashSet<String> coloresDeAdy = new HashSet<String>();
            for (Nodo n : actual.getVecinos()) {
                if (!n.getColor().equals("Sin color")) {
                    coloresDeAdy.add(n.getColor());
                }
            }
            if(coloresDeAdy.isEmpty()){
                //si los adyacentes aun no fueron coloreados ("coloresDeAdy" esta vacio) asigno el primer color
                actual.setColor(color.get(0));
            }else{
                //comparo los colores de los adyacentes en el set "coloresDeAdy" con los colores disponibles
                // y asigno el primer color disponible
                for(int c=0;c<color.size();c++) {
                    if (!coloresDeAdy.contains(color.get(c))) {
                        actual.setColor(color.get(c));
                        break;
                    }
                }
            }
        }
        System.out.println("muestro vertices pintados ");
        this.mostrarVertices();
    }
//***********************************************************************************************************

//
    public void recorrerGrafo() {
        Recorridos recorrido = new Recorridos();
        recorrido.bfs(vertices.get(0));
//        ArrayList<Nodo> vert = recorrido.bfs(vertices.get(0));
//        for(Nodo n: vert){
//            System.out.println("Vertice=> " + n.getNombre());
//            //  System.out.println("cant.Vecinos=> " + n.getVecinos());
//
//        }
        // System.out.println("desmarcando leidos");
        bfsNoRecorrido();

    }


    protected void bfsNoRecorrido() {
        Nodo r = vertices.get(0);
        r.setVisitado(false);
        ArrayList<Nodo> cola = new ArrayList<Nodo>();
        cola.add(r);
        while (!cola.isEmpty()) {
            // System.out.println("desmarcando " + cola.get(0));
            Nodo p = cola.get(0);
            cola.remove(0);
            for (Nodo f : p.getVecinos()) {
                if (f.esVisitado()) {
                    f.setVisitado(false);
                    cola.add(f);

                }
            }
        }
    }

    //Lista de colores
    protected ArrayList<String> colores() {
        ArrayList<String> color = new ArrayList<String>();
        color.add("Rojo");
        color.add("Verde");
        color.add("Azul");
        color.add("Amarillo");
        return color;
    }
}
