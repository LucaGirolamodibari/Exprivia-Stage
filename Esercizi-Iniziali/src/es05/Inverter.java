package es05;

public class Inverter {

	public static String Invert(int numero) {
		if(numero < 0) {
			numero = -numero;
		}
		int numeroInvertito = 0;
		
		while(numero > 0) {                                  //lo faccio fin quando il numero originario non arriva a zero
			int cifra = numero % 10;                         //per trovarmi l'ultima cifra
			numeroInvertito = (numeroInvertito *10) + cifra; //per aggiornare il numero invertito
			numero = numero/10;                              //per rimuovere l'ultima cifra dal numero originario
		}                                                    
	return Integer.toString(numeroInvertito); 
	}

}
