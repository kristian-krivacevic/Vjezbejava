package Zadaci;
public class Converter {
    public double eurToUsd = 1.08;
    public double eurToGbp = 0.85;

    public double fromEurToUsd(double eur) {
        return eur * eurToUsd;
    }

    public double fromEurToGbp(double eur) {
        return eur * eurToGbp;
    }

    public double fromUsdToEur(double usd) {
        return usd / eurToUsd;
    }

    public double fromGbpToEur(double gbp) {
        return gbp / eurToGbp;
    }
}
