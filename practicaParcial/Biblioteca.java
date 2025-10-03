package practicaParcial;

import java.util.ArrayList;

public class Biblioteca {
    //Atributo
    private ArrayList<Libro> libros;

    //Constructor
    public Biblioteca(ArrayList<Libro> libros){
        this.libros = libros;
    }

    //Metodos
    public void prestarLibro(String titulo) throws LibroNoEncontradoException{
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(null);
                    System.out.println("Libro prestado con exito.");
                    return;
                }else{
                    throw new LibroYaPrestadoException("El libro no esta disponible.");
                }
            }
        }
        throw new LibroNoEncontradoException("No se encontro el libro.");
    }

    public void devolverLibro(String titulo) throws LibroNoEncontradoException{
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!libro.isDisponible()) {
                    libro.setDisponible(true);
                    System.out.println("Libro devuelto con exito.");
                    return;
                }else{
                    throw new LibroYaDisponibleException("El libro ya fue devulto.");
                }
            }
        }
        throw new LibroNoEncontradoException("No se encontro el libro con ese titulo");
    }
}
