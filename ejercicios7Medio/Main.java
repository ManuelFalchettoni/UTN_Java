    
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Agenda agenda = new Agenda();

    do {
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar un contacto");
        System.out.println("4. Mostrar todos los contactos.");
        System.out.println("5. Salir.");
        System.out.print("Seleccione una opción: ");
        
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        String nombre;
        Boolean cont = true;
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre del contacto: ");
                nombre = scanner.nextLine();// Consumir el salto de línea
                System.out.println("Ingrese el teléfono del contacto: ");
                String telefono = scanner.nextLine();
                try {
                    agenda.agregarContacto(nombre, telefono);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("Ingrese nombre del contacto a buscar: ");
                nombre = scanner.nextLine();
                try {
                    agenda.buscarTelefeno(nombre);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println("Ingrese el nombre del contacto a eleiminar.");
                nombre = scanner.nextLine();
                try {
                    agenda.eliminarContacto(nombre);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                agenda.mostrarTodosLosContactos();
                break;
            default:
                cont = false;
                break;
        }
        

        
    } while (true);
    
}
}
