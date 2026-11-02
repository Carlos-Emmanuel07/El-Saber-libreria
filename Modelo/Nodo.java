package Modelo;

public class Nodo {
    public Libro dato;
    public Nodo siguiente;
    public Nodo anterior; // Para la lista doble

    public Nodo(Libro dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}