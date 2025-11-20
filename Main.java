package Zadatak1;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vozilo> vozila = new ArrayList<>();

        vozila.add(new Bicikl("B1", 20));
        vozila.add(new Motor("M1", 60));
        vozila.add(new Automobil("A1", 80));

        double udaljenost = 10;

        for (Vozilo v : vozila) {
            v.info();
            double vrijeme = v.izracunajVrijemeDostave(udaljenost);
            System.out.println("Vrijeme dostave: " + vrijeme);
            if (v instanceof Ekonomican) {
                Ekonomican e = (Ekonomican) v;
                System.out.println("Potrosnja: " + (e.potrosnjaPoKm() * udaljenost));
            }
            System.out.println();
        }

        System.out.println("Rezime:");
        for (Vozilo v : vozila) {
            double vrijeme = v.izracunajVrijemeDostave(udaljenost);
            System.out.print(v.id + ": " + vrijeme);
            if (v instanceof Ekonomican) {
                Ekonomican e = (Ekonomican) v;
                System.out.print(", potrosnja: " + (e.potrosnjaPoKm() * udaljenost));
            }
            System.out.println();
        }
    }
}
