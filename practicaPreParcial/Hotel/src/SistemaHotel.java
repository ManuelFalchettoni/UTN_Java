import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SistemaHotel {
    private HashMap<String, Reserva> mapReservas;
    private HashMap<Integer, String> mapOcupadas;

    private static final int TOTAL_HABITACIONES = 50;

    public SistemaHotel(){
        this.mapReservas = new HashMap<>();
        this.mapOcupadas = new HashMap<>();
    }

    public void agregarReserva(Reserva reserva) throws Exception{
        if (mapOcupadas.containsKey(reserva.getNumeroHabitacion())) {
            throw new IllegalStateException("La habitación " + reserva.getNumeroHabitacion() + " ya está ocupada");
        }else{
            mapReservas.put(reserva.getCodigoReserva(), reserva);
            mapOcupadas.put(reserva.getNumeroHabitacion(),reserva.getCodigoReserva());
        }
    }

    public void confirmarReserva(String codigoReserva) throws ReservaNoEncontradaException{
        if (mapReservas.containsKey(codigoReserva)) {
            String estadoConfirmado = "CONFIRMADA";
            EstadoReserva estado = EstadoReserva.valueOf(estadoConfirmado);
            mapReservas.get(codigoReserva).setEstado(estado);
        }else{
            throw new ReservaNoEncontradaException("No se encontro la reserva");
        }
    }

    public void hacerCheckIn(String codigoReserva) throws ReservaNoEncontradaException{
        if (mapReservas.containsKey(codigoReserva)) {
            EstadoReserva estado = EstadoReserva.valueOf("CHECK_IN");
            mapReservas.get(codigoReserva).setEstado(estado);
        }else{
            throw new ReservaNoEncontradaException("No se encontro la reserva");
        }
    }

    public void hacerCheckOut(String codigoReserva) throws ReservaNoEncontradaException{
        if (mapReservas.containsKey(codigoReserva)) {
            EstadoReserva estado = EstadoReserva.valueOf("CHECK_OUT");
            Reserva reserva = mapReservas.get(codigoReserva);
            mapReservas.get(codigoReserva).setEstado(estado);
            mapReservas.remove(reserva.getNumeroHabitacion());
        }else{
            throw new ReservaNoEncontradaException("No se encontro la reserva");
        }
    }

    public void cancelarReserva(String codigoReserva) throws ReservaNoEncontradaException{
        if (mapReservas.containsKey(codigoReserva)) {
            EstadoReserva estado = EstadoReserva.valueOf("CANCELADA");
            Reserva reserva = mapReservas.get(codigoReserva);
            mapReservas.get(codigoReserva).setEstado(estado);
            mapReservas.remove(reserva.getNumeroHabitacion());
        }else{
            throw new ReservaNoEncontradaException("No se encontro la reserva");
        }
    }

    public Reserva buscarReservaPorCodigo(String codigoReserva) throws ReservaNoEncontradaException{
        if (mapReservas.containsKey(codigoReserva)) {
            return mapReservas.get(codigoReserva);
        }else{
            throw new ReservaNoEncontradaException("Reserva "+codigoReserva+" no encontrada");
        }
    }

    public ArrayList<Reserva> obtenerReservasPorEstado(EstadoReserva estado){
        ArrayList<Reserva> lista = new ArrayList<>();
        for (Reserva i : mapReservas.values()) {
            if (i.getEstado() == estado) {
                lista.add(i);
            }
        }
        return lista;
    }

    public String generarReporteOcupacion(){
        int cantidadReservas = mapReservas.size();
        int cantidadOcupadas = mapOcupadas.size();
        int porcentajeOcupacion = (cantidadOcupadas/TOTAL_HABITACIONES)*10;
        return "Total reservas: "+cantidadReservas+"\n Habitaciones ocupadas: "+cantidadOcupadas+"\n Ocupacion: "+porcentajeOcupacion+"%";
    }


}
