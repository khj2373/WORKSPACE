package test240724.object2;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}

	public String afterToken(String str) {
		String newStr = "";
		StringTokenizer stn = new StringTokenizer(str);
		
		while(stn.hasMoreTokens()) {
			newStr += stn.nextToken();
		}
		return newStr;
	}
	
	public String firstCap(String input) {
		String output = "";
//		for(int i = 0; i < input.length(); i++) {
//			output += (i == 0 ? (input.charAt(i) + "").toUpperCase() : input.charAt(i));
//		}
		
		output = input.substring(0, 1).toUpperCase() + input.substring(1);
		return output;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		
//		for(int i = 0; i < input.length(); i++) {
//			if(input.charAt(i) == one) {
//				count++;
//			}
//		}
		
		for(char c : input.toCharArray()) {
			if(c == one) {
				count++;
			}
		}
		return count;
	}
}
