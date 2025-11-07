package PosleKolok;
public class Menadzer extends Zaposleni {
private double bonus;


public Menadzer(String id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double bonus) {
super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
this.bonus = bonus;
}


public double getBonus() { return bonus; }
public void setBonus(double b) { this.bonus = b; }


@Override
public double izracunajMjesecnuPlatu() {
return 1300 + 4 * getUkupanBrojSati() * getPlataPoSatu() + bonus;
}


@Override
public String getTip() { return "Menadžer"; }
}