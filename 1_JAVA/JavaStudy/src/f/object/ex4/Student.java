package f.object.ex4;

//이름 나이 수학점수 영어점수 국어점수를 데이터로 가지고 있는 객체를 만들어라
//데이터는 직접 접근을 허용하지 않고 모두 간접적으로 set/get을 해줄 수 있도록작성해라
//모든 데이터를 매개변수로 받아 초기화하며 객체를 생성할 수 있는 생성자 작성





public class Student {
	private String name;
	private int age;
	private int math;
	private int eng;
	private int ko;
	
	//alt + shift + s (+r or o)
		
/////////////////////////////생성자/////////////////////////////	
	//public Student() {}
	
	public Student(String name, int age, int math, int eng, int ko) {
		super();
		this.name = name;
		this.age = age;
		this.math = math;
		this.eng = eng;
		this.ko = ko;
	}
/////////////////////////////method/////////////////////////////
	public double getEvg() {
		double evg = ((this.math + this.eng + this.ko) / 3.0);
		return evg;
	}
	
	public void printEvg() {
		System.out.println(this.getName() + "님의 평균 : " + this.getEvg());
	}
/////////////////////////////seter/////////////////////////////
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if(age < 1) {
			this.age = 1;
			return;
		}
		this.age = age;
	}
	
	public void setMath(int math) {
		if(math < 0) {
			this.math = 0;
			return;
		}
		this.math = math;
	}
	
	public void setEng(int eng) {
		if(eng < 0) {
			this.eng = 0;
			return;
		}
		this.eng = eng;
	}
	
	public void setKo(int ko) {
		if(ko < 0) {
			this.ko = 0;
			return;
		}
		this.ko = ko;
	}
/////////////////////////////geter/////////////////////////////
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getMath() {
		return this.math;
	}
	
	public int getEng() {
		return this.eng;
	}
	
	public int getKo() {
		return this.ko;
	}

}
