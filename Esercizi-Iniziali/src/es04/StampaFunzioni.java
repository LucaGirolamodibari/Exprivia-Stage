package es04;

public class StampaFunzioni {
	public static void stampaFunzioneRicorsivaAlbero(Nodo radice, int livello) {
		if (radice != null) {
			stampaFunzioneRicorsivaAlbero(radice.figlioDestro, livello + 1);

			for (int i = 0; i < livello; i++) {
				System.out.print("  ");
			}

			System.out.println(radice.valoreString + ", " + radice.valoreInteger);
			stampaFunzioneRicorsivaAlbero(radice.figlioSinistro, livello + 1);
		}
	}

	public static void stampaFunzioneRicorsivaNodiFoglia(Nodo radice) {
		if (radice != null) {
			if (radice.figlioSinistro == null && radice.figlioDestro == null) {
				System.out.println(radice);
			}
			stampaFunzioneRicorsivaNodiFoglia(radice.figlioSinistro);
			stampaFunzioneRicorsivaNodiFoglia(radice.figlioDestro);
		}
	}
}
