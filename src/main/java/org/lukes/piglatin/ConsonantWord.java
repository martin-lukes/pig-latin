package org.lukes.piglatin;

/**
 * ConsonantWord is AtomicWord from Pig Latin that starts with Consonant
 * @author Martin Lukes
 *
 */
public class ConsonantWord implements AtomicWord{

	private static final String CONSONANT_SUFFIX = "ay";
	
	private String text;
	
	public ConsonantWord(String text) {
		this.text = text;
	}
	
	@Override
	public String translate() {
		StringBuilder builder = new StringBuilder();
		String lowText = text.toLowerCase();
		builder.append(lowText.substring(1, lowText.length()));
		builder.append(lowText.substring(0,1));
		builder.append(CONSONANT_SUFFIX);
		Finalizer finalizer = new Finalizer();
		return finalizer.translateFinal(text, builder.toString());
	}
	
	public static boolean accepts(String text) {
		if(text == null) {
			return false;
		}
		if(text.endsWith("ay")) {
			return false;
		}
		
		
		char startLetter = text.toLowerCase().charAt(0);
		if(startLetter == 'a' || startLetter == 'e' || startLetter == 'i' || startLetter == 'o' || startLetter == 'u') {
			return false;
		}
		return true;
	}
	
}
