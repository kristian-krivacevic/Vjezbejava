package PosleKolok;
import java.util.ArrayList;
import java.util.Scanner;

class EProizvodi {
    String opis;
    String sifra;
    double uvoznaCijena;
    double maloprodajnaCijena;

    public EProizvodi(String opis, String sifra, double uvoznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.uvoznaCijena = uvoznaCijena;
        this.maloprodajnaCijena = 0;
    }

    public void obracunMaloprodajneCijene() {
        this.maloprodajnaCijena = this.uvoznaCijena * 1.05;
    }

    public void prikazi() {
        System.out.println("Sifra: " + sifra + ", Opis: " + opis + ", Maloprodajna cijena: " + String.format("%.2f", maloprodajnaCijena));
    }
}

class Racunari extends EProizvodi {
    String procesor;
    int memorija;

    public Racunari(String opis, String sifra, double uvoznaCijena, String procesor, int memorija) {
        super(opis, sifra, uvoznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }

    @Override
    public void obracunMaloprodajneCijene() {
        super.obracunMaloprodajneCijene();
        this.maloprodajnaCijena *= 1.05;
    }

    @Override
    public void prikazi() {
        super.prikazi();
        System.out.println("Procesor: " + procesor + ", Memorija: " + memorija + "GB");
    }
}

class Telefoni extends EProizvodi {
    String operativniSistem;
    double velicinaEkrana;

    public Telefoni(String opis, String sifra, double uvoznaCijena, String os, double ekran) {
        super(opis, sifra, uvoznaCijena);
        this.operativniSistem = os;
        this.velicinaEkrana = ekran;
    }

    @Override
    public void obracunMaloprodajneCijene() {
        super.obracunMaloprodajneCijene();
        if (velicinaEkrana > 6) {
            this.maloprodajnaCijena *= 1.03;
        }
    }

    @Override
    public void prikazi() {
        super.prikazi();
        System.out.println("Operativni sistem: " + operativniSistem + ", Ekran: " + velicinaEkrana + "\"");
    }
}

class TV extends EProizvodi {
    double velicinaEkrana;

    public TV(String opis, String sifra, double uvoznaCijena, double ekran) {
        super(opis, sifra, uvoznaCijena);
        this.velicinaEkrana = ekran;
    }

    @Override
    public void obracunMaloprodajneCijene() {
        super.obracunMaloprodajneCijene();
        if (velicinaEkrana > 65) {
            this.maloprodajnaCijena *= 1.10;
        }
    }

    @Override
    public void prikazi() {
        super.prikazi();
        System.out.println("Ekran: " + velicinaEkrana + "\"");
    }
}

public class UpravljenjeUredjajima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<EProizvodi> uredjaji = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Unos uređaja");
            System.out.println("2. Pregled svih uređaja sa maloprodajnom cijenom");
            System.out.println("3. Pregled uređaja određenog tipa");
            System.out.println("4. Izlaz");
            System.out.print("Odaberite opciju: ");
            String izbor = sc.nextLine();

            if (izbor.equals("1")) {
                System.out.print("Unesite opis uređaja: ");
                String opis = sc.nextLine();
                System.out.print("Unesite šifru uređaja (RA/TE/TV): ");
                String sifra = sc.nextLine();
                System.out.print("Unesite uvoznu cijenu: ");
                double cijena = Double.parseDouble(sc.nextLine());

                if (sifra.toUpperCase().startsWith("RA")) {
                    System.out.print("Unesite procesor: ");
                    String procesor = sc.nextLine();
                    System.out.print("Unesite memoriju (GB): ");
                    int memorija = Integer.parseInt(sc.nextLine());
                    Racunari r = new Racunari(opis, sifra, cijena, procesor, memorija);
                    r.obracunMaloprodajneCijene();
                    uredjaji.add(r);
                } else if (sifra.toUpperCase().startsWith("TE")) {
                    System.out.print("Unesite operativni sistem: ");
                    String os = sc.nextLine();
                    System.out.print("Unesite veličinu ekrana: ");
                    double ekran = Double.parseDouble(sc.nextLine());
                    Telefoni t = new Telefoni(opis, sifra, cijena, os, ekran);
                    t.obracunMaloprodajneCijene();
                    uredjaji.add(t);
                } else if (sifra.toUpperCase().startsWith("TV")) {
                    System.out.print("Unesite veličinu ekrana: ");
                    double ekran = Double.parseDouble(sc.nextLine());
                    TV tv = new TV(opis, sifra, cijena, ekran);
                    tv.obracunMaloprodajneCijene();
                    uredjaji.add(tv);
                } else {
                    System.out.println("Nepoznat tip uređaja!");
                }

            } else if (izbor.equals("2")) {
                for (EProizvodi u : uredjaji) {
                    u.prikazi();
                }

            } else if (izbor.equals("3")) {
                System.out.print("Unesite tip uređaja (RA/TE/TV): ");
                String tip = sc.nextLine().toUpperCase();
                for (EProizvodi u : uredjaji) {
                    if ((tip.equals("RA") && u instanceof Racunari) ||
                        (tip.equals("TE") && u instanceof Telefoni) ||
                        (tip.equals("TV") && u instanceof TV)) {
                        u.prikazi();
                    }
                }

            } else if (izbor.equals("4")) {
                break;
            } else {
                System.out.println("Nepoznata opcija!");
            }
        }

        sc.close();
    }
}
