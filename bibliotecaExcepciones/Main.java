package bibliotecaExcepciones;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Libro libro1 = new Libro("1984", "Orwell", true);
        Libro libro2 = new Libro("Paula", "Isabel Allende", true);
        Libro libro3 = new Libro("Martin Fierro", "Jose Hernandez", false);

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        Biblioteca miBiblioteca = new Biblioteca(libros);

        try {
            miBiblioteca.prestarLibro("Paula");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroYaPrestadoException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Paso lo que tenia que pasar.");
        }

        try {
            miBiblioteca.devolverLibro("Paula");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroYaPrestadoException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Paso lo que tenia que pasar.");
        }
    }
}
