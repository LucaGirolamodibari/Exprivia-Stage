package es04;

public class StampaAlbero {
	public static void stampaFunzioneRicorsivaAlbero(Nodo radice) {
		if (radice != null) {
			System.out.println(radice.valoreString + ", " + radice.valoreInteger);
			stampaFunzioneRicorsivaAlbero(radice.figlioSinistro);
			stampaFunzioneRicorsivaAlbero(radice.figlioDestro);
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
