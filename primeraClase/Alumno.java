package primeraClase;
public class Alumno {
    public int legajo;
    public String nombre;
    public String apellido;

    public void mostrarDatos() {
        System.out.println("Legajo: " + legajo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre completo: " + nombre + " " + apellido);
    }

    public void presentarse() {
        System.out.println("Hola, soy " + nombre + " " + apellido + " y mi legajo es " + legajo);
    }
}
