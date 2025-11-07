package PosleKolok;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.List;


public class Smjena {
public enum TipSmjene { JUTARNJA, POPODNEVNA, NOĆNA }


private LocalDate datum;
private LocalTime pocetak;
private LocalTime kraj;
private TipSmjene tip;
private List<Zaposleni> zaposleni;


public Smjena(LocalDate datum, LocalTime pocetak, LocalTime kraj, TipSmjene tip, List<Zaposleni> zaposleni) {
this.datum = datum;
this.pocetak = pocetak;
this.kraj = kraj;
this.tip = tip;
this.zaposleni = zaposleni;
}


public double trajanjeSati() {
long minute = Duration.between(pocetak, kraj).toMinutes();
if (minute < 0) minute += 24 * 60;
return minute / 60.0;
}


public List<Zaposleni> getZaposleni() { return zaposleni; }
}