package ejercicios7Diccionario;
import java.util.ArrayList;
import java.util.HashMap;
public class Diccionario {
    //Atributo
    private HashMap<String, ArrayList<String>> diccionario;

    //Constructor
    public Diccionario(){
        this.diccionario = new HashMap<>();
    }

    //Metodos
    //Iniciar datos
    //Clave: palabra en inglés
    public void CargarDatosIniciales(){
        ArrayList<String> traducciones1 = new ArrayList<>();
        traducciones1.add("casa");
        traducciones1.add("hogar");
        this.diccionario.put("house", traducciones1);

        ArrayList<String> traducciones2 = new ArrayList<>();
        traducciones2.add("perro");
        traducciones2.add("can");
        this.diccionario.put("dog", traducciones2);

        ArrayList<String> traducciones3 = new ArrayList<>();
        traducciones3.add("gato");
        traducciones3.add("felino");
        this.diccionario.put("cat", traducciones3);
    }

    /* Caso 1: Palabra encontrada

    "house" - el significado de house es: casa
    ¿Sabes alguna otra traducción para enseñarme? (s/n): s
    Nueva traducción agregada: home -> hogar

    Caso 2- palabra NO encontrada

    > computer
    No conozco esa palabra. ¿Me enseñas la traducción? (s/n): s
    ¿Cuál es la traducción de "computer"?: computadora
    ¡Gracias! aprendí una nueva palabra.

    Caso 3- Usuario no quiere enseñar

    > laptop
    No conozco esa palabra. ¿Me enseñas la traducción? (s/n): n
    De acuerdo, seguimos... */



    
    //Buscar palabra: Cuando el usuario ingresa una palabra en inglés, el programa debe buscarla en el diccionario y mostrar sus traducciones al español.
    public ArrayList<String> buscarPalabra(String palabraIngles) throws DiccionarioException{
        if (!this.diccionario.containsKey(palabraIngles)) {
            throw new DiccionarioException("La palabra no existe en el diccionario.");
        }else{
            return this.diccionario.get(palabraIngles);
        }
    }

    //Agregar traduccion: Si no existe la palabra, el programa debe permitir al usuario agregar una nueva traducción para esa palabra.
    public void agregarPalabraYTraduccion(String palabraIngles, String traduccionEspanol){
        ArrayList<String> traducciones = this.diccionario.getOrDefault(palabraIngles, new ArrayList<>());
        traducciones.add(traduccionEspanol);
        this.diccionario.put(palabraIngles, traducciones);
    }
    

    //Mostrar traduccion: Cuando el usuario ingresa una palabra en inglés, el programa debe mostrar una de las traducciones al español.
    public String mostrarTraduccion(String palabraIngles) throws DiccionarioException{
        ArrayList<String> traducciones = this.diccionario.get(palabraIngles);
        if (traducciones != null && !traducciones.isEmpty()) {
            return traducciones.get(0); // Mostrar la primera traducción
        }
        throw new DiccionarioException("No hay traducciones disponibles para esta palabra.");
    }
    

    //Preguntar nueva traduccion: Si la palabra ya existe, el programa debe preguntar al usuario si desea agregar una nueva traducción para esa palabra.
    public boolean preguntarNuevaTraduccion(String palabraIngles){
        return this.diccionario.containsKey(palabraIngles);
    }

    //Preguntar sinonimo: Si la palabra ya existe, el programa debe preguntar al usuario si desea ver un sinónimo de las traducciones existentes.
    public String preguntarSinonimo(String palabraIngles) throws DiccionarioException{
        ArrayList<String> traducciones = this.diccionario.get(palabraIngles);
        if (traducciones != null && traducciones.size() > 1) {
            return traducciones.get(1); // Mostrar el segundo sinónimo si existe
        }
        throw new DiccionarioException("No hay mas sinónimos disponibles para esta palabra.");
    }
    






}
