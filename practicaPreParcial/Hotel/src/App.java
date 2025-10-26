import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    static int op = 0;
    static SistemaHotel sistemaHotel = new SistemaHotel();
    public static void main(String[] args) throws Exception {
        

        do {
            menuHotel();
            switch (op) {
                case 1:
                    menuAgregarReserva();
                    break;
                case 2:
                    menuConfirmarReserva();
                    break;
                case 3:
                    menuCheckIn();
                    break;
                case 4:
                    menuCheckOut();
                    break;
                case 5:
                    menuCancelarReserva();
                    break;
                case 6:
                    menuBuscarReserva();
                    break;
                case 7:
                    menuReservasPorEstado();
                    break;
                case 8:
                    menuReporte();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 9.");
            }
        } while (op != 9);
    }

    public static void menuHotel() throws Exception{
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
    
    public static void menuAgregarReserva() throws Exception{
        System.out.println("=== AGREGAR RESERVA ===");
        System.out.print("Ingrese el código de la reserva: ");
        String codigoReserva = scanner.nextLine();
        System.out.print("Ingrese el nombre del huésped: ");
        String nombreHuesped = scanner.nextLine();
        System.out.print("Ingrese el número de habitación: ");
        int numeroHabitacion = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la cantidad de noches: ");
        int cantidadNoches = 0;
        try {
            cantidadNoches = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Cantidad de noches inválida. Por favor, ingrese un número entero.");
        }
        System.out.print("Ingrese la fecha de entrada (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        LocalDate fechaIngreso = null;
        try {
            fechaIngreso = LocalDate.parse(fecha);
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido. Por favor, use YYYY-MM-DD.");
        }
        EstadoReserva estado = EstadoReserva.PENDIENTE;
        Reserva reserva = new Reserva(codigoReserva,  nombreHuesped, numeroHabitacion, cantidadNoches,  estado, fechaIngreso);
        try {
            System.out.println("Agregando reservas...");
            sistemaHotel.agregarReserva(reserva);
            System.out.println("Reserva "+codigoReserva+" agregada (Habitacion "+numeroHabitacion+" ocupada)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void menuConfirmarReserva() throws Exception{
        System.out.println("=== CONFIRMAR RESERVA ===");
        System.out.print("Ingrese el código de la reserva a confirmar: ");
        String codigoReserva = scanner.nextLine();
        try {
            System.out.println("Confirmando reserva "+codigoReserva+"...");
            sistemaHotel.confirmarReserva(codigoReserva);
            System.out.println("Reserva "+codigoReserva+" confirmada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuCheckIn() throws Exception{
        System.out.println("=== CHECK IN ===");
        System.out.println("Ingrese el codigo de la reserva para hacer Check In: ");
        String codigoReserva = scanner.nextLine();
        try {
            System.out.println("Haciendo check-in de "+codigoReserva);
            sistemaHotel.hacerCheckIn(codigoReserva);
            System.out.println("Check In realizado para "+codigoReserva);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuCheckOut() throws Exception{
        System.out.println("=== CHECK OUT ===");
        System.out.println("Ingrese el codigo de la reserva para hacer Check Out: ");
        String codigoReserva = scanner.nextLine();
        try {
            System.out.println("Haciendo check out de "+codigoReserva);
            sistemaHotel.hacerCheckOut(codigoReserva);
            Reserva reserva = sistemaHotel.buscarReservaPorCodigo(codigoReserva);
            System.out.println("Check Out realizado (Habitacion "+reserva.getNumeroHabitacion()+")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuCancelarReserva() throws Exception{
        System.out.println("=== CANCELAR RESERVA ===");
        System.out.println("Ingrese el codigo de la reserva a cancelar");
        String codigoReserva = scanner.nextLine();
        try {
            System.out.println("Cancelando reserva "+codigoReserva);
            Reserva reserva = sistemaHotel.buscarReservaPorCodigo(codigoReserva);
            sistemaHotel.cancelarReserva(codigoReserva);
            System.out.println("Reserva "+codigoReserva+" cancelada (Habitacion "+reserva.getNumeroHabitacion()+ "liberada)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuReporte() throws Exception{
        System.out.println("=== REPORTE FINAL ===");
        try {
            sistemaHotel.generarReporteOcupacion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuReservasPorEstado() throws Exception{
        System.out.println("=== RESERVAS POR ESTADO ===");
        System.out.println("Ingrese el estado a buscar: ");
        EstadoReserva estado = null;
        while (true) {
            try {
                estado = EstadoReserva.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("Estado no encontrado");
            }
        }
        ArrayList<Reserva> lista = sistemaHotel.obtenerReservasPorEstado(estado);
        System.out.println("Reservas en estado "+estado+":");
        for (Reserva i : lista) {
            if (i.getEstado() == estado) {
                System.out.println("Codigo: "+i.getCodigoReserva()+" | Huesped: "+i.getNombreHuesped()+" | Habitacion: "+i.getNumeroHabitacion()+"\n Noches: "+i.getCantidadNoches()+" | Estado: "+i.getEstado());
            }
        }
    }

    public static void menuBuscarReserva() throws Exception{
        System.out.println("=== BUSCAR RESERVA ===");
        System.out.println("Ingrese el codigo de reserva a buscar: ");
        String codigoReserva = "";
        try {
            codigoReserva = scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Reserva reserva = sistemaHotel.buscarReservaPorCodigo(codigoReserva);
        try {
            System.out.println("Codigo: "+reserva.getCodigoReserva()+" | Huesped: "+reserva.getNombreHuesped()+" | Habitacion: "+reserva.getNumeroHabitacion()+"\n Noches: "+reserva.getCantidadNoches()+" | Estado: "+reserva.getEstado());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
