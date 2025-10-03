/*  implementar interfaces para agregar funcionalidades específicas usando ArrayList.
INTERFACES A CREAR:
A) Interface Electrico

public interface Electrico {
    void encender();
    void apagar();
    boolean estaEncendido();
}

B) Interface Afinable

public interface Afinable {
    void afinarAutomaticamente();
    boolean estaAfinado();
}
 */
package ejerciciosMusica;


public class Main {
    public static void main(String[] args) {
        StringedInstrument string = new StringedInstrument("Guitar", "Fender", 300, 6);
        StringedInstrument string2 = new StringedInstrument("Bass", "Epipgone", 800, 4);

        WindInstrument wind = new WindInstrument("Clarinete", "Yamaha", 1500,"resin");

        WindInstrument wind2 = new WindInstrument("Saxophon", "Yamaha",     1500, "Copper");

        Instrument[] orchestra = {string,string2,wind,wind2};

        for(Instrument inst : orchestra){
            inst.showInfo();
            System.out.println();
        }

        for (Instrument inst : orchestra) {
            inst.play();
            System.out.println();
        }

        for (Instrument inst : orchestra) {
            inst.tune();
        }
        
    }
}
