package bibliotecaExcepciones;
import java.util.ArrayList;

public class Biblioteca {
    //Atributo de la clase Biblioteca, es decir, va a tener un arrayListo de objetos Libro llamado libros
    private ArrayList<Libro> libros;

    //Constructor 
    public Biblioteca(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    //Metodo prestarLibro
    public void prestarLibro(String titulo) throws LibroNoEncontradoException{
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    System.out.println("Libro: " + libro.getTitulo() + " prestado.");
                    return;
                }else{
                    throw new LibroYaPrestadoException("Ya esta prestado.");
                }
            }
        }
        throw new LibroNoEncontradoException("El libro no fue encontrado.");
    }

    //Metodo devolverLibro
    public void devolverLibro(String titulo) throws LibroNoEncontradoException{
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!libro.isDisponible()) {
                    libro.setDisponible(true);
                    System.out.println("Libro: " + libro.getTitulo() + " devuelto.");
                    return;
                }else{
                    throw new LibroYaDisponibleException("Ya habia sido devuelto.");
                }
            }
        }
        throw new LibroNoEncontradoException("El libro no fue encontrado.");
    }

}
