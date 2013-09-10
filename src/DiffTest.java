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
  public void testDiffSimple() {
    String test1 = "This is a String.";
    String test2 = "This is a different String.";

    assertEquals("different String.", diff.diff(test1, test2));
  }
}
