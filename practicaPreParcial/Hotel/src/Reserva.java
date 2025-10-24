import java.time.LocalDate;

public class Reserva {
    private String codigoReserva;
    private String nombreHuesped;
    private int numeroHabitacion;
    private int cantidadNoches;
    private EstadoReserva estado;
    private LocalDate fechaIngreso;


    public Reserva(String codigoReserva, String nombreHuesped, int numeroHabitacion, int cantidadNoches, EstadoReserva estado, LocalDate fechaIngreso){

        this.codigoReserva = codigoReserva;
        this.nombreHuesped = nombreHuesped;
        this.numeroHabitacion = numeroHabitacion;
        this.cantidadNoches = cantidadNoches;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
    }




    //Getters
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    //Setters
    public void setEstado(EstadoReserva estado){
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "Código:"+this.codigoReserva+" | Huésped: "+this.nombreHuesped+"| Habitación: "+this.numeroHabitacion+" | Noches: "+this.cantidadNoches+" | Estado: "+this.estado;
    }
}
