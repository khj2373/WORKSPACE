package test240715.object1;

public class Student {
	private String name;
	private int classroom;
	private double javaScore;
	private double sqlScore;
	private double practiceScore;
	
	public Student() {
		
	}

	public Student(String name, int classroom, double javaScore, double sqlScore, double practiceScore) {
		super();
		this.name = name;
		this.classroom = classroom;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
		this.practiceScore = practiceScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public double getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(double javaScore) {
		this.javaScore = javaScore;
	}

	public double getSqlScore() {
		return sqlScore;
	}

	public void setSqlScore(double sqlScore) {
		this.sqlScore = sqlScore;
	}

	public double getPracticeScore() {
		return practiceScore;
	}

	public void setPracticeScore(double practiceScore) {
		this.practiceScore = practiceScore;
	}
	
	public String toString() {
		return this.classroom + "반 " + this.name + "학생 " + this.javaScore + "점 " + this.sqlScore + "점 " + this.practiceScore + "점";
	}
	
	public boolean isPassd() {
		if(this.javaScore >= 50 && this.sqlScore >= 50 && this.practiceScore >= 50 &&
				(this.javaScore + this.sqlScore + this.practiceScore)/3 >= 60) {
			return true;
		}
		return false;
	}
	
	public void reTest() {
		this.setJavaScore(Math.random()*101);
		this.setSqlScore(Math.random()*101);
		this.setPracticeScore(Math.random()*101);
		
//		this.javaScore = Math.random()*101;
//		this.sqlScore = Math.random()*101;
//		this.practiceScore = Math.random()*101;
	}

}
