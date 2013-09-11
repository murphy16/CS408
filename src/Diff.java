public class Diff {
  private static final int INDEX_NOT_FOUND = -1;
  private static final String EMPTY = "";

  public static String diff(String str1, String str2) {
    if (str1 == null) {
      return str2;
    }
    if (str2 == null) {
      return str1;
    }

    int at = indexOfDifference(str1, str2);
    if (at == INDEX_NOT_FOUND) {
      return EMPTY;
    }
    return str2.substring(at);
  }

  private static int indexOfDifference(String str1, String str2) {
    if (str1 == str2) {
      return INDEX_NOT_FOUND;
    }
    if (str1 == null || str2 == null) {
      return INDEX_NOT_FOUND;
    }

    int i;
    for (i = 0; i < str1.length() && i < str2.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        break;
      }
    }
    if (i < str1.length() || i < str2.length()) {
      return i;
    }
    return INDEX_NOT_FOUND;
  }
}
