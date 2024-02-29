package es03;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VerificaPIN {

	String pin;

	public VerificaPIN(String pin) {
		this.pin = pin;
	}

	public boolean Validazione() {
		String pinRegex = "^(\\d{4}|\\d{6})$"; // definisco la mia regex: 
		Pattern pattern = Pattern.compile(pinRegex);
		Matcher matcher = pattern.matcher(pin);
		return matcher.matches();
	}

	@Override
	public String toString() {
		if (Validazione()) {
			return "Il PIN " + pin + " è valido";
		} else {
			return "Il PIN '" + pin + "' non è valido";
		}
	}
}

/*
 * spiegazione regex: "^" e "$" definiscono che la corrispondenza deve iniziare all'inizio e terminare alla fine della stringa
 *                    "\\d" corrisponde al numero di cifre nelle {} che seguono
 *                    "|" è un separatore che si può tradurre con "oppure"
 */
