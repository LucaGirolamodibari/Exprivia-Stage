package es02;

public class Main {
	public static void main(String[] args) {
		int[] numeri = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		GuerraDiNumeri guerraDiNumeri = new GuerraDiNumeri(numeri);
		System.out.println(guerraDiNumeri.toString());
	}
}
