package test240723.object1;

public class CharacterController {

	public CharacterController() {
		super();
	}
	
	public int couponAlpha(String s) throws CharCheckException{
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(s.charAt(i) == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			} else if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				count++;
			}
		}
		
		return count;
	}

}
