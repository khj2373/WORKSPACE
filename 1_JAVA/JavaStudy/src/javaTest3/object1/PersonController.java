package javaTest3.object1;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int count = 0;
		int[] pCnt = new int[2];
		for(Student i : s) {
			if(i == null) {
				break;
			}
			count++;
		}
		pCnt[0] = count;
		count = 0;
		
		for(Employee i : e) {
			if(i == null) {
				break;
			}
			count++;
		}
		pCnt[1] = count;
		count = 0;
		return pCnt;
	}
	
	public void insertStudent(String name, int age, double height,
			double weight, int grade, String major) {
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		Student[] printS = s;
		return printS;
	}
	
	public void insertEmployee(String name, int age, double height,
			double weight, int salary, String dept) {
		for(int i = 0; i < e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				break;
			}
		}
		
	}
	
	public Employee[] printEmployee() {
		Employee[] printE = e;
		return printE;
	}
}
