import java.util.Random;
import java.util.Scanner;

/**
 * Actividad 01: Manipulación de Lista Enlazada
 * Objetivo: Desarrollar un programa que implemente operaciones básicas sobre una lista enlazada simple de números enteros positivos.
 */
public class Actividad1 {
    static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int dato) { this.dato = dato; }
    }

    static class ListaEnlazada {
        Nodo cabeza;

        void insertarFinal(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (cabeza == null) cabeza = nuevo;
            else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) actual = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }

        void mostrar() {
            Nodo actual = cabeza;
            if (actual == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            System.out.print("Lista: ");
            while (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }

        void eliminarMayores(int limite) {
            while (cabeza != null && cabeza.dato > limite) cabeza = cabeza.siguiente;
            Nodo actual = cabeza;
            while (actual != null && actual.siguiente != null) {
                if (actual.siguiente.dato > limite) actual.siguiente = actual.siguiente.siguiente;
                else actual = actual.siguiente;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        Random random = new Random();

        System.out.print("¿Cuántos números desea generar?: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) lista.insertarFinal(random.nextInt(100) + 1);

        System.out.println("\nLista generada:");
        lista.mostrar();

        System.out.print("\nIngrese el valor límite: ");
        lista.eliminarMayores(sc.nextInt());

        System.out.println("\nLista después de eliminar mayores:");
        lista.mostrar();
    }
}
