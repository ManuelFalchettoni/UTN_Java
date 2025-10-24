import java.util.Scanner;
import java.time.LocalDate;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    static int op = 0;
    public static void main(String[] args) throws Exception {
        SistemaHotel sistemaHotel = new SistemaHotel();

        do {
            menuHotel();
            switch (op) {
                case 1:
                    sistemaHotel.agregarReserva();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 9.");
            }
        } while (op != 9);
    }

    public static void menuHotel(){
        String opcion = "";

            System.out.println("=== SISTEMA DE RESERVAS HOTEL ===");
            System.out.println("1. Agregar reserva");
            System.out.println("2. Confirmar reserva");
            System.out.println("3. Check In");
            System.out.println("4. Check Out");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Buscar reserva");
            System.out.println("7. Listar reservas por estado");
            System.out.println("8. Reporte de ocupación");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextLine();
                op = Integer.parseInt(opcion); 
            } catch (Exception e) {
                System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 9.");
            }
    }
    
    public static void menuAgregarReserva(){
        System.out.println("=== AGREGAR RESERVA ===");
        System.out.print("Ingrese el código de la reserva: ");
        String codigoReserva = scanner.nextLine();
        System.out.print("Ingrese el nombre del huésped: ");
        String nombreHuesped = scanner.nextLine();
        System.out.print("Ingrese el número de habitación: ");
        int numeroHabitacion = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la cantidad de noches: ");
        try {
            int cantidadNoches = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Cantidad de noches inválida. Por favor, ingrese un número entero.");
        }
        System.out.print("Ingrese la fecha de entrada (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        try {
            LocalDate fechaIngreso = LocalDate.parse(fecha);
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido. Por favor, use YYYY-MM-DD.");
        }
        Reserva reserva = new Reserva(String codigoReserva, String nombreHuesped, int numeroHabitacion, int cantidadNoches, EstadoReserva estado, LocalDate fechaIngreso);

    }
}
