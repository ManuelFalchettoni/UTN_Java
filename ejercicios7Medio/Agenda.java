

import java.util.HashMap;

public class Agenda {
    private HashMap<String, String> agenda;

    public Agenda(){
        this.agenda = new HashMap<>();
    }

    //Agregar contacto
    public void agregarContacto(String nombre, String telefono) throws AgendaException{
        if (nombre.isEmpty()) {
            throw new AgendaException("El nombre no puede estar vacio");
        }
        if(telefono.length() < 7){
            throw new AgendaException("El telefono debe tener al menos 7 digitos.");
        }
        if(agenda.containsKey(nombre)){
            throw new AgendaException("Ya existe un contacto con este nombre.");
        }
        agenda.put(nombre,telefono);
    }

    //Buscar telefeno
    public String buscarTelefeno(String nombre) throws AgendaException{
        nombre = nombre.toLowerCase();
        if(!agenda.containsKey(nombre)){
            throw new AgendaException("No existe ese contacto en la agenda.");
        }
        return agenda.get(nombre);
    }

    //Eliminar contacto
    public void eliminarContacto(String nombre) throws AgendaException{
        if(!agenda.containsKey(nombre)){
            throw new AgendaException("No existe ese contacto en la agenda.");
        }
        agenda.remove(nombre);
    }

    public void mostrarTodosLosContactos(){
        for (String nombre : agenda.keySet()) {
            String telefono = agenda.get(nombre);
            System.out.println("Nombre: " +nombre+ " Telefono: " + telefono);
        }
    }
}
