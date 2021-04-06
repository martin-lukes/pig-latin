package org.lukes.piglatin;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PigLatinTranslator is dictionary from English to PigLatin. PigLatinTranslator 
 * replaces all whitespaces by single space.
 * @author Martin Lukes
 *
 */
public class PigLatinTranslator {
	public static final String HYPHEN = "-";
	
	public static final String SPACE = " ";
	
	public PigLatinTranslator() {
	}
	
	/**
	 * Translates English word, sentence or paragraph into PigLatin
	 * @param English text that is either word, sentence or paragraph
	 * @return PigLatin translation
	 */
	public String translate(String text) {
		if(text == null) {
			return null;
		}
		StringTokenizer tokenizer = new StringTokenizer(text);
		StringBuilder builder = new StringBuilder();
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			PigTranslatable translatable;
			if(HyphenWord.accepts(text)) {
				StringTokenizer hyphenTokenizer = new StringTokenizer(token, HYPHEN);
				List<AtomicWord> hyphenAtomicList = new ArrayList<>();
				while(hyphenTokenizer.hasMoreTokens()) {
					String hyphenToken = hyphenTokenizer.nextToken();
					AtomicWord atomicWord = getAtomicWord(hyphenToken);
					hyphenAtomicList.add(atomicWord);
				}
				translatable = new HyphenWord(hyphenAtomicList);
			} else {
				translatable = getAtomicWord(token);
			}
			String translation = translatable.translate();
			builder.append(translation);
			if(tokenizer.hasMoreElements()) {
				builder.append(SPACE);
			}
			
		}
		return builder.toString();
	}
	
	/**
	 * Returns atomic word for PigLatin, cannot handle complex non-atomic words.
	 * @param token text to be translated
	 * @return AtomicWord object
	 */
	public AtomicWord getAtomicWord(String token) {
		if(ConsonantWord.accepts(token)) {
			return new ConsonantWord(token);
		}
		if(VowelWord.accepts(token)) {
			return new VowelWord(token);
		}
		if(StableWord.accepts(token)) {
			return new StableWord(token);
		}
		throw new InvalidParameterException("Unexpected word");
	}
}
