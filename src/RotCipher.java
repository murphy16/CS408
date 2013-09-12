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
		SetKey(this.n);
	}
	
	public RotCipher()
	{
		RotCipher(13); // defaults to ROT13
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
					EncryptedContent.append((char)(((ContentChar - 'A') + nKey) % 26 + 'A'));
				else
					EncryptedContent.append((char)(((ContentChar - 'a') + nKey) % 26 + 'a'));
			}
			else
			{
				EncryptedContent.append(ContentChar);
			}
		}
		
		return EncryptedContent;
	}
	
	public void SetKey(int n)
	{
		nKey = this.n;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		SetKey(13);
		System.out.print(Encrypt("ABCDE"));
	}
}
