package PosleKolok;
import java.util.*;


public class Restoran {
private String naziv;
private String adresa;
private String pib;
private List<Zaposleni> zaposleni = new ArrayList<>();


public Restoran(String naziv, String adresa, String pib) {
this.naziv = naziv;
this.adresa = adresa;
this.pib = pib;
}


public void dodajZaposlenog(Zaposleni z) { zaposleni.add(z); }
public boolean ukloniPoId(String id) { return zaposleni.removeIf(x -> x.getId().equals(id)); }
public Optional<Zaposleni> pronadjiPoId(String id) {
return zaposleni.stream().filter(e -> e.getId().equals(id)).findFirst();
}


public List<ObracunPlate> generisiObracun(int mjesec, int godina) {
List<ObracunPlate> lista = new ArrayList<>();
System.out.println();
System.out.printf(Locale.US, "%s - obračun plata za %02d/%d\n", naziv, mjesec, godina);
System.out.println("--------------------------------------------------------------------------------");
System.out.printf("%5s | %-15s | %-10s | %6s | %-20s | %10s\n", "ID", "Ime Prezime", "Tip", "Sati", "Prekovremen/Bonus", "Plata(EUR)");
System.out.println("--------------------------------------------------------------------------------");
double ukupno = 0;
for (Zaposleni z : zaposleni) {
double plata = z.izracunajMjesecnuPlatu();
String spec = "";
if (z instanceof Konobar) {
spec = String.format("prek: %.2f", ((Konobar) z).getPrekovremeniSati());
} else if (z instanceof Menadzer) {
spec = String.format("bonus: %.2f", ((Menadzer) z).getBonus());
}
System.out.printf(Locale.US, "%5s | %-15s | %-10s | %6.2f | %-20s | %10.2f\n",
z.getId(), z.getIme() + " " + z.getPrezime(), z.getTip(), z.getUkupanBrojSati(), spec, plata);
lista.add(new ObracunPlate(mjesec, godina, z, plata, spec.isEmpty() ? "" : spec));
ukupno += plata;
}
System.out.println("--------------------------------------------------------------------------------");
System.out.printf(Locale.US, "Ukupan trošak: %.2f EUR\n", ukupno);
System.out.println();
return lista;
}


public double ukupniTrosak(int mjesec, int godina) {
return zaposleni.stream().mapToDouble(Zaposleni::izracunajMjesecnuPlatu).sum();
}
}