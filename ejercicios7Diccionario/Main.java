package ejercicios7Diccionario;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        //Inicio el diccionario
        Diccionario diccionario = new Diccionario();
        diccionario.CargarDatosIniciales();
        Boolean flag = true;
        do {
            //Pido palabra al usuario
            System.out.print("Ingrese una palabra en inglés (o 'salir' para terminar): ");
            String palabraIngles = scanner.nextLine();
            if (palabraIngles.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            }
            try {
                //Busco la palabra en el diccionario
                diccionario.buscarPalabra(palabraIngles);
                //Si la palabra existe, muestro la traduccion
                System.out.println("El significado de " + palabraIngles + " es: " + diccionario.mostrarTraduccion(palabraIngles));
                //Pregunto si quiere ver un sinonimo
                System.out.print("¿Quieres ver un sinónimo? (s/n): ");
                String respuestaSinonimo = scanner.nextLine();
                if (respuestaSinonimo.equalsIgnoreCase("s")) {
                    try {
                        System.out.println("Un sinónimo de " + palabraIngles + " es: " + diccionario.preguntarSinonimo(palabraIngles));
                    } catch (DiccionarioException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }        
        } while (flag == true);
    }
}
