package primeraClase;

import java.util.Scanner;

public class PrincipalAlumno {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el legajo del alumno: ");
        alumno1.legajo = scanner.nextInt(); 
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Ingrese el nombre del alumno: ");
        alumno1.nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del alumno: ");
        alumno1.apellido = scanner.nextLine(); 
        scanner.close(); 

        alumno1.mostrarDatos();
        alumno1.presentarse();
    }
}
