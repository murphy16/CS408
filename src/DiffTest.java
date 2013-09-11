import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiffTest {

  private Diff diff;

  @Before
  public void setUp() throws Exception {
    diff = new Diff();
  }

  @Test
  public void testDiffSimpleDiff() {
    String test1 = "This is a String.";
    String test2 = "This is a different String.";

    assertEquals("different String.", diff.diff(test1, test2));
  }

  @Test
  public void testDiffNoDiff() {
    String test1 = "This is a String.";
    String test2 = "This is a String.";

    assertEquals("", diff.diff(test1, test2));
  }

  @Test
  public void testDiffEmptyStr1() {
    String test1 = "";
    String test2 = "This is a different String.";

    assertEquals("This is a different String.", diff.diff(test1, test2));
  }

  @Test
  public void testDiffEmptyStr2() {
    String test1 = "This is a String.";
    String test2 = "";

    assertEquals("This is a String.", diff.diff(test1, test2));
  }

  @Test
  public void testDiffNullStr1() {
    String test1 = null;
    String test2 = "This is a different String.";

    assertEquals("This is a different String.", diff.diff(test1, test2));
  }

  @Test
  public void testDiffNullStr2() {
    String test1 = "This is a String.";
    String test2 = null;

    assertEquals("This is a String.", diff.diff(test1, test2));
  }

  @Test
  public void testDiffNullBoth() {
    String test1 = null;
    String test2 = null;

    assertEquals("", diff.diff(test1, test2));
  }

}
