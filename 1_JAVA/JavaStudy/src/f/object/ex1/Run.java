package f.object.ex1;

/*
 *package
 *클래스간의 공간적 충돌이나 접근방법의 출돌을 막기 위해
 *저장위치를 구분하여 명확하게 접근할 수 있도록 해주는 것
 *보통 네이밍 방법은 회사 도메인을 역으로 입력한다
 *https://www.kh.com 일 때
 *com.kh.팀명(또는 프로젝트명) 
 */


//public(<-접근제한자) class 클래스명 {
//		//필드
//		//메소드
//}

//보통 Run이라고 생성하는 class는 객체생성을 위한 class가 아니라 main문을 통해 프로그램 실행을 위한 클래스다.
public class Run {
	
	/*
	 * 객체지향 언어 : "객체"를 "지향"하는 언어로 "객체중심"으로 돌아간다
	 * 
	 * 1. 객체 : 현실세계에서 독립적(목적이 있고 가치가 있는 것)으로 존재하는 모든 것을 의미
	 * 			현실세계에서는 객체들간의 상호작용으로 돌아감
	 * 
	 * 2. 객체지향 프로그램 : 현실세계의 객체간의 상호작용 ->프로그래밍을 통해서 가상세계로 구현하는 가장 효과적인 방법
	 * 
	 * 3. 구현하고자 하는 프로그램상 필요한 객체들을 만들기 위해서(즉, 생성하기 위해서)
	 * 		: 클래스라는 설계도가 먼저 필요하다. (클래스> 각 객체들의 속성(데이터)들을 담아낼 그릇같은 존재)
	 * 
	 * 4. 추상화 과정
	 * 1) 내가 구현하고자 하는 프로그램에서 필요한 객체들을 생각해 볼 것
	 * 2) 그 객체들의 공통적인 속성, 기들들을 추출할 것
	 * 3) 추출한 것들을 가지고 내가 구현하고자 하는 프로그램에 "실질적인 목적"에 맞춰 불필요한 속성, 기능 제거
	 * 4) 최종적으로 추려진 속성들을 어떤 자료형으로, 어떤 변수명으로 사용할 것인지 정의
	 * 
	 * ex) 학생 관리 프로그랭
	 * 
	 * 학생관련 객체(~~님, ~~님...)
	 * 공통적인 속성 및 기능(이름, 나이, 주소, 전화번호, 키, 몸무게, 머리색, 발사이즈 먹는다, 잔다...)
	 * 학생 "인적사항"을 관리하는 프로그램 : 이름, 나이, 주소, 전화번호, 반...
	 * 학생 "성적"을 관리하는 프로그램 : 이름, 반, 과목별 점수...
	 * 학생 "건강"을 관리하는 프로그램 : 이름, 반, 키, 몸무게, 먹는다, 잔다...
	 * 이름 : String name;
	 * 나이 : int age
	 * 키 : double height;
	 * 
	 * 5. 추상화한 객체를 프로그램에 적용
	 * 1) "변수"만으로 프로그램을 한다
	 * 변수 : 하나의 자료형으로 하나의 값만 보관할 수 있음
	 * 김현준이라는 훈련생 객체 하나 만들기 -> String name1 = "김현준"; int age = 24; double height = 181.0;
	 * 김현우이라는 훈련생 객체 하나 만들기 -> String name2 = "김현우"; int age = 21; double height = 175.0;
	 * 
	 * 2) 배열로 프로그래밍 한다면
	 * 배열 : 하나의 자료형으로 여러개의 값들을 보관할 수 있음
	 * 이름을 보관하는 배열 String[] name = {"김현준", "김현우"..}
	 * 나이를 보관하는 배열 int[] age = {24, 21...}
	 * 
	 * 3) 그래서 나온 개념 -> 구조체
	 * 구조체 : 여러개의 자료형의 여러개의 값들을 보관할 수 있다
	 * String 값도 보관하고 int 값도 보관하고 동시에 double 값도 보관하는 자료형을 직접만들다고 생각 -> 나만의 자료형
	 * Struct human{
	 * 	String name;
	 * 	int age;
	 * 	double height;
	 * }
	 * 
	 * ->자바에서는 구조체 개념을 좀 더 확장해서 클래스라는 개념을 만들었다.
	 */

	/*
	 * 캡슐화 : 추상화를 통해서 정의된 속성들과 기능들을 하나로 묶어 관리하는 기법
	 * 		클래스에서 가장 중요한 목적인 "데이터의 접근제한(정보은닉)"을 원칙으로
	 * 		외부로부터 "데이터 접근을 막고"
	 * 		대신에 "데이터를 간접적으로 처리(값을 변경하거나, 가져오는 것등)"할 메소드들을 클래스 내부에 작성하여 관리하는 것
	 * 		다양한 기능을 묶어 하나의 큰 기능을 만들어 주는 것
	 */
	
	public static void main(String[] args) {
		//객체를 생성할 때
		//class명 객체이름(참조변수);
//		Student kim;
//		kim = new Student();
		Student kim = new Student();
		Student choi = new Student();
		
		kim.name = "김현준";
		kim.age = 24;
		
		choi.name = "최지원";
		choi.age = 20;
		
		kim.print();
		choi.print();

	}

}