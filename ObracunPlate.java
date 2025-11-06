package PosleKolok;
import java.util.ArrayList;
public class ObracunPlate {
	 String mjesec;
	    int godina;

	    public ObracunPlate(String mjesec, int godina) {
	        this.mjesec = mjesec;
	        this.godina = godina;
	    }

	    public void generisi(ArrayList<Zaposleni> lista) {
	        System.out.println("Obracun plata za: " + mjesec + " " + godina);
	        System.out.println("---------------------------------------------");

	        for (Zaposleni z : lista) {
	            double iznos = z.obracunPlate();
	            System.out.println(z.id + " " + z.ime + " " + z.prezime + " -> " + iznos);
	        }
	    }
	}

