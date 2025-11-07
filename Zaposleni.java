package PosleKolok;
public abstract class Zaposleni {
private String id;
private String ime;
private String prezime;
private double plataPoSatu;
private double ukupanBrojSati;


public Zaposleni(String id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
this.id = id;
this.ime = ime;
this.prezime = prezime;
this.plataPoSatu = plataPoSatu;
this.ukupanBrojSati = ukupanBrojSati;
}


public String getId() { return id; }
public String getIme() { return ime; }
public String getPrezime() { return prezime; }
public double getPlataPoSatu() { return plataPoSatu; }
public double getUkupanBrojSati() { return ukupanBrojSati; }
public void setUkupanBrojSati(double s) { this.ukupanBrojSati = s; }
public void setPlataPoSatu(double p) { this.plataPoSatu = p; }


public abstract double izracunajMjesecnuPlatu();
public abstract String getTip();
}