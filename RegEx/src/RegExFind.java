/**
 *
 * @author brittanyvacchiano
 */
import java.util.regex.*;

public class RegExFind
{
    //predefined character class
    public static String predefinedCharClass(String regex, String inputString)
    {
        if(regex.equals("\\d"))
        {
             if(inputString.matches(regex))
             {
                 System.out.println("\\d");
                 return "'"+ inputString + "' contains a digit";
             }
             else
             {
                 return "No match found";
             }
        }
        
        if(regex.equals("\\D"))
        {
            if(inputString.matches(regex))
            {
                System.out.println("\\D");
                return "'"+ inputString + "' does not contain a digit";
            }
            else
            {
                return "No match found";
            }
        }
        
        if(regex.equals("\\s"))
        {
            if(inputString.matches(regex))
            {
                System.out.println("\\s");
                return "'"+ inputString + "' contains whitespace character(s)";
            }
            else
            {
                return "No match found";
            }
        }
        
                
        if(regex.equals("\\S"))
        {
            if(inputString.matches(regex))
            {
                System.out.println("\\S");
                return "'"+ inputString + "' contains no whitespace character(s)";
            }
            else
            {
                return "No match found";
            }
        }
        
                
        if(regex.equals("\\w"))
        {
            if(inputString.matches(regex))
            {
                System.out.println("\\w");
                return "'"+ inputString + "' contains letter(s)";
            }
            else
            {
                return "No match found";
            }
        }
        
                
        if(regex.equals("\\W"))
        {
            if(inputString.matches(regex))
            {
                System.out.println("\\w");
                return "'"+ inputString + "' contains non-word character(s)";
            }
            else
            {
                return "No match found";
            }
        }
        
                
        if(regex.equals("."))
        {
            if(inputString.matches(regex))
            {
               System.out.println(".");
               return "'"+ inputString + "' contains any character";
            }
            else
            {
                return "No match found";
            }
        }
        return "Not valid regular expression for predefined character class";
    }
 
    
    public static void main(String[] args)
    {
        predefinedCharClass("\\d", "1");
        predefinedCharClass("\\D", "a");
        predefinedCharClass("\\s", " ");
        predefinedCharClass("\\S", "flskjfdksd");
        
    }
   
}
