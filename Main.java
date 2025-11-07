package PosleKolok;
public class Main {
public static void main(String[] args) {
Restoran r = new Restoran("Kod Marka", "Ulica 1, Grad", "123456789");


Konobar k1 = new Konobar("K001", "Marko", "Marković", 6.0, 40, 5);
Kuvar kv1 = new Kuvar("U001", "Ivana", "Ivić", 8.0, 40);
Menadzer m1 = new Menadzer("M001", "Petar", "Petrović", 12.0, 38, 200);
Konobar k2 = new Konobar("K002", "Jelena", "Jelenić", 5.5, 36, 2);
Kuvar kv2 = new Kuvar("U002", "Milan", "Milić", 7.5, 42);


r.dodajZaposlenog(k1);
r.dodajZaposlenog(kv1);
r.dodajZaposlenog(m1);
r.dodajZaposlenog(k2);
r.dodajZaposlenog(kv2);


r.generisiObracun(10, 2025);


double ukupno = r.ukupniTrosak(10, 2025);
System.out.println("Ukupan trošak plata (metoda): " + ukupno + " EUR");
}
}