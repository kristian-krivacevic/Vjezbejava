package ZadatakPrvi;
import javax.swing.JOptionPane;

public class Zadatak1 {
    public static void main(String[] args) {

        String ime = JOptionPane.showInputDialog(null, "Unesite ime:");
        String prezime = JOptionPane.showInputDialog(null, "Unesite prezime:");
        String godiste = JOptionPane.showInputDialog(null, "Unesite godinu rođenja:");

        String pregled = "Ime: " + ime +
                         "\nPrezime: " + prezime +
                         "\nGodina rođenja: " + godiste +
                         "\n\nDa li su uneti podaci tačni?";

        int potvrda = JOptionPane.showConfirmDialog(null, pregled, "Pregled podataka", JOptionPane.YES_NO_OPTION);

        if (potvrda == JOptionPane.YES_OPTION) {
            String email = ime.toLowerCase() + "." + prezime.toLowerCase() + godiste + "@kompanija.me";
            JOptionPane.showMessageDialog(null, "Vaša email adresa je: " + email, "Email", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ponovo pokrenite program i unesite podatke.");
        }
    }
}
