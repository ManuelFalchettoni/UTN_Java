import java.time.LocalDate;

public class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    //Constructor si todavia no tenemos los datos
    public Persona() {
    };
    //Constructor con datos
    public Persona(String nombre, String apellido, LocalDate fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fecha;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Metodos
    public int edadActual() {
        LocalDate hoy = LocalDate.now();//Dia actual
        if (yaCumplio() || cumpleHoy()) { //Si ya cumplio este año, puedo simplemente restar los años y me da su edad
            return hoy.getYear() - fechaNacimiento.getYear();
        } else { // Sino uno menos de la resta
            return hoy.getYear() - fechaNacimiento.getYear() - 1;
        }
    }

    public boolean yaCumplio() {
        LocalDate hoy = LocalDate.now();//Dia actual
        LocalDate fechaCumple = LocalDate.of(hoy.getYear(), this.fechaNacimiento.getMonthValue(),this.fechaNacimiento.getDayOfMonth());//Fecha del cumpleaños

        return hoy.isAfter(fechaCumple);//Ya paso su cumple? Retorna true or false
    }

    public boolean cumpleHoy() {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaCumple = LocalDate.of(hoy.getYear(), this.fechaNacimiento.getMonthValue(),
                this.fechaNacimiento.getDayOfMonth());

        return hoy.isEqual(fechaCumple);
    }

    public String retornarPersonaConEdad() {//Public String porque no puede retornar un Builder
        StringBuilder sb = new StringBuilder();//Builder

        sb.append("Nombre: ");
        sb.append(this.getNombre());
        sb.append(" ");
        sb.append(this.apellido);
        sb.append("\nEdad: ");
        sb.append(this.edadActual());
        sb.append("\n");
        if (this.cumpleHoy()) {
            sb.append("Feliz cumple crack")
                    .append(this.fechaNacimiento.getDayOfMonth())
                    .append("/")
                    .append(this.fechaNacimiento.getMonthValue());
        } else if (this.yaCumplio()) {
            sb.append("Ya cumplio el dia: ")
                    .append(this.fechaNacimiento.getDayOfMonth())
                    .append("/")
                    .append(this.fechaNacimiento.getMonthValue());
        } else {
            sb.append("Todavia no cumplio, cumple el: ")
                    .append(this.fechaNacimiento.getDayOfMonth())
                    .append("/")
                    .append(this.fechaNacimiento.getMonthValue());
        }

        return sb.toString();//Transformo antes de retornar
    }

    public String toStringCSV() {//Tranformar a formato CSV (con comas entres campos)
        StringBuilder sb = new StringBuilder();

        sb.append(this.getNombre())
                .append(",")
                .append(this.getApellido())
                .append(",")
                .append(this.getFechaNacimiento());

        return sb.toString();
    }

}
