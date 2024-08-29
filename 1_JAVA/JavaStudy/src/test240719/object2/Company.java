package test240719.object2;

public class Company {

	public static void main(String[] args) {
		Employee[] e = {
			new	Secretary("Hilery", 1, "secretary", 800),
			new Sales("Clinten", 2, "sales", 1200)
		};
		System.out.println("name	" + "department	" + "salary");
		System.out.println("------------------------------------");
		for(Employee i : e) {
			System.out.println(i.getName() + "	" + i.getDepartment() + "	" + i.getSalary() + "	");
			
		}
		
		System.out.println("");
		System.out.println("인센티브 100 지급");

		for(Employee i : e) {
			if(i instanceof Secretary) {
				((Secretary) i).incenive(100);
			} else {
				((Sales) i).incenive(100);
			}
			System.out.println(i.getName() + "	" + i.getDepartment() + "	" + i.getSalary() + "	" + i.tax());
		}

	}

}
