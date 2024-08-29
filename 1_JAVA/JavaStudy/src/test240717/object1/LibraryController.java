package test240717.object1;

public class LibraryController {
	private Member mem = new Member();
	private Book[] bList = new Book[5];
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);

	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
		
	}
	
	public Member myInfo() {
		return mem;
	}
	
	public Book[] selectAll() {
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		Book[] matchBook = new Book[bList.length];
		for(int i = 0; i < bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				matchBook[i] = bList[i];
			}
		}
		return matchBook;
	}
	
	public int rentBook(int index) {
		
		int result = 0;
		
		if(bList[index] instanceof AniBook) {
			
			if(((AniBook)bList[index]).getAccessAge() > mem.getAge()) {
				result = 1;
			} else {
				result = 2;
			}
			
		} else if(bList[index] instanceof CookBook && ((CookBook)bList[index]).isCoupon() == true) {
			
			result = 3;
			int coupon = mem.getCouponCount() + 1;
			mem.setCouponCount(coupon);
			
		} else {
			result = 2;
		}
		return result;
	}
}
