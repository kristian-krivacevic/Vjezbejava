package Zadatak2;

import java.util.Scanner;

public class UnosCijene {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cijena = 0;
        while (true) {
            System.out.print("Unesite cijenu proizvoda: ");
            String unos = sc.nextLine();
            try {
                cijena = Double.parseDouble(unos);
                if (cijena <= 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Morate unijeti broj.");
            } catch (IllegalArgumentException e) {
                System.out.println("Cijena mora biti pozitivan broj.");
            }
        }
        System.out.println("Unijeli ste validnu cijenu: " + cijena);
        sc.close();
    }
}
