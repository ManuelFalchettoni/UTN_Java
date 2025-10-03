import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SistemaCumples {
    public static void main(String[] args){

        GestorArchivos gestorArchivos = new GestorArchivos("personasFechas.csv");

        String[] meses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        }; //Array para mostrar el nombre del mes sabiendo su numero
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("Sistema de cumpleaños\n");
            System.out.println("1. Agregar nueva persona");
            System.out.println("2. Ver todas las personas");
            System.out.println("3. Reporte de cumpleaños por mes");
            System.out.println("4. Mostrar estadisticas por mes");
            System.out.println("5. Buscar por apellido");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    String nombre, apellido,fechaTexto;
                    
                    System.out.println("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese apellido: ");
                    apellido = scanner.nextLine();

                    System.out.println("Ingrese fecha nacimiento con formato yyyy-MM-DD: ");
                    fechaTexto = scanner.nextLine();

                    try {
                        LocalDate fechaNacimiento = LocalDate.parse(fechaTexto);//Transformo la fecha de formato String a LocalDate

                        Persona nueva = new Persona(nombre,apellido,fechaNacimiento);//Creo una nueva persona

                        gestorArchivos.agregarPersona(nueva);//Guardo esa nueva persona en mi archivo CSV
                        System.out.println("Persona agregada correctamente");
                    } catch (Exception e) {
                        System.out.println("Fecha mal formateada");
                    }
                break;
                case 2:
                    List<Persona> personas = gestorArchivos.leerPersonas();//Agarro todos las personas del CSV y las guardo en una array 
                    if (personas.isEmpty()) {//Validacion de si hay personas
                        System.out.println("No hay nada en el archivo.");
                        break;
                    }
                    System.out.println("Personas en el CSV");
                    for (Persona persona : personas) {
                        System.out.println(persona.retornarPersonaConEdad()); //Imprimo el string que me devuelve la funciona
                    }
                break;
                case 3:
                    System.out.println("Ingrese un mes del 1 al 12");
                    int mes = scanner.nextInt();
                    scanner.nextLine();
                    List<Persona> people = gestorArchivos.leerPersonas();//Vuelvo a agarrar todas las personas en un array
                    if (people.isEmpty()) {//Validacion
                        System.out.println("No hay nada en el archivo.");
                        break;
                    }

                    boolean hayCumples= false;//Boolean para saber si alguien cumplio o no

                    System.out.println("Cumpleaños del mes " + mes);

                    for (Persona p : people) {
                        if (p.getFechaNacimiento().getMonthValue() == mes) { //Comparo el valor del mes con lo que ingrese
                            System.out.println(p.retornarPersonaConEdad());//Imprimo toda la info que retorna la funcion
                            hayCumples = true;//Ya se que alguien cumplio este mes, es decir, no es necesario indicar que no hubo nadie
                        }
                    }

                    if (!hayCumples) {//Si nadie cumplio
                        System.out.println("Nadie cumple ese mes ");
                    }


                break;
                case 4:
                    List<Persona> persone = gestorArchivos.leerPersonas();//Guardo en array
                    if (persone.isEmpty()) {//Valido
                        System.out.println("No hay nada en el archivo.");
                        break;
                    }
                    HashMap<Integer,Integer> mapa = gestorArchivos.estadisticaMes(persone);//Guardo el HashMap que devuelve la funcion, el map tiene de Key= numero del mes, value= cantidad ese mes;
                    
                    System.out.println("Estadistica de cumpleaños por mes");
                    for (int i = 1; i <= 12; i++) {//Imprimo por cada mes la cantidad
                        int cantidad = mapa.getOrDefault(i, 0);//Si ese mes no hay ninguno, coloco que el valor es 0.

                        System.out.println(meses[i - 1] + ": " + cantidad + " personas.");//Imprimo MES: CANTIDAD
                    }

                break;
                
                case 5:
                    List<Persona> pApellido = gestorArchivos.leerPersonas();//Guardo en array
                    if (pApellido.isEmpty()) {//Valido
                        System.out.println("No hay nada en el archivo.");
                        break;
                    }

                    System.out.println("Ingrese el apellido a buscar: ");//Pido el texto a buscar
                    String letras = scanner.nextLine();

                    System.out.println(gestorArchivos.buscarPorApellido(letras, pApellido));//Imprimo lo que me devuelve la funcion, que es un String de todos los que tiene ese texto en su apellido


                break;
            
            }
        } while (opcion !=6);
    scanner.close();
    }
}
