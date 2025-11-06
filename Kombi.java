package vjezbe7;

public class Kombi extends Vozilo{

	
	private int kapacitetPutnika;

	public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetPutnika) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetPutnika = kapacitetPutnika;
	}
	
}
