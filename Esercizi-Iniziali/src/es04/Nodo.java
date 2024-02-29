package es04;

public class Nodo {
	String valoreString;
	int valoreInteger;
	Nodo figlioSinistro, figlioDestro;

	public Nodo(String valoreString, int valoreInteger) {
		this.valoreString = valoreString;
		this.valoreInteger = valoreInteger;
		this.figlioSinistro = null;
		this.figlioDestro = null;
	}

	@Override
	public String toString() {
		return "Valore Stringa: " + valoreString + ", Valore Integer: " + valoreInteger;
	}
}
