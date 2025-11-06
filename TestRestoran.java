package PosleKolok;

public class TestRestoran {
	    public static void main(String[] args) {
	        Restoran r = new Restoran("Brzi Restoran");

	        Konobar k1 = new Konobar(1, "Marko", "Markovic", 10, 40, 5);
	        Kuvar ku1 = new Kuvar(2, "Ana", "Anic", 12, 38);
	        Menadzer m1 = new Menadzer(3, "Ivan", "Ivanovic", 15, 35);

	        r.dodajZaposlenog(k1);
	        r.dodajZaposlenog(ku1);
	        r.dodajZaposlenog(m1);

	        r.obrachunPlate();

	        ObracunPlate obracun = new ObracunPlate("Novembar", 2025);
	        obracun.generisi(r.zaposleni);
	    }
	}


