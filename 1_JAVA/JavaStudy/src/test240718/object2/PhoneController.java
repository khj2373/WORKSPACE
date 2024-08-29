package test240718.object2;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] phone = new Phone[2];
		phone[0] = new GalaxyNote9();
		phone[1] = new V40();
		
		String[] phones = new String[2];
		
		for(int i = 0; i < phone.length; i++) {
			if(phone[i] instanceof GalaxyNote9) {
				phones[i] = ((GalaxyNote9)phone[i]).printInformation();
			} else {
				phones[i] = ((V40)phone[i]).printInformation();
			}
		}
		return phones;
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

}
