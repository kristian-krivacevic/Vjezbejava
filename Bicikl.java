package Zadatak1;
public class Bicikl extends Vozilo implements Ekonomican {

    public Bicikl(String id, double maxBrzina) {
        super(id, maxBrzina);
    }

    @Override
    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / maxBrzina;
    }

    @Override
    public double potrosnjaPoKm() {
        return 0;
    }
}
