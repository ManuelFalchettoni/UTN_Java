package ejercicios4;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Harry", 1900, "JK", 100);

        Libro libro2 = new Libro("Harry2", 1901, "JK2", 87);

        Revista revista = new Revista("Gente", 1950, 30, "Febraio");

        libro1.mostrarInformacion();
        libro2.mostrarInformacion();
        revista.mostrarInformacion();

        libro1.prestar();
        libro1.prestar(); // Intento de prestar de nuevo
        libro1.mostrarInformacion();
        libro1.devolver();
    }
    

}
