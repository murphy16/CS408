import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StatisticsCalculatorTest {

	private StatisticsCalculator statCalc;
	
	@Before
	public void setUp() throws Exception {
		statCalc = new StatisticsCalculator();
		}
	
	/** WORD COUNT TESTS **/
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

	@Test
	public void testWordCountOnlySpaces() {
		String test = "          ";
		assertEquals(0, statCalc.wordCount(test));
	}

	@Test
	public void testWordCountNullInput() {
		assertEquals(0, statCalc.wordCount(null));
	}

	/** BRACKET COUNT TESTS **/
	@Test
	public void testBracketCountEven() {
		String test = "This is a string with {brackets}. There are {four}.";
		assertEquals(4, statCalc.bracketCount(test));
	}

	@Test
	public void testBracketCountOdd() {
		String test = "This {string} has an odd number of brackets }";
		assertEquals(3, statCalc.bracketCount(test));
	}

	@Test
	public void testBracketCountEmptyString() {
		String test = "";
		assertEquals(0, statCalc.bracketCount(test));
	}

	@Test
	public void testBracketCountNoBrackets() {
		String test = "this string has no brackets! At least no curly ones []()";
		assertEquals(0, statCalc.bracketCount(test));
	}

	@Test
	public void testBracketNullInput() {
		assertEquals(0, statCalc.bracketCount(null));
	}

	/** SENTENCE COUNT TESTS **/
	@Test
	public void testSentenceCountOneSentence() {
		String test = "This is a single sentence.";
		assertEquals(1, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountMultipleSentences() {
		String test = "This is one sentence. This is another sentence.";
		assertEquals(2, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountRepeatingPeriods() {
		String test = "This sentence has multiple periods....Here is another.";
		assertEquals(2, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountEmptyString() {
		String test = "";
		assertEquals(0, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountLeadingPeriod() {
		String test = ". Why does this string have a leading period. No one knows.";
		assertEquals(2, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountQuestionMark() {
		String test = "Is this a question? This is an answer.";
		assertEquals(2, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountExclamationMark() {
		String test = "This is exciting! Not really...";
		assertEquals(2, statCalc.sentenceCount(test));
	}

	@Test
	public void testSentenceCountNullInput() {
		assertEquals(0, statCalc.sentenceCount(null));
	}

	/** SPACE COUNT TESTS **/
	@Test
	public void testSpacesCountEmptyString() {
		String test = "";
		assertEquals(0, statCalc.spacesCount(test));
	}

	@Test
	public void testSpacesCountNoSpaces() {
		String test = "thisisastringwithnospaces....butithasotherstuff";
		assertEquals(0, statCalc.spacesCount(test));
	}

	@Test
	public void testSpacesCountNormalString() {
		String test = "This string has spaces. It's pretty regular";
		assertEquals(6, statCalc.spacesCount(test));
	}

	@Test
	public void testSpacesCountNullInput() {
		assertEquals(0, statCalc.spacesCount(null));
	}

	/**FIND COUNT TESTS **/
	@Test
	public void testFindCountNotFound() {
		String test = "This string doesn't have the search term we are looking for.";
		String term = "This isn't found";
		assertEquals(0, statCalc.findCount(test, term));
	}

	@Test
	public void testFindCountNoString() {
		String test = "";
		String term = "no string? no problem.";
		assertEquals(0, statCalc.findCount(test, term));
	}

	@Test
	public void testFindCountNoTerm() {
		String test = "this string has words in it.";
		String term = "";
		assertEquals(0, statCalc.findCount(test, term));
	}
}
