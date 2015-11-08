package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Nodo n;
        Grafo grafito = new Grafo();
        int teclado;
        int cant;
        String salir;

        System.out.println("Ingrese cantidad de vértices");
        cant = ent.nextInt();

        //cargo a traves de un bucle while los vertices solicitados
        grafito.cargarVertice(cant);


        System.out.println("Agregar aristas");
        do{
            System.out.println("Desde Nodo");
            int n1 = ent.nextInt();
            System.out.println("hasta Nodo");
            int n2 = ent.nextInt();
            //agrego arista
            grafito.agregarAristas(n1,n2);

            System.out.println("Desea agregar otra Arista (s|n)");
            salir = ent.next();
        }while(salir.equalsIgnoreCase("s"));
        //mostrar grafo;

       // grafito.recorrerGrafo();
        System.out.println("coloreado de vertices");

        System.out.println("Metodo Greedy (Voraz) LDO -ordenado por cant de Mayor Cant de adyancentes ");
        grafito.colorearGreedyLDO();

    }

}
