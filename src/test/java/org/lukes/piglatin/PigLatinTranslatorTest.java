package org.lukes.piglatin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PigLatinTranslatorTest {

	private static String ERROR_MESSAGE = "Strings doesn't match";
	
	private PigLatinTranslator translator;
	
	@BeforeEach
	public void setUp() throws Exception {
		translator = new PigLatinTranslator();
	}
	
	
	@Test
	public void consonantTest() {
		String result = translator.translate("Hello");
		assertEquals("Ellohay", result, ERROR_MESSAGE);
	}
	
	@Test
	public void vowelTest() {
		String result = translator.translate("apple");		
		assertEquals("appleway", result, ERROR_MESSAGE);
	}
	
	@Test
	public void wayTest() {
		String result = translator.translate("stairway");		
		assertEquals("stairway", result, ERROR_MESSAGE);
	}

	
	@Test
	public void punctuationTest() {
		String result = translator.translate("can’t");		
		assertEquals("antca’y", result, ERROR_MESSAGE);
	}
	
	@Test
	public void punctuationTest2() {
		String result = translator.translate("end.");		
		assertEquals("endway.", result, ERROR_MESSAGE);
	}
	
	@Test
	public void hyphenTest() {
		String result = translator.translate("this-thing");		
		assertEquals("histay-hingtay", result, ERROR_MESSAGE);
	}
	
	@Test
	public void capitalizationTest1() {
		String result = translator.translate("Beach");		
		assertEquals("Eachbay", result, ERROR_MESSAGE);
	}
	
	@Test
	public void capitalizationTest2() {
		String result = translator.translate("McCloud");		
		assertEquals("CcLoudmay", result, ERROR_MESSAGE);
	}
	
	
	@Test
	public void testTwoWords() {
		String result = translator.translate("stairway this-thing");		
		assertEquals("stairway histay-hingtay", result, ERROR_MESSAGE);
	}
	
	@Test
	public void testNull() {
		String result = translator.translate(null);		
		assertEquals(null, result, ERROR_MESSAGE);
	}
	
	@Test
	public void testEmpty() {
		String result = translator.translate("");		
		assertEquals("", result, ERROR_MESSAGE);
	}
	
	
}
