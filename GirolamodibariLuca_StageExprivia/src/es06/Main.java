package es06;

public class Main {

	public static void main(String[] args) {
		try {
			DistanzaMassima distanzaMassima = new DistanzaMassima(16.24, 5.04, 3, false);
			System.out.println(distanzaMassima.calcolaDistanzaMassima());
		} catch (IllegalArgumentException e) {
			System.out.println("Valori inseriti non validi: " + e.getMessage());
		}
	}
}