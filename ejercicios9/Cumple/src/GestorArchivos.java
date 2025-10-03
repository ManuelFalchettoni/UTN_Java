import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorArchivos {
    private String rutaArchivo;

    public GestorArchivos(String ruta){
        this.rutaArchivo = ruta;
        this.crearArhivoSiNoExiste();//Metodo para crear un archivo
    }

    public void crearArhivoSiNoExiste(){
        File archivo = new File(rutaArchivo);//Creo un nuevo archivo 
        if (!archivo.exists()) { //Si el archivo no existe
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {//Inicializo el escritor
                escritor.write("Nombre,Apellido,FechaDeNacimiento");//Header
                escritor.newLine();//Salto de linea
                System.out.println("Archivo creado ");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public List<Persona> leerPersonas(){
        List<Persona> personas = new ArrayList<>(); //Creo un array
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            boolean primeraLinea = true;//Flag de la primera linea
            String linea; //Variable para ir guardando cada linea
            
            while ((linea = lector.readLine()) != null) {//Si la linea no esta vacia
               if(primeraLinea){//Entro la primera vez porque ya esta en true
                primeraLinea = false;//Cambio su valor
                continue;//Evito realizar todo lo sig porque estoy en la primera linea, salto a la siguiente iteracion
               }
               String [] partes = linea.split(",");//Array donde se va a guardar el CSV dividido por comas

               if (partes.length != 3) {//Validacion
                System.out.println("Linea mal formateada " + linea);
               }

               try {//Guardo en variables las separaciones que tengo en el array
                String nombre = partes[0];//Guardo el nombre
                String apellido = partes[1];
                LocalDate fecha = LocalDate.parse(partes[2]);//Antes de guardar, transformo de String a LocalDate

                personas.add(new Persona(nombre,apellido,fecha));//Nueva persona con sus datos

               } catch (Exception e) {
                System.out.println("Error: "
                 + e.getMessage());
               }



            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    return personas;//Retorno la List con todas las personas
    }

    //Agregar persona al CSV
    public void agregarPersona(Persona p){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {

            escritor.write(p.toStringCSV());//Transformo la info a formato CSV (funcion creada en Persona) y lo escribo en el CSV
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir archivo al agregar persona" + e.getMessage());
        }
    }

    public HashMap estadisticaMes(List<Persona> personas){

        HashMap<Integer, Integer> mapa = new HashMap<>();//Creo un nuevo HashMap

        for (Persona p : personas) {
            Integer mes = p.getFechaNacimiento().getMonthValue();//Variable para el valor del mes numerico
            mapa.put(mes, mapa.getOrDefault(mes, 0) + 1);//Si no tiene valor ya asignado empieza por 0 y ya le agrego 1
        }
        return mapa;//Retorno el HashMap
    }

    public String buscarPorApellido(String letras, List<Persona> personas){//Pido las letras y un array con todas las personas
        StringBuilder sb = new StringBuilder();//Builder
        String letrasLower = letras.toLowerCase();//Letras a minusculas

        for (Persona p : personas) {
            if (p.getApellido().toLowerCase().contains(letrasLower)) {//Si el apellido, transforamado todo a minusculas contiene las letras
                sb.append(p.getNombre())
                    .append(" ")
                    .append(p.getApellido())
                    .append(" ")
                    .append(p.getFechaNacimiento().getYear())
                    .append("/")
                    .append(p.getFechaNacimiento().getMonthValue())
                    .append("/")
                    .append(p.getFechaNacimiento().getDayOfMonth());
                    //Creo un sb largo con todo la informacion, que va a seguir creciendo dependieno la cantidad de personas que contenga esas letras
            }
        }
        return sb.toString();//Retorno el Builder ya transformado a un String normal
    }
    
}
