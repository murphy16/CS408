import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RotCipherTest
{
	private RotCipher rCipher;

	@Before
	public void SetUp() throws Exception
	{
		rCipher = new RotCipher();
	}

	/* Encryption Tests */

	@Test
	public void ExpectResult()
	{
		SetKey(13); // set to ROT13

		String input = "ABCDE";
		String expectedResult = "NOPQR";

		assertEquals(expectResult, rCipher.encrypt(input));
	}

	@Test
	public void LengthTest()
	{
		String test1 = "ABCDE"; // 5
		String test2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 26

		assertEquals(5, rCipher.encrypt(test1).length());
		assertEquals(26, rCipher.encrypt(test2).length());
	}

	@Test
	public void NonLetterCharacters()
	{
		SetKey(13); // set to ROT13

		String input = "ABCDE1";
		String expectedResult = "NOPQR1";

		assertEquals(expectResult, rCipher.encrypt(input));		
	}

	@Test
	public void ChangeKeyExpectedResult()
	{
		SetKey(14); // set to ROT14

		String input = "ABCDE";
		String expectedResult = "OPQRS";

		assertEquals(expectResult, rCipher.encrypt(input));		
	}
	/* Encryption Tests */

	@Test
	public void ExpectResult()
	{
		SetKey(13); // set to ROT13

		String input = "NOPQR";
		String expectedResult = "ABCDE";

		assertEquals(expectResult, rCipher.decrypt(input));
	}

	@Test
	public void LengthTest()
	{
		String test1 = "ABCDE"; // 5
		String test2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 26

		assertEquals(5, rCipher.decrypt(test1).length());
		assertEquals(26, rCipher.decrypt(test2).length());
	}

	@Test
	public void NonLetterCharacters()
	{
		SetKey(13); // set to ROT13

		String input = "NOPQR1";
		String expectedResult = "ABCDE1";

		assertEquals(expectResult, rCipher.decrypt(input));		
	}

	@Test
	public void ChangeKeyExpectedResult()
	{
		SetKey(14); // set to ROT14

		String input = "OPQRS";
		String expectedResult = "ABCDE";

		assertEquals(expectResult, rCipher.decrypt(input));
	}

	/* General Tests */

	@Test
	public void EncryptDecrypt()
	{
		String text = "ABCDE";

		assertEquals(text, rCipher.decrypt(rCipher.encrypt(text)));
	}
}
