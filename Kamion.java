package vjezbe7;

public class Kamion extends Vozilo {
	private int kapaciretTereta;
	private boolean imaPrikolicu;
	
	public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapaciretTereta,
			boolean imaPrikolicu) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapaciretTereta = kapaciretTereta;
		this.imaPrikolicu = imaPrikolicu;
	}
	

}
