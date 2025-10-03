package ejercicios4;

public class Libro extends Publicacion {
    private String autor;
    private int paginas;

    //Constructor
    public Libro(String titulo, int anio, String autor, int paginas) {
        super(titulo, anio);
        this.autor = autor;
        this.paginas = paginas;
    }
    //string hola = scanner.nextLine()
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Cantidad de paginas" + paginas + " y autor: " + autor );
    }

    public String getAutor(){
        return this.autor;
    }
}
