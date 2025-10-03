package ejerciciosMusica;

public class WindInstrument extends Instrument {
    private String material;

    public WindInstrument(String name, String brand, double price, String material){
        super(name,brand,price);
        this.material = material;
    }

    public void play(){
        System.out.println("Blowing " + this.material + " " + this.getName());
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("\nMaterial: " + this.material);
    }

    public String getMaterial(){
        return this.material;
    }
}
