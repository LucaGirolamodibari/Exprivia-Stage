package es04;

public class Main {

	public static void main(String[] args) {
		AlberoBinario alberoBinario = new AlberoBinario();
		alberoBinario.inserisciNodo("Angelo", 5);
		alberoBinario.inserisciNodo("Mario", 3);
		alberoBinario.inserisciNodo("Corrado", 8);
		alberoBinario.inserisciNodo("Samuele", 1);
		alberoBinario.inserisciNodo("Enrico", 4);
		alberoBinario.inserisciNodo("Federica", 7);
		alberoBinario.inserisciNodo("Gaia", 9);
		alberoBinario.inserisciNodo("Mauro", 2);
		alberoBinario.inserisciNodo("Roberto", 6);
		alberoBinario.inserisciNodo("Roberto", 10);
		alberoBinario.inserisciNodo("Vincenzo", 12);
		alberoBinario.inserisciNodo("Luca", 11);
		
		System.out.println("Stampa dell'Albero Binario completo:");
		StampaFunzioni.stampaFunzioneRicorsivaAlbero(alberoBinario.radice, 0);
		
		System.out.println("\nStampa di tutti i Nodi Foglia:");
		StampaFunzioni.stampaFunzioneRicorsivaNodiFoglia(alberoBinario.radice);
	}
}
