package es04;

public class AlberoBinario {
	Nodo radice;

	public AlberoBinario() {
		radice = null;
	}

	public void inserisciNodo(String valoreString, int valoreInteger) {
		radice = funzioneRicorsiva(radice, valoreString, valoreInteger);
	}

	private Nodo funzioneRicorsiva(Nodo radice, String valoreString, int valoreInteger) {
		if (radice == null) {
			radice = new Nodo(valoreString, valoreInteger);
			return radice;
		}
		if (valoreInteger < radice.valoreInteger) {
			radice.figlioSinistro = funzioneRicorsiva(radice.figlioSinistro, valoreString, valoreInteger);
		} else {
			radice.figlioDestro = funzioneRicorsiva(radice.figlioDestro, valoreString, valoreInteger);
		}
		return radice;
	}
}
