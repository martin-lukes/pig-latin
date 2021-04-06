package org.lukes.piglatin;

/**
 * StableWord is AtomicWord from Pig Latin. It has translation equal to origin word.
 * @author Martin Lukes
 *
 */
public class StableWord implements AtomicWord{
		
		private String text;
		
		public StableWord(String text) {
			this.text = text;
		}
		
		@Override
		public String translate() {
			return text;
		}
		
		public static boolean accepts(String text) {
			if(text == null) {
				return false;
			}
			if(text.endsWith("way")) {
				return true;
			}
			return false;
		}
}
