import java.util.*;
import java.lang.*;
import java.io.*;

public class RotCipher
{
	/* Private Properties */
	
	private int nKey = 13; // ROT-n, n number of digits to rotate
	
	/* Ctors */
	
	public RotCipher(int n)
	{
		SetKey(n);
	}
	
	public RotCipher()
	{
		this(13); // defaults to ROT13
	}
	
	/* Public Methods */
	
	public String Encrypt(String Content)
	{
		String EncryptedContent = "";
		
		for (int i = 0; i < Content.length(); i++)
		{
			char ContentChar = Content.charAt(i);
			
			if (Character.isLetter(ContentChar))
			{
    			if (Character.isUpperCase(ContentChar))
					EncryptedContent += (char)(((ContentChar - 'A') + nKey) % 26 + 'A');
				else
					EncryptedContent += (char)(((ContentChar - 'a') + nKey) % 26 + 'a');
			}
			else
			{
				EncryptedContent += ContentChar;
			}
		}
		
		return EncryptedContent;
	}
	
	public static String Decrypt(String EncryptedContent)
	{
		String DecryptedContent = "";
		
		for (int i = 0; i < EncryptedContent.length(); i++)
		{
			char ContentChar = EncryptedContent.charAt(i);
			
			if (Character.isLetter(ContentChar))
			{
    			if (Character.isUpperCase(ContentChar))
					DecryptedContent += (char)(((ContentChar - 'A') - nKey) % 26 + 'A');
				else
					DecryptedContent += (char)(((ContentChar - 'a') - nKey) % 26 + 'a');
			}
			else
			{
				DecryptedContent += ContentChar;
			}
		}
		
		return DecryptedContent;
	}

	public void SetKey(int n)
	{
		if (this.nKey != n)
			this.nKey = n;
	}
}
