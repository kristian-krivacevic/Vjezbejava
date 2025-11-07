package PosleKolok;


public class Konobar extends Zaposleni {
private double prekovremeniSati;


public Konobar(String id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati) {
super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
this.prekovremeniSati = prekovremeniSati;
}


public double getPrekovremeniSati() { return prekovremeniSati; }
public void setPrekovremeniSati(double s) { this.prekovremeniSati = s; }


@Override
public double izracunajMjesecnuPlatu() {
double regularni = Math.max(0, getUkupanBrojSati() - prekovremeniSati);
double sedmicna = regularni * getPlataPoSatu() + prekovremeniSati * getPlataPoSatu() * 1.2;
return 4 * sedmicna;
}


@Override
public String getTip() { return "Konobar"; }
}