package practicaParcial;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //Creo los libros
        Libro libro1 = new Libro("A", "Manuel", true);
        Libro libro2 = new Libro("B", "Matias", true);
        Libro libro3 = new Libro("C", "Malena", true);
        //Creo un array para guardarlos
        ArrayList<Libro> libros = new ArrayList<>();
        //Los agrego al array
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        
        //Guardo el array list en la biblioteca
        Biblioteca miBiblioteca = new Biblioteca(libros);

        try {
            miBiblioteca.prestarLibro("D");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }catch (LibroYaPrestadoException e){
            System.out.println(e.getMessage());
        }

    }
}
