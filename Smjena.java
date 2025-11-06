package PosleKolok;
import java.util.ArrayList;
public class Smjena {
	String tipSmjene;
    String datum;

    public Smjena(String tipSmjene, String datum) {
        this.tipSmjene = tipSmjene;
        this.datum = datum;
    }
}

class Restoran {
    String naziv;
    ArrayList<Zaposleni> zaposleni;

    public Restoran(String naziv) {
        this.naziv = naziv;
        zaposleni = new ArrayList<>();
    }

    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }

    public void obrachunPlate() {
        System.out.println("ID\tIme\tPrezime\tTip\tSati\tPlata");
        for (Zaposleni z : zaposleni) {
            System.out.println(z.id + "\t" + z.ime + "\t" + z.prezime + "\t" + z.tipZaposlenog() + "\t" +
                    z.ukupanBrojSati + "\t" + String.format("%.2f", z.obracunPlate()));
        }
    }
}

