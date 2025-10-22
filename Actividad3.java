import java.util.Scanner;

//@author Kevin Cuevas
public class Actividad3 {
    static class Nodo {
        double coef;
        int exp;
        Nodo siguiente;
        Nodo(double c, int e) { coef = c; exp = e; }
    }

    static class ListaPolinomio {
        Nodo cabeza;

        void insertar(double c, int e) {
            Nodo nuevo = new Nodo(c, e);
            if (cabeza == null) cabeza = nuevo;
            else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) actual = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }

        double evaluar(double x) {
            double res = 0;
            Nodo actual = cabeza;
            while (actual != null) { res += actual.coef * Math.pow(x, actual.exp); actual = actual.siguiente; }
            return res;
        }

        void mostrar() {
            Nodo actual = cabeza;
            System.out.print("P(x) = ");
            while (actual != null) {
                System.out.print(actual.coef + "x^" + actual.exp);
                if (actual.siguiente != null) System.out.print(" + ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPolinomio poli = new ListaPolinomio();

        System.out.println("Ingrese coeficiente y exponente. 'fin' para terminar.");
        while (true) {
            System.out.print("Coeficiente: ");
            String entrada = sc.next();
            if (entrada.equalsIgnoreCase("fin")) break;
            double c = Double.parseDouble(entrada);
            System.out.print("Exponente: ");
            int e = sc.nextInt();
            poli.insertar(c, e);
        }

        poli.mostrar();
        System.out.println("\nx\tP(x)\n---------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) System.out.printf("%.1f\t%.2f%n", x, poli.evaluar(x));
    }
}

