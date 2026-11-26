/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 *
 * @author LENOVO
 */
public class ListaDoble {
    private int tamanio;
    private NodoDoble cabeza;
    private NodoDoble cola;
    
    public ListaDoble(){
        tamanio = 0;
        cabeza = null;
        cola = null;
    }
    
    /* Metodos que no cambian */ 
    
    // Verificar si la lista esta vacia
    public boolean estaVacia(){
        if(cabeza == null && cola == null){
            return true;
        }
        else{
            return false;
        }
    }
    public int getTamanio() {
        return tamanio;
    }
    //metodo para buscar un nodo
    public boolean buscar(int dato){
        NodoDoble aux=cabeza;
        while (aux!=null){
            if(aux.getDato()==dato){
                return true;
            }
            aux=aux.getSiguiente();  
        }
           return false;
    }
    // Metodo toString()
    @Override
    public String toString(){
        String res = "";
        NodoDoble aux = cabeza;
        while(aux != null){
            res = res + "<--[" + aux.getDato() + "]-->";
            aux = aux.getSiguiente();
        }
        res = res + "null";
        return res;
    }
    // Obtener nodo
    public NodoDoble obtenerNodo(int pos){
        // caso 1 busqueda de un nodo fuera de rango
        if(pos <= 0 || pos > tamanio)
            throw new IllegalStateException("Fuera de rango");
        
        NodoDoble aux = cabeza;
        for(int i = 1; i < pos; i++){
            aux = aux.getSiguiente();
        }
        return aux;
    }
    // Actulizar nodo
    public void actualizar(int pos, int valor){
        NodoDoble val = obtenerNodo(pos);
        val.setDato(valor);
    }
    
    /* Metodos actualizados */
    
    // Insertamos al inicio
    public void insertarInicio(int valor){
        NodoDoble nuevo = new NodoDoble(valor);
        if(estaVacia()){
            cola = nuevo;            
        }
        else{
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
        }
        cabeza = nuevo;
        tamanio++;
    }
    // Insertamos al final
    public void insertarFInal(int valor){
        NodoDoble nuevo = new NodoDoble(valor);
        if(estaVacia()){
            cabeza = nuevo;
        }else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }
        tamanio++;
        cola = nuevo;
    }
    // Insertar en posiciom
    public void insertarEnPosicion(int pos, int dato){
        if(pos <= 0 || pos > tamanio + 1){
            throw new IllegalStateException("Fuera de rango");
        }

        if(pos == 1){
            insertarInicio(dato);
        }
        else if(pos == tamanio + 1){
            insertarFInal(dato);
        }
        else{
            NodoDoble nuevo = new NodoDoble(dato);
            NodoDoble aux = obtenerNodo(pos);
            NodoDoble ant = aux.getAnterior();

            nuevo.setSiguiente(aux);
            nuevo.setAnterior(ant);
            ant.setSiguiente(nuevo);
            aux.setAnterior(nuevo);
            tamanio++;
        }
    }
    // Insertar ordenado
    public void insertarOrdenado(int dato){
        if(estaVacia() || dato <= cabeza.getDato()){
            insertarInicio(dato);
        }
        else if(dato >= cola.getDato()){
            insertarFInal(dato);
        }
        else{
            NodoDoble nuevo = new NodoDoble(dato);
            NodoDoble aux = cabeza;

            while(aux != null && aux.getDato() < dato){
                aux = aux.getSiguiente();
            }

            NodoDoble ant = aux.getAnterior();
            nuevo.setSiguiente(aux);
            nuevo.setAnterior(ant);
            ant.setSiguiente(nuevo);
            aux.setAnterior(nuevo);
            tamanio++;
        }
    }
    // Eliminar ultimo
    public boolean eliminarUltimo(){
        if(estaVacia()){
            return false;
        }

        if(cabeza == cola){
            cabeza = null;
            cola = null;
        }
        else{
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }

    // Eliminar en posicion
    public int eliminarEnPosicion(int pos){
        if(estaVacia() || pos <= 0 || pos > tamanio){
            throw new IllegalStateException("Fuera de rango");
        }

        int datoEliminado;

        if(cabeza == cola){ // Unico elemento
            datoEliminado = cabeza.getDato();
            cabeza = null;
            cola = null;
            tamanio--;
        }
        else if(pos == 1){
            datoEliminado = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
            tamanio--;
        }
        else if(pos == tamanio){
            datoEliminado = cola.getDato();
            eliminarUltimo(); 
        }
        else{ // Eliminar en medio
            NodoDoble aux = obtenerNodo(pos);
            datoEliminado = aux.getDato();
            NodoDoble ant = aux.getAnterior();
            NodoDoble sig = aux.getSiguiente();

            ant.setSiguiente(sig);
            sig.setAnterior(ant);
            aux.setSiguiente(null);
            aux.setAnterior(null);
            tamanio--;
        }

        return datoEliminado;
    }

    // Eliminar por valor
    public boolean eliminarPorValor(int x){
        if(estaVacia()){
            return false;
        }

        NodoDoble aux = cabeza;
        while(aux != null && aux.getDato() != x){
            aux = aux.getSiguiente();
        }

        if(aux == null){
            return false;
        }

        if(cabeza == cola){ 
            cabeza = null;
            cola = null;
        }
        else if(aux == cabeza){
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        else if(aux == cola){
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        else{
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
        }

        tamanio--;
        return true;
    }
}