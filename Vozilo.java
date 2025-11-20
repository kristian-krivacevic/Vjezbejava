package Zadatak1;
public abstract class Vozilo {
    protected String id;
    protected double maxBrzina;

    public Vozilo(String id, double maxBrzina) {
        this.id = id;
        this.maxBrzina = maxBrzina;
    }

    public void info() {
        System.out.println("ID: " + id + ", Max brzina: " + maxBrzina);
    }

    public abstract double izracunajVrijemeDostave(double udaljenostKm);
}
