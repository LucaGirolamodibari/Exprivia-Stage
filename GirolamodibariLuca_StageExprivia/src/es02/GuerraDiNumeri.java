package es02;

public class GuerraDiNumeri {
	int sommaPari = 0;
	int sommaDispari = 0;

	public GuerraDiNumeri(int[] numeri) {
		for (int i : numeri) {
			if (i % 2 == 0) {
				sommaPari += i;
			} else {
				sommaDispari += i;
			}
		}
	}

	@Override
	public String toString() {
		int differenza = sommaPari - sommaDispari;
		if (differenza < 0) {
			return "La guerra è stata vinta dai numeri DISPARI con una differenza di " + differenza + " unità";
		} else if (differenza > 0) {
			return "La guerra è stata vinta dai numeri PARI con una differenza di " + differenza + " unità";
		} else {
			return "La guerra è finita in PAREGGIO";
		}
	}
}
