package bibliotecaExcepciones;

public class LibroYaPrestadoException extends RuntimeException {
    public LibroYaPrestadoException (String message){
        super(message);
    }
}
