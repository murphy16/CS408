import static org.junit.Assert.*;

import org.junit.Test;


public class StatisticsCalculatorTest {

	public StatisticsCalculator statCalc = new StatisticsCalculator();
	
	@Test
	public void testWordCountSimple() {
		String test1 = "this is a string without any trip ups.";
		String test2 = "this is a string with less.";
		
		assertEquals(8, statCalc.wordCount(test1));
		assertEquals(6, statCalc.wordCount(test2));
	}
	
	@Test
	public void testWordCountEmptyString() {
		assertEquals(0, statCalc.wordCount(""));
	}
	
	@Test
	public void testWordCountSpecialCharacters() {
		String test1 = "This is a string with special.characters_which may cause problems";
		assertEquals(9 , statCalc.wordCount(test1));
	}
	
	@Test
	public void testWordCountMultipleSpaces() {
		String test = "This is a string with  multiple   spaces separating words        ";
		assertEquals(9, statCalc.wordCount(test));
	}
	
	@Test
	public void testWordCountLeadingSpace() {
		String test = "   this string has leading spaces.";
		assertEquals(5, statCalc.wordCount(test));
	}

}
