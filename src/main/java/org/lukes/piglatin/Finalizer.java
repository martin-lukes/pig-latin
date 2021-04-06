package org.lukes.piglatin;


import java.util.Set;
import java.util.TreeSet;

/**
 * Finalizer class ensure that each word that will pass firstOnePhase will have 
 * correct capitalization and punctuation
 * @author Martin Lukes
 *
 */
public class Finalizer { 
	
	private static Set<String> punctuationCharSet;
	
	static {
		punctuationCharSet = new TreeSet<>();
		punctuationCharSet.add(".");
		punctuationCharSet.add("'");
		punctuationCharSet.add("’");
		punctuationCharSet.add(",");
		punctuationCharSet.add("!");
		punctuationCharSet.add("?");
		punctuationCharSet.add(",");
		punctuationCharSet.add("\'");
		punctuationCharSet.add("\"");
		punctuationCharSet.add(";");
		punctuationCharSet.add(":");
		punctuationCharSet.add("[");
		punctuationCharSet.add("]");
		punctuationCharSet.add(")");
		punctuationCharSet.add("(");
		punctuationCharSet.add("{");
		punctuationCharSet.add("}");
	}
	
	public Finalizer() {
	}
	
	/**
	 * Translation to final form
	 * @param origin original form of String
	 * @param phase1Product semi-translated String, eg. prior fixing punctuation and capitalization
	 * @return
	 */
	public String translateFinal(String origin, String phase1Product) {
		String capitelizedString = capitalize(origin, phase1Product);
		String finalString = movePunctuation(origin, capitelizedString);
		return finalString;
	}

	/**
	 * Fix Capitalization
	 * @param origin original form of String
	 * @param phase1Product semi-translated String, eg. prior fixing punctuation and capitalization
	 * @return
	 */
	private String capitalize(String origin, String phase1Product) {
		if (origin == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < origin.length(); i++) {
			char originalCharAtI = origin.charAt(i);
			if ((int) originalCharAtI >= (int) ('A') && (int) originalCharAtI <= (int) ('Z')) {
				builder.append(Character.toUpperCase(phase1Product.charAt(i)));
			} else {
				builder.append(phase1Product.charAt(i));
			}
		}
		for (int i = origin.length(); i < phase1Product.length(); i++) {
			builder.append(phase1Product.charAt(i));
		}
		return builder.toString();
	}

	/**
	 * Fix Punctuation
	 * @param origin original form of String
	 * @param phase1Product semi-translated String, eg. prior fixing punctuation and capitalization
	 * @return
	 */
	private String movePunctuation(String originText, String capitalizedText) {
		String capitalizedDepunctuatedText = capitalizedText;
		for(String ch : punctuationCharSet) {
			capitalizedDepunctuatedText = capitalizedDepunctuatedText.replace(ch, "");
		}
		if(capitalizedDepunctuatedText.equals(capitalizedText)) {
			return capitalizedText;
		}
		String originReverse = new StringBuilder(originText).reverse().toString();
		String capitalizedDepunctuatedTextReverse = new StringBuilder(capitalizedDepunctuatedText).reverse().toString();
		
		StringBuilder builder = new StringBuilder();
		//move punctuation
		int pointerCapitalized = 0;
		for(int pointerOrigin = 0 ; pointerOrigin < originText.length(); pointerOrigin++) {
			char originCharAtI = originReverse.charAt(pointerOrigin);
			if(punctuationCharSet.contains(Character.toString(originCharAtI))) {
				builder.append(originCharAtI);
			} else {
				builder.append(capitalizedDepunctuatedTextReverse.charAt(pointerCapitalized));
				pointerCapitalized++;
			}
		}
		//append remaining of capitalizedText because of suffixes ay, way, ...
		for(; pointerCapitalized < capitalizedDepunctuatedText.length(); pointerCapitalized++) {
			builder.append(capitalizedDepunctuatedTextReverse.charAt(pointerCapitalized));
		}
		
		return builder.reverse().toString();
	}

}
