package test240710.object2;

public class Run {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setEmpNo(100);
		emp.setEmpName("홀길동");
		emp.setDebt("영업부");
		emp.setJob("과장");
		emp.setAge(25);
		emp.setGender('남');
		emp.setSalary(250000000);
		emp.setBonusPoint(0.05);
		emp.setPhone("010-1234-1234");
		emp.setAddress("abc123@abc.com");
		
		System.out.println(emp.getEmpNo());

	}

}
