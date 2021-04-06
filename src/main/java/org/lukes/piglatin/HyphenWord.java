package org.lukes.piglatin;

import java.util.Iterator;
import java.util.List;

/**
 * HyphenWord is word from Pig Latin that can be reduced to multiple 
 * AtomicWord objects connected with hyphens
 * @author Martin Lukes
 *
 */
public class HyphenWord implements PigTranslatable{
	
	private List<AtomicWord> words;
	
	public HyphenWord(List<AtomicWord> words) {
		this.words = words;
	}
	
	public static boolean accepts(String text) {
		if(text == null) {
			return false;
		}
		if(text.contains("-")) {
			return true;
		}
		return false;
	}

	@Override
	public String translate() {
		StringBuilder builder = new StringBuilder();
		Iterator<AtomicWord> wordIterator = words.iterator();
		while(wordIterator.hasNext()) {
			AtomicWord word = wordIterator.next();
			String translation = word.translate();
			builder.append(translation);
			if(wordIterator.hasNext()) {
				builder.append("-");
			}
		}
		return builder.toString();
	}
	
	
}
