<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Listas Enlazadas - Kevin Cuevas</title>
  <style>
    body {
      font-family: "Segoe UI", Arial, sans-serif;
      background-color: #f3f4f6;
      margin: 0;
      padding: 30px;
    }

    h1 {
      text-align: center;
      color: #1f2937;
      margin-bottom: 20px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      background: white;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      border-radius: 8px;
      overflow: hidden;
    }

    th, td {
      padding: 15px;
      text-align: left;
    }

    th {
      background-color: #1d4ed8;
      color: white;
      text-transform: uppercase;
      font-size: 14px;
      letter-spacing: 1px;
    }

    tr:nth-child(even) {
      background-color: #f9fafb;
    }

    button {
      background-color: #2563eb;
      color: white;
      border: none;
      padding: 8px 12px;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.2s;
    }

    button:hover {
      background-color: #1e40af;
    }

    pre {
      background: #111827;
      color: #f3f4f6;
      padding: 15px;
      border-radius: 8px;
      overflow-x: auto;
      display: none;
      margin-top: 10px;
    }

    .visible {
      display: block;
    }

    footer {
      margin-top: 30px;
      text-align: center;
      font-size: 14px;
      color: #6b7280;
    }
  </style>
</head>
<body>

  <h1>Actividades de Listas Enlazadas - Kevin Cuevas</h1>

  <table>
    <tr>
      <th>Ejercicio</th>
      <th>Descripción</th>
      <th>Acción</th>
    </tr>

    <tr>
      <td>Actividad 1</td>
      <td>Implementar listas enlazadas con números enteros.</td>
      <td><button onclick="toggleCode('codigo1')">Ver código</button></td>
    </tr>
    <tr><td colspan="3"><pre id="codigo1">
import java.util.Random;
import java.util.Scanner;
/**
 * @author Kevin Cuevas
 * Objetivo: Implementar listas enlazadas en números enteros
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
            while (cabeza != null && cabeza.dato > limite)
                cabeza = cabeza.siguiente;
            Nodo actual = cabeza;
            while (actual != null && actual.siguiente != null) {
                if (actual.siguiente.dato > limite)
                    actual.siguiente = actual.siguiente.siguiente;
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
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(100) + 1;
            lista.insertarFinal(num);
        }
        System.out.println("\nLista generada:");
        lista.mostrar();
        System.out.print("\nIngrese el valor límite: ");
        int limite = sc.nextInt();
        lista.eliminarMayores(limite);
        System.out.println("\nLista después de eliminar mayores a " + limite + ":");
        lista.mostrar();
    }
}
</pre></td></tr>

    <tr>
      <td>Actividad 2</td>
      <td>Lista enlazada de palabras desde archivo.</td>
      <td><button onclick="toggleCode('codigo2')">Ver código</button></td>
    </tr>
    <tr><td colspan="3"><pre id="codigo2">
/* Código completo de Actividad2 */
</pre></td></tr>

    <tr>
      <td>Actividad 3</td>
      <td>Representación y evaluación de polinomios.</td>
      <td><button onclick="toggleCode('codigo3')">Ver código</button></td>
    </tr>
    <tr><td colspan="3"><pre id="codigo3">
/* Código completo de Actividad3 */
</pre></td></tr>

    <tr>
      <td>Actividad 4</td>
      <td>Polinomio con lista enlazada circular.</td>
      <td><button onclick="toggleCode('codigo4')">Ver código</button></td>
    </tr>
    <tr><td colspan="3"><pre id="codigo4">
/* Código completo de Actividad4 */
</pre></td></tr>

    <tr>
      <td>Actividad 5</td>
      <td>Lista doblemente enlazada de caracteres.</td>
      <td><button onclick="toggleCode('codigo5')">Ver código</button></td>
    </tr>
    <tr><td colspan="3"><pre id="codigo5">
/* Código completo de Actividad5 */
</pre></td></tr>
  </table>

  <footer>
    © 2025 Kevin Cuevas — Repositorio de Ejercicios en Java
  </footer>

  <script>
    function toggleCode(id) {
      const pre = document.getElementById(id);
      pre.classList.toggle("visible");
    }
  </script>

</body>
</html>
