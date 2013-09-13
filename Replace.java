import java.lang.String;

public class Replace 
{
  public boolean matchCase;
  public boolean wholeWord;
  public String text;
  
  public Replace (boolean _case, boolean _word, String _text)
  {
    matchCase = _case;
    wholeWord = _word;
    text = _text;
  }
  
  public void resetText(String newText)
  {
    text = newText;
  }
  
  public String replaceFull(String find, String replace)
  {
    if(text.isEmpty())
    {
      String errmsg = "No text to search!";
      return errmsg;
    }
    if(find.isEmpty() || replace.isEmpty())
    {
      String errmsg = "Empty string entered!";
      return errmsg;
    }
    if(matchCase)
    {
      if(wholeWord)
      {
        //Same case, whole word
        String words[] = text.split(" ");
        for(int i = 0; i < words.length; i ++)
        {
          if(words[i].equals(find)) words[i] = replace;
        }
        String text1 = new String();
        for(int i = 0; i < words.length - 1; i ++)
        {
          text1 = text1.concat(words[i]);
          text1 = text1.concat(" ");
        }
        text1 = text1.concat(words[words.length - 1]);
        if(!text1.equals(text))
        {
          text = text1;
          return text;
        }
        else
        {
          String errmsg = "String not found!";
          return errmsg;
        }
      }
      else
      {
        //Same case, not whole word
        String text1 = text.replace(find, replace);
        if(!text1.equals(text))
        {
          text = text1;
          return text;
        }
        else
        {
          String errmsg = "String not found!";
          return errmsg;
        }
      }   
    }
    else
    {
      if(wholeWord)
      {
        //Not same case, whole word
        return text;
      }
      else
      {
        //Not same case, not whole word
        return text;
      }   
    }
  }
  
  public String replaceSelection(String find, String replace, int start, int end)
  {
    if(text.isEmpty())
    {
      String errmsg = "No text to search!";
      return errmsg;
    }
    if(find.isEmpty() || replace.isEmpty())
    {
      String errmsg = "Empty string entered!";
      return errmsg;
    }
    
    String select = text.substring(start, end);
    String unselect = text.substring(end);
    
    if(matchCase)
    {
      if(wholeWord)
      {
        //Same case, whole word
        //Same case, whole word
        String words[] = select.split(" ");
        for(int i = 0; i < words.length; i ++)
        {
          if(words[i].equals(find)) words[i] = replace;
        }
        select = new String();
        for(int i = 0; i < words.length - 1; i ++)
        {
          select = select.concat(words[i]);
          select = select.concat(" ");
        }
        select = select.concat(words[words.length - 1]);
      }
      else
      {
        //Same case, not whole word
        select = select.replace(find, replace);
      }   
    }
    else
    {
      if(wholeWord)
      {
        //Not same case, whole word
      }
      else
      {
        //Not same case, not whole word
      }   
    }
    String text1 = select.concat(unselect);
    if(!text1.equals(text))
    {
      text = text1;
      return text;
    }
    else
    {
      String errmsg = "String not found!";
      return errmsg;
    }
  }
}
