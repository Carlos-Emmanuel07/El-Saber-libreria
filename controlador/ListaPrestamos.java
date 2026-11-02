package controlador;

import Modelo.Libro;
import Modelo.Nodo;

public class ListaPrestamos {

    private Nodo cabeza;

    public ListaPrestamos() {
        cabeza = null;
    }

    public void agregarAlInicio(Libro libro) {
        Nodo nuevo = new Nodo(libro);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        System.out.println("Préstamo registrado (agregado al inicio).");
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay préstamos activos ahorita.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public void buscarPorTitulo(String titulo) {
        Nodo actual = cabeza;
        boolean encontrado = false;
        while (actual != null) {
            if (actual.dato.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println("Resultado: " + actual.dato);
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        if (!encontrado) System.out.println("No hay coincidencias con ese título.");
    }

    public void devolverLibro(String codigo) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getCodigo().equalsIgnoreCase(codigo)) {
                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    if (cabeza != null) cabeza.anterior = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    if (actual.siguiente != null) {
                        actual.siguiente.anterior = actual.anterior;
                    }
                }
                System.out.println("Libro devuelto con éxito y eliminado de préstamos.");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("No se encontró ese libro en la lista de préstamos.");
    }
    
}
