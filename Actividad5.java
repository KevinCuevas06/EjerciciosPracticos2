import java.util.Scanner;

public class Actividad5 {
    static class Nodo {
        char caracter;
        Nodo anterior, siguiente;
        Nodo(char c) { caracter = c; }
    }

    static class ListaDoble {
        Nodo cabeza, cola;

        void insertar(char c) {
            Nodo nuevo = new Nodo(c);
            if (cabeza == null) cabeza = cola = nuevo;
            else { cola.siguiente = nuevo; nuevo.anterior = cola; cola = nuevo; }
        }

        void mostrar() {
            Nodo actual = cabeza;
            System.out.print("Lista: ");
            while (actual != null) { System.out.print(actual.caracter + " "); actual = actual.siguiente; }
            System.out.println();
        }

        void ordenar() {
            if (cabeza == null) return;
            boolean cambiado;
            do {
                cambiado = false;
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    if (actual.caracter > actual.siguiente.caracter) {
                        char temp = actual.caracter;
                        actual.caracter = actual.siguiente.caracter;
                        actual.siguiente.caracter = temp;
                        cambiado = true;
                    }
                    actual = actual.siguiente;
                }
            } while (cambiado);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();

        System.out.print("Ingrese una cadena: ");
        String cadena = sc.nextLine();

        for (char c : cadena.toCharArray()) lista.insertar(c);

        System.out.println("\nLista original:");
        lista.mostrar();

        lista.ordenar();

        System.out.println("\nLista ordenada alfabéticamente:");
        lista.mostrar();
    }
}
