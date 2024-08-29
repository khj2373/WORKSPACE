package test240729.object1;

import java.util.Comparator;

public class SortedLottery implements Comparator<Lottery>{

	
	@Override
	public int compare(Lottery o1, Lottery o2) {
		int num = o1.getName().compareTo(o2.getName());
		
		if(num == 0) {
			return o1.getPhone().compareTo(o2.getPhone());
		}
		
		//음수 : o1이 o2보다 작다
		//0 : 동일하다
		//양수 : o1이 o2보다 크다
		return num;
	}

	
}
