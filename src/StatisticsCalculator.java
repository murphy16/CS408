public class StatisticsCalculator {
	
	private static final char[] WORD_SEPARATORS = {' '}; //what characters do we consider to break up words?
	private static final char[] BRACKETS_TO_COUNT = {'{','}'};
	private static final char[] SENTENCE_SEPARATORS = {'.','?','!'}; //what characters do we consider to break up sentences?
	private static final char[] SPACE_CHARACTERS = {' '};

	public int wordCount(String content) {
		if(content == null) return 0;
		int count = 0;
		boolean inWord = false;
		for (int i = 0; i < content.length(); i++) {
			if(isCharInSet(content.charAt(i), WORD_SEPARATORS)) {
				if(inWord) count++;
				inWord = false;
			}
			else {
				inWord = true;
			}
		}
		if(inWord) count++;
		return count;
	}
	
	public int bracketCount(String content) {
		if(content == null) return 0;
		int count = 0;
		for(int i = 0; i < content.length(); i++) {
			if(isCharInSet(content.charAt(i), BRACKETS_TO_COUNT)) {
				count++;
			}
		}
		return count;
	}

	public int sentenceCount(String content) {
		if(content == null) return 0;
		int count = 0;
		boolean inSentence = false;
		for (int i = 0; i < content.length(); i++) {
			if(isCharInSet(content.charAt(i), SENTENCE_SEPARATORS)) {
				if(inSentence) count++;
				inSentence = false;
			}
			else if (isAlpha(content.charAt(i))){
				inSentence = true;
			}
		}
		if(inSentence) count++;
		return count;
	}

	public int spacesCount(String content) {
		if(content == null) return 0;
		int count = 0;
		for (int i = 0; i < content.length(); i++) {
			if(isCharInSet(content.charAt(i), SPACE_CHARACTERS)) count++;
		}
		return count;
	}
	
	public int findCount(String content, String term) {
		return 0;
	}

	private boolean isAlpha(char ch) {
		if((ch>=65 && ch<=90) || (ch>=97 || ch<=122)) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isCharInSet(char ch, char[] set) {
		for (char setCh : set) {
			if (ch == setCh) return true;
		}
		return false;
	}

}