package es06;

public class DistanzaMassima {
	double carburante;
	double usoCarburante;
	int passeggeri;
	boolean ariaCondizionata;

	public DistanzaMassima(double carburante, double usoCarburante, int passeggeri, boolean ariaCondizionata) {
		this.carburante = carburante;
		this.usoCarburante = usoCarburante;
		this.passeggeri = passeggeri;
		this.ariaCondizionata = ariaCondizionata;
	}
	
	public double calcolaDistanzaMassima() {
		double consumoBase = usoCarburante + (0.05 * passeggeri); // perchè ogni passeggero incide sull'utilizzo del 5%
		// assegno a consumo totale il valore incrementato se è true, il valore invariato di consumoBase se è false
		double consumoTotale = ariaCondizionata ? consumoBase * 1.10 : consumoBase;
		double distanzaMassima = carburante / consumoTotale * 100; // perchè il consumo è sui 100kmù
		return distanzaMassima;
	}
}
