package ejerciciosMusica;

public class StringedInstrument extends Instrument{
    private int stringsNumber;
    
    public StringedInstrument(String name, String brand, double price, int stringsNumber){
        super(name, brand,price);
        this.stringsNumber = stringsNumber;
    }

    public void play(){
        System.out.println("Playing " + this.stringsNumber + " strings of " + this.getName());
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("\nStrings: " + this.stringsNumber);
    }

    public int getStringsNumber(){
        return this.stringsNumber;
    }
}
