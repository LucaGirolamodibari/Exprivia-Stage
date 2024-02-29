package es06;

public class DistanzaMassima {
	double carburante;
	double usoCarburante;
	int passeggeri;
	boolean ariaCondizionata;

	public DistanzaMassima(double carburante, double usoCarburante, int passeggeri, boolean ariaCondizionata) {
		validaDati(carburante, usoCarburante, passeggeri);
		this.carburante = carburante;
		this.usoCarburante = usoCarburante;
		this.passeggeri = passeggeri;
		this.ariaCondizionata = ariaCondizionata;
		
	}
	
	private void validaDati(double carburante, double usoCarburante, int passeggeri) {
		if (carburante <= 1 || usoCarburante <= 1 || passeggeri < 0) {
            throw new IllegalArgumentException("Carburante e Utilizzo devono essere maggiori di 1, Passeggeri deve essere maggiore o uguale a 0");
        }
		
	}

	public double calcolaDistanzaMassima() {
		double consumoBase = usoCarburante + (0.05 * passeggeri); // perchè ogni passeggero incide sull'utilizzo del 5%
		// assegno a consumo totale il valore incrementato se è true, il valore invariato di consumoBase se è false
		double consumoTotale = ariaCondizionata ? consumoBase * 1.10 : consumoBase;
		double distanzaMassima = carburante / consumoTotale * 100; // perchè il consumo è sui 100kmù
		return distanzaMassima;
	}
}
