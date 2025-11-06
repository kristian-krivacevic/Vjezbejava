package PosleKolok;
import java.util.ArrayList;

public class Zaposleni {
		int id;
	    String ime;
	    String prezime;
	    double plataPoSatu;
	    double ukupanBrojSati;

	    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
	        this.id = id;
	        this.ime = ime;
	        this.prezime = prezime;
	        this.plataPoSatu = plataPoSatu;
	        this.ukupanBrojSati = ukupanBrojSati;
	    }

	    public double obracunPlate() {
	        return 0;
	    }

	    public String tipZaposlenog() {
	        return "Zaposleni";
	    }
	}

	class Konobar extends Zaposleni {
	    double prekovremeniSati;

	    public Konobar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati) {
	        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
	        this.prekovremeniSati = prekovremeniSati;
	    }

	    @Override
	    public double obracunPlate() {
	        double sedmica = ukupanBrojSati * plataPoSatu + prekovremeniSati * plataPoSatu * 1.2;
	        return sedmica * 4;
	    }

	    @Override
	    public String tipZaposlenog() {
	        return "Konobar";
	    }
	}

	class Kuvar extends Zaposleni {
	    public Kuvar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
	        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
	    }

	    @Override
	    public double obracunPlate() {
	        return 1500 + 4 * ukupanBrojSati * plataPoSatu;
	    }

	    @Override
	    public String tipZaposlenog() {
	        return "Kuvar";
	    }
	}

	class Menadzer extends Zaposleni {
	    public Menadzer(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
	        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
	    }

	    @Override
	    public double obracunPlate() {
	        return 1300 + 4 * ukupanBrojSati * plataPoSatu;
	    }

	    @Override
	    public String tipZaposlenog() {
	        return "Menadzer";
	    }
	}


