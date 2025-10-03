package practicaParcial;

public class Libro {
    private String titulo;
    private String autor;
    private Boolean disponible;

    public Libro (String titulo, String autor, Boolean disponible){
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    //Metodos
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public Boolean isDisponible(){
        return disponible;
    }

    public void setDisponible(Boolean disponible){
        this.disponible = disponible;
    }

    @Override

    public String toString(){
        return "Titulo: " + titulo + "Autor: " + autor + "disponible: " + disponible;
    }

}
