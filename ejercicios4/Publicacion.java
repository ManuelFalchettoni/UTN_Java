package ejercicios4;

public class Publicacion {
    
    private String titulo;
    private int anio;
    private Boolean disponible;

    //CONSTRUCTOR
    public Publicacion(String titulo, int anio) {
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = true;
    }

    //GETTERS 
    public String getTitulo() {
        return this.titulo;
    }

    public int getAnio() {
        return this.anio;
    }

    public Boolean isDisponible() {
        return this.disponible;
    }
    //SETTERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //Metodos

    public void mostrarInformacion() {
        String texto = "Título: " + titulo + ", Año: " + anio + ", Disponible: ";
        if (this.disponible) {
            texto += "si";
        }else{
            texto += "no";
        }
        System.out.println(texto);
    }

    public void prestar(){
        if (this.disponible) {
            System.out.println("Fue prestado con exito");
            this.disponible = false;
        }else{
            System.out.println("No se encuentra disponible");
        }
    }
    public void devolver(){
        this.disponible = true;
    }

    public Boolean estaDisponible(){
        return this.disponible;
    }

    

    

}
