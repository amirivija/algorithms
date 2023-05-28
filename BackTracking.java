class Solution {


	// Given the dialpad telephone keypad, give a telephone number, identify all possible
	// combinations of words that can apply for that telephone number
	List<String> result;
	String telephoneNumber;
	char[][] keyMap;
    int N;
    
	public List<String> letterCombinations( String telephoneNumber) {
	    N = telephoneNumber.length();
        result = new ArrayList<String>();
	    this.telephoneNumber = telephoneNumber;
	    keyMap = new char[][] {{'a', 'b', 'c'}, 
                               {'d', 'e', 'f'},
                               {'g', 'h', 'i'},
                               {'j', 'k', 'l'},
                               {'m', 'n', 'o'},
                               {'p', 'q', 'r', 's'},
                               {'t', 'u', 'v'},
                               {'w', 'x', 'y', 'z'}
                              };
	    StringBuffer sb = new StringBuffer();
	    backTrack(0, sb);
	    return result;
}

	private void backTrack(int currentIndex, StringBuffer currentString) {

		if(currentIndex == N) {
			// reached the last number
            if(currentString.length() == 0 ) {
                
            } else {
			    result.add(currentString.toString());
            }
            return;
		}

		for(char c: keyMap[Character.getNumericValue(telephoneNumber.charAt(currentIndex)) - 2]) {
			currentString.append(c);
			backTrack(currentIndex + 1, currentString);
			currentString.deleteCharAt(currentString.length() - 1);
		}
}
}

