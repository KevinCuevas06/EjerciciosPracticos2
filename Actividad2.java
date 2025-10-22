import java.io.*;
import java.util.Scanner;

public class Actividad2 {
    static class Nodo {
        String palabra;
        Nodo siguiente;
        Nodo(String palabra) { this.palabra = palabra; }
    }

    static class ListaEnlazada {
        Nodo cabeza;

        public void insertar(String palabra) {
            Nodo nuevo = new Nodo(palabra);
            if (cabeza == null) cabeza = nuevo;
            else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) actual = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }

        public void mostrar() {
            if (cabeza == null) { System.out.println("Lista vacía."); return; }
            Nodo actual = cabeza;
            System.out.print("Lista: ");
            while (actual != null) { System.out.print(actual.palabra + " "); actual = actual.siguiente; }
            System.out.println();
        }

        public void eliminar(String palabra) {
            if (cabeza == null) return;
            if (cabeza.palabra.equals(palabra)) { cabeza = cabeza.siguiente; return; }
            Nodo actual = cabeza;
            while (actual.siguiente != null && !actual.siguiente.palabra.equals(palabra)) actual = actual.siguiente;
            if (actual.siguiente != null) actual.siguiente = actual.siguiente.siguiente;
        }

        public void guardarEnArchivo(String nombreArchivo) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                Nodo actual = cabeza;
                while (actual != null) { bw.write(actual.palabra + " "); actual = actual.siguiente; }
            } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.print("Nombre del archivo: ");
        String nombreArchivo = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null)
                for (String p : linea.split("\\s+")) if (!p.isEmpty()) lista.insertar(p);
        } catch (IOException e) { System.out.println("Error al leer el archivo: " + e.getMessage()); }

        int opcion;
        do {
            System.out.println("\n1.Agregar 2.Eliminar 3.Mostrar 4.Guardar y salir");
            opcion = sc.nextInt(); sc.nextLine();
            switch (opcion) {
                case 1 -> { System.out.print("Palabra: "); lista.insertar(sc.nextLine()); }
                case 2 -> { System.out.print("Palabra: "); lista.eliminar(sc.nextLine()); }
                case 3 -> lista.mostrar();
                case 4 -> lista.guardarEnArchivo(nombreArchivo);
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}
