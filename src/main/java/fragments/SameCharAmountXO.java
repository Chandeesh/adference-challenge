package fragments;

public class SameCharAmountXO {
	
	public boolean sameXOAmount(String str) {
		str = str.toLowerCase();
		int charXCount = 0;
		int charOCount = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'x') {
				charXCount+=1;
			}
			if(str.charAt(i) == 'o') {
				charOCount+=1;
			}
		}
		return charXCount == charOCount;
	}
	
}
