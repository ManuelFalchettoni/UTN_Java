package ejercicios4;

public class Revista extends Publicacion {
    
    private int numero;
    private String mes;

    public Revista(String titulo, int anio, int numero, String mes){
        super(titulo, anio);
        this.numero = numero;
        this.mes = mes;
    }

    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Numero: " + numero + " y mes: " + mes);
    }
    
}
