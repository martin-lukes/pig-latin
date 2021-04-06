package org.lukes.piglatin;

/**
 * This interface imposes translatable words to Pig Latin. 
 * @author Martin Lukes
 *
 */
interface PigTranslatable {
	/**
	 * Translates underlying word to PigLatin
	 * @return translated word in PigLatin
	 */
	String translate();
}
