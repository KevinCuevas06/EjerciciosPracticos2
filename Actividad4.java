import java.util.Scanner;

public class Actividad4 {
    static class Nodo {
        double coef;
        int exp;
        Nodo siguiente;
        Nodo(double c, int e) { coef = c; exp = e; }
    }

    static class ListaCircular {
        Nodo ultimo;

        void insertar(double c, int e) {
            Nodo nuevo = new Nodo(c, e);
            if (ultimo == null) { ultimo = nuevo; ultimo.siguiente = nuevo; }
            else { nuevo.siguiente = ultimo.siguiente; ultimo.siguiente = nuevo; ultimo = nuevo; }
        }

        void mostrar() {
            if (ultimo == null) { System.out.println("Lista vacía."); return; }
            Nodo actual = ultimo.siguiente;
            System.out.print("P(x) = ");
            do { System.out.print(actual.coef + "x^" + actual.exp); actual = actual.siguiente; if (actual != ultimo.siguiente) System.out.print(" + "); } while (actual != ultimo.siguiente);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircular lista = new ListaCircular();

        System.out.println("Ingrese coeficiente y exponente. 'fin' para terminar.");
        while (true) {
            System.out.print("Coeficiente: ");
            String cstr = sc.next();
            if (cstr.equalsIgnoreCase("fin")) break;
            double c = Double.parseDouble(cstr);
            System.out.print("Exponente: ");
            int e = sc.nextInt();
            lista.insertar(c, e);
        }

        System.out.println("\nRecorrido circular:");
        lista.mostrar();
    }
}
