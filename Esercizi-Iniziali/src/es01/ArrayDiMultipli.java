package es01;

public class ArrayDiMultipli {
	private int[] multipliArray;
	int num;
	int lunghezza;

	public ArrayDiMultipli(int num, int lunghezza) {
		multipliArray = new int[lunghezza];
		this.num = num;
		this.lunghezza = lunghezza;

		for (int i = 0; i < lunghezza; i++) {
			multipliArray[i] = num * (i + 1);
		}
	}

	public int[] getMultipli() {
		return multipliArray;
	}
	
	@Override
	public String toString() {
		return "arrayDiMultipli("  + num + "," + lunghezza + ")➞";
	}

}
