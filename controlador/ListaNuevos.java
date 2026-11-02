package controlador;
import Modelo.Libro;
import Modelo.Nodo;

public class ListaNuevos {

    private Nodo cabeza;
    private int contador;
    private final int MAX = 20;

    public ListaNuevos() {
        cabeza = null;
        contador = 0;
    }

    public boolean agregar(Libro libro) {
        if (contador >= MAX) {
            System.out.println("¡Ups! Ya llegamos al límite de 20 libros nuevos.");
            return false;
        }
        Nodo nuevo = new Nodo(libro);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        contador++;
        return true;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay libros nuevos registrados.");
            return;
        }
        Nodo actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.dato);
            actual = actual.siguiente;
            i++;
        }
    }

    public void buscarPorCodigo(String codigo) {
        Nodo actual = cabeza;
        boolean encontrado = false;
        while (actual != null) {
            if (actual.dato.toString().toLowerCase().contains(codigo.toLowerCase())) {
                System.out.println("¡Encontrado! -> " + actual.dato);
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        }
        if (!encontrado) System.out.println("No se encontró ningún libro con ese código.");
    }

    public void eliminarUltimo() { // Estilo Pila (LIFO)
        if (cabeza == null) {
            System.out.println("La lista está vacía, no hay nada que eliminar.");
            return;
        }
        if (cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }
        contador--;
        System.out.println("Se eliminó el último libro agregado correctamente.");
    }
    
}
