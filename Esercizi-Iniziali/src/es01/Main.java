package es01;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ArrayDiMultipli arrayDiMultipli = new ArrayDiMultipli(7,5);
		int[] risultato = arrayDiMultipli.getMultipli();
		System.out.println(arrayDiMultipli.toString() + Arrays.toString(risultato));
		
		ArrayDiMultipli arrayDiMultipli2 = new ArrayDiMultipli(12,10);
		int[] risultato2 = arrayDiMultipli2.getMultipli();
		System.out.println(arrayDiMultipli2.toString() + Arrays.toString(risultato2));
		
		ArrayDiMultipli arrayDiMultipli3 = new ArrayDiMultipli(17,6);
		int[] risultato3 = arrayDiMultipli3.getMultipli();
		System.out.println(arrayDiMultipli3.toString() + Arrays.toString(risultato3));

	}

}
