package ejerciciosMusica;

public class Instrument {
    private String name;
    private String brand;
    private double price;

    public Instrument(String name, String brand, double price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public void play(){
        System.out.println("Playing " + this.brand +" branded " + this.name);
    }

    public void tune(){
        System.out.println("Touning " + this.name);
    }

    public void showInfo(){
        System.out.println("Name: " + this.name + "\nBrand: " + this.brand + "\nPrice: " + this.price);
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public double getPrice() {
        return this.price;
    }

    
}
