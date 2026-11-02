package Vista;

import controlador.ListaNuevos;
import controlador.ListaPrestamos;
import controlador.ListaReferencia;
import Modelo.Libro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ListaNuevos seccionA = new ListaNuevos();
        ListaPrestamos seccionB = new ListaPrestamos();
        ListaReferencia seccionC = new ListaReferencia();
        int opcion = 0;

        do {
            System.out.println("\n--- BIBLIOTECA 'EL SABER' - MENÚ PRINCIPAL ---");
            System.out.println("1. Sección A: Libros Nuevos (Lista Simple)");
            System.out.println("2. Sección B: Libros en Préstamo (Lista Doble)");
            System.out.println("3. Sección C: Libros de Referencia (Lista Circular)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    int opA;
                    do {
                        System.out.println("\n--- LIBROS NUEVOS ---");
                        System.out.println("1. Agregar libro");
                        System.out.println("2. Mostrar todos");
                        System.out.println("3. Buscar por código");
                        System.out.println("4. Eliminar último (LIFO)");
                        System.out.println("5. Regresar");
                        opA = leer.nextInt(); leer.nextLine();
                        if (opA == 1) {
                            System.out.print("Código: "); String c = leer.nextLine();
                            System.out.print("Título: "); String t = leer.nextLine();
                            System.out.print("Autor: "); String a = leer.nextLine();
                            seccionA.agregar(new Libro(c, t, a));
                        } else if (opA == 2) {
                            seccionA.mostrar();
                        } else if (opA == 3) {
                            System.out.print("Código a buscar: "); String c = leer.nextLine();
                            seccionA.buscarPorCodigo(c);
                        } else if (opA == 4) {
                            seccionA.eliminarUltimo();
                        }
                    } while (opA != 5);
                    break;

                case 2:
                    int opB;
                    do {
                        System.out.println("\n--- LIBROS EN PRÉSTAMO ---");
                        System.out.println("1. Registrar préstamo (al inicio)");
                        System.out.println("2. Mostrar préstamos activos");
                        System.out.println("3. Buscar por título");
                        System.out.println("4. Devolver libro");
                        System.out.println("5. Regresar");
                        opB = leer.nextInt(); leer.nextLine();
                        if (opB == 1) {
                            System.out.print("Código: "); String c = leer.nextLine();
                            System.out.print("Título: "); String t = leer.nextLine();
                            System.out.print("Autor: "); String a = leer.nextLine();
                            seccionB.agregarAlInicio(new Libro(c, t, a));
                        } else if (opB == 2) {
                            seccionB.mostrar();
                        } else if (opB == 3) {
                            System.out.print("Título a buscar: "); String t = leer.nextLine();
                            seccionB.buscarPorTitulo(t);
                        } else if (opB == 4) {
                            System.out.print("Código del libro a devolver: "); String c = leer.nextLine();
                            seccionB.devolverLibro(c);
                        }
                    } while (opB != 5);
                    break;

                case 3:
                    int opC;
                    do {
                        System.out.println("\n--- LIBROS DE REFERENCIA ---");
                        System.out.println("1. Agregar libro de referencia");
                        System.out.println("2. Mostrar siguiente disponible");
                        System.out.println("3. Buscar por autor (recursivo)");
                        System.out.println("4. ¿Está vacía?");
                        System.out.println("5. Regresar");
                        opC = leer.nextInt(); leer.nextLine();
                        if (opC == 1) {
                            System.out.print("Código: "); String c = leer.nextLine();
                            System.out.print("Título: "); String t = leer.nextLine();
                            System.out.print("Autor: "); String a = leer.nextLine();
                            seccionC.agregarCircular(new Libro(c, t, a));
                        } else if (opC == 2) {
                            seccionC.mostrarSiguiente();
                        } else if (opC == 3) {
                            System.out.print("Autor a buscar: "); String a = leer.nextLine();
                            seccionC.buscarPorAutor(a);
                        } else if (opC == 4) {
                            System.out.println("¿Está vacía? " + (seccionC.estaVacia() ? "Sí" : "No"));
                        }
                    } while (opC != 5);
                    break;
            }
        } while (opcion != 4);
        System.out.println("¡Programa finalizado con éxito!");
    }
}

