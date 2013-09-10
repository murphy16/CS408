public class StatisticsCalculator {
	
	public int wordCount(String content) {
		int count = 0;
		boolean inWord = false;
		for (int i = 0; i < content.length(); i++) {
			if(content.charAt(i) == ' ') { //what characters do we consider to break up words?
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
		int count = 0;
		for(int i = 0; i < content.length(); i++) {
			if(content.charAt(i) == '}' || content.charAt(i) == '{') {
				count++;
			}
		}
		return count;
	}

}