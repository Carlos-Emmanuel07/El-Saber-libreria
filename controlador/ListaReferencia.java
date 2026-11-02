package controlador;

import Modelo.Libro;
import Modelo.Nodo;

public class ListaReferencia {
    private Nodo cabeza;
    private Nodo actualCircular; // Para ir avanzando

    public ListaReferencia() {
        cabeza = null;
        actualCircular = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarCircular(Libro libro) {
        Nodo nuevo = new Nodo(libro);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza; // Se apunta a sí mismo
            actualCircular = cabeza;
        } else {
            Nodo ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        System.out.println("Libro de referencia agregado.");
    }

    public void mostrarSiguiente() {
        if (estaVacia()) {
            System.out.println("No hay libros de referencia.");
            return;
        }
        System.out.println("Siguiente libro disponible en sala: " + actualCircular.dato);
        actualCircular = actualCircular.siguiente; // Avanzamos para la próxima vez
    }

    // Búsqueda recursiva exigida por la rúbrica
    public void buscarPorAutor(String autor) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        boolean encontrado = buscarRecursivo(cabeza, autor, cabeza);
        if (!encontrado) {
            System.out.println("No encontré ningún libro de ese autor.");
        }
    }

    private boolean buscarRecursivo(Nodo actual, String autor, Nodo inicio) {
        if (actual.dato.getAutor().toLowerCase().contains(autor.toLowerCase())) {
            System.out.println("Encontrado (recursivo): " + actual.dato);
            return true;
        }
        // Si damos toda la vuelta y regresamos al inicio, terminamos
        if (actual.siguiente == inicio) {
            return false;
        }
        return buscarRecursivo(actual.siguiente, autor, inicio);
    }
}