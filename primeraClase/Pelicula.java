package primeraClase;
public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int duracion;

    //Constructor
    public Pelicula(int id, String titulo, String director, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }


    
    //Getters y setters (para acceder a los atributos)
    public int getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getDirector() {return director;}
    public int getDuracion() {return duracion;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    //Metodo para mostrar información de la película
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duracion + " minutos");
    }
}
// Array en java
// Puedes crear un array de objetos Pelicula en otra clase para gestionar una colección de películas.
// Por ejemplo:
// Pelicula[] peliculas = new Pelicula[10]; // Array de 10 películas
// peliculas[0] = new Pelicula(1, "Inception", "Christopher Nolan", 148);
// peliculas[1] = new Pelicula(2, "The Matrix", "Lana
// y Lilly Wachowski", 136);
// peliculas[0].mostrarInformacion(); // Muestra la información de la primera película
// Puedes añadir más películas al array y mostrar su información de manera similar.

