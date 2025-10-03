package ejercicios5;
import java.util.Scanner;
import java.util.ArrayList;
/*  PARTE 2: En el main, crear un programa que:
Use Scanner para interactuar con el usuario
Cree un ArrayList de Videojuego
Agregue 4 videojuegos pidiendo los datos al usuario
Muestre todos los videojuegos usando for-each
Muestre todos los videojuegos con su índice (numerados del 1 al 4)
Permita buscar un videojuego específico por nombre
Muestre cuántos videojuegos hay en total
Permita eliminar un videojuego por nombre
Muestre solo los videojuegos de un género específico
 */



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        // Agregar 4 videojuegos pidiendo los datos al usuario
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el nombre del videojuego " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el género del videojuego " + (i + 1) + ":");
            String genero = scanner.nextLine();
            videojuegos.add(new Videojuego(nombre, genero));
        }
        // Mostrar todos los videojuegos usando for-each
        System.out.println("\nLista de videojuegos:");
        int indiceMostrar = 1;
        for (Videojuego v : videojuegos) {
            System.out.println(indiceMostrar + ". " + v);
            System.out.println(v);
            indiceMostrar++;   
        }
        // Permitir buscar un videojuego específico por nombre
        System.out.println("\nIngrese el nombre del videojuego a buscar:");
        String nombreBuscar = scanner.nextLine();
        for (Videojuego v : videojuegos) {
            if (v.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Videojuego encontrado: " + v);
                break;
            }
        }
        // Mostrar cuántos videojuegos hay en total
        System.out.println("\nTotal de videojuegos: " + videojuegos.size());

        //Permite eliminar un juego por su nombre
        System.out.println("\nIngrese el nombre del videojuego a eliminar:");
        String nombreEliminar = scanner.nextLine();
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getNombre().equalsIgnoreCase(nombreEliminar)) {
                System.out.println("Videojuego eliminado: " + videojuegos.remove(i));
            }
        }

        System.out.println("Ingrese el genero a buscar: ");
        String generoBuscar = scanner.nextLine();
        for (Videojuego v : videojuegos) {
            if (v.getGenero().equalsIgnoreCase(generoBuscar)) {
                System.out.println(v);
            }
        }
        scanner.close();
    }
}
