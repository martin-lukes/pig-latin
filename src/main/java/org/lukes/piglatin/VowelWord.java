package org.lukes.piglatin;

/**
 * VowelWord is AtomicWord from Pig Latin that starts with Vowel.
 * Y by English definition is never vowel if it starts word.
 * @author Martin Lukes
 *
 */
public class VowelWord implements AtomicWord{
	private static final String VOWEL_SUFFIX = "way";
	
	private String text;
	
	public VowelWord(String text) {
		this.text = text;
	}
	
	@Override
	public String translate() {
		StringBuilder builder = new StringBuilder();
		String lowText = text.toLowerCase();
		builder.append(lowText);
		builder.append(VOWEL_SUFFIX);
		Finalizer finalizer = new Finalizer();
		return finalizer.translateFinal(text, builder.toString());
	}
	
	public static boolean accepts(String text) {
		if(text == null) {
			return false;
		}
		if(StableWord.accepts(text)) {
			return false;
		}
		
		char startLetter = text.toLowerCase().charAt(0);
		if(startLetter == 'a' || startLetter == 'e' || startLetter == 'i' || startLetter == 'o' || startLetter == 'u') {
			return true;
		}
		return false;
	}
}
