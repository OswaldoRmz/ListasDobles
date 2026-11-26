/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

import java.util.Scanner;
import java.util.Locale;
/**
 *
 * @author LENOVO
 */
public class PracticaListasGuiadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();
        int opcion = -1;

        do {            
            System.out.println("       MENU INTERACTIVO - LISTA DOBLE     ");           
            System.out.println("1.  Insertar al inicio");
            System.out.println("2.  Insertar al final");
            System.out.println("3.  Insertar en posicion");
            System.out.println("4.  Insertar ordenado");
            System.out.println("5.  Eliminar ultimo");
            System.out.println("6.  Eliminar en posicion");
            System.out.println("7.  Eliminar por valor");
            System.out.println("8.  Buscar un valor");
            System.out.println("9.  Obtener nodo por posicion");
            System.out.println("10. Actualizar nodo por posicion");
            System.out.println("11. Mostrar lista");
            System.out.println("0.  Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el valor a insertar al inicio: ");
                        int valInicio = sc.nextInt();
                        lista.insertarInicio(valInicio);
                        mostrarLista(lista);
                        break;

                    case 2:
                        System.out.print("Ingresa el valor a insertar al final: ");
                        int valFinal = sc.nextInt();
                        lista.insertarFInal(valFinal);
                        mostrarLista(lista);
                        break;

                    case 3:
                        System.out.print("Ingresa la posicion (1 a " + (lista.getTamanio() + 1) + "): ");
                        int posIns = sc.nextInt();
                        System.out.print("Ingresa el dato: ");
                        int datoPos = sc.nextInt();
                        lista.insertarEnPosicion(posIns, datoPos);
                        mostrarLista(lista);
                        break;

                    case 4:
                        System.out.print("Ingresa el dato a insertar ordenadamente: ");
                        int datoOrd = sc.nextInt();
                        lista.insertarOrdenado(datoOrd);
                        mostrarLista(lista);
                        break;

                    case 5:
                        if (lista.eliminarUltimo()) {
                            System.out.println("Ultimo elemento eliminado correctamente.");
                        } else {
                            System.out.println("La lista esta vacia, no se elimino nada.");
                        }
                        mostrarLista(lista);
                        break;

                    case 6:
                        System.out.print("Ingresa la posicion a eliminar (1 a " + lista.getTamanio() + "): ");
                        int posElim = sc.nextInt();
                        int eliminado = lista.eliminarEnPosicion(posElim);
                        System.out.println("Dato eliminado: " + eliminado);
                        mostrarLista(lista);
                        break;

                    case 7:
                        System.out.print("Ingresa el valor a eliminar: ");
                        int valElim = sc.nextInt();
                        if (lista.eliminarPorValor(valElim)) {
                            System.out.println("Valor " + valElim + " eliminado.");
                        } else {
                            System.out.println("El valor " + valElim + " no se encontro o la lista esta vacia.");
                        }
                        mostrarLista(lista);
                        break;

                    case 8:
                        System.out.print("Ingresa el valor a buscar: ");
                        int valBuscar = sc.nextInt();
                        if (lista.buscar(valBuscar)) {
                            System.out.println("El valor " + valBuscar + " SI existe en la lista.");
                        } else {
                            System.out.println("El valor " + valBuscar + " NO se encuentra en la lista.");
                        }
                        break;

                    case 9:
                        System.out.print("Ingresa la posicion a consultar (1 a " + lista.getTamanio() + "): ");
                        int posObt = sc.nextInt();
                        NodoDoble nodo = lista.obtenerNodo(posObt);
                        System.out.println("Dato en posicion " + posObt + ": " + nodo.getDato());
                        break;

                    case 10:
                        System.out.print("Ingresa la posicion a actualizar (1 a " + lista.getTamanio() + "): ");
                        int posAct = sc.nextInt();
                        System.out.print("Ingresa el nuevo valor: ");
                        int nuevoVal = sc.nextInt();
                        lista.actualizar(posAct, nuevoVal);
                        System.out.println("Nodo actualizado.");
                        mostrarLista(lista);
                        break;

                    case 11:
                        mostrarLista(lista);
                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion no valida. Intenta de nuevo.");
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println("Error de validacion: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarLista(ListaDoble lista) {
        System.out.println("\n--- Estado actual (Tamanio: " + lista.getTamanio() + " | Vacia: " + lista.estaVacia() + ") ---");
        System.out.println("Adelante: " + lista.toString());       
    }   
}
