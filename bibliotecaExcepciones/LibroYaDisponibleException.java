package bibliotecaExcepciones;

public class LibroYaDisponibleException extends RuntimeException{
    public LibroYaDisponibleException(String message){
        super(message);
    }
}
