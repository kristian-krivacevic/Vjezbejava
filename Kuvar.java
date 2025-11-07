package PosleKolok;

public class Kuvar extends Zaposleni {
public Kuvar(String id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
}


@Override
public double izracunajMjesecnuPlatu() {
return 1500 + 4 * getUkupanBrojSati() * getPlataPoSatu();
}


@Override
public String getTip() { return "Kuvar"; }
}