package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

//Bean에 Class를 등록하는 방법으로 @Component를 클래스에 부여해주면 된다
//@Controller -> @Component + Controller객체가 가질 수 있는 예외처리등이 추가된 어노테이션
//@RestController
@CrossOrigin
@Controller
public class MemberController {
	
	
	/* 
	 * @Autowired
	 * 의존성 주입시 사용하는 어노테이션
	 * 클래스 내에서 필요한 객체를 직접생성하지 않고 spring컨테이너가 관리하는 객체(Bean)를 주입받아 사용할 수 있게 해준다
	 * + 필드주입방식/생성자주입방식
	 */
	//@Autowired
	//private MemberService memberService;
	
	/*
	 * private MemberService MmeberService = new MemberServiceImpl();
	 * 기존 객체 생성방식
	 * 객체간 결합도가 높아짐(소스코드 수정이 일어날 경우 하나하나 전부 다 바꿔줘야 한다)
	 * 서비스가 동시에 매우 많은 요청이 될 경우 그만큼 객체가 생성된다
	 * 
	 * DI(Dependency Injection) - 의존성 주입
	 * 코드 결합도가 낮아지고 코드를 분리할 수 있음
	 * 
	 * 필드주입방식
	 * 스프링 컨테이너가 객체를 생성한 후, @Autowired 어노테이션이 붙은 필드에 의존성을 주입한다.
	 * 
	 * 생성자주입방식
	 * 스프링 컨테이너가 객체를 생성할 때 생성자를 통해서 필요한 의존성을 주입한다
	 * 
	 * 필드주입방식 -> 생성자주입방식 : 주입시점의 차이로 인해 객체가 완전히 초기화된 상태로 사용할 수 있음을 보장하고
	 * 테스트 기능성과 유지보수성이 좋아진다
	 */
	private final MemberService memberService;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.memberService = memberService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}

	/*
	 * 1. Spring에서 클라이언트가 보낸 정보를 받는 방법
	 * HttpServletRequest를 활용해서 전달값을 가져옴
	 * 메소드의 매개변수로 HttpServletRequest를 작성해주면
	 * Spring컨테이너가 해당 메소드를 호출할 때 자동으로 객체생성해서 매개변수로 주입해준다
	 */
//	@RequestMapping("login.me")
//	public String loginMember(HttpServletRequest request) {
//		String id = request.getParameter("userId");
//		String pwd = request.getParameter("userPwd");
//		
//		System.out.println(id);
//		System.out.println(pwd);
//		return null;
//	}
	
	/*
	 * 2. @RequestParam 어노테이션을 이용하는 방법
	 * request.getParameter(key)로 value를 추출하는 역할을 대신하는 어노테이션
	 * value속성의 값으로 jsp에서 작성했던 name속성값을 담으면 알아서 해당 매개변수로 받아올 수 있다
	 * 만약, 요청할때의 값이 비어있는 경우 defaultValue 속성으로 기본값을 지정할 수 있다
	 * 
	 * default와 같은 설정을 사용하지 않고 요청받은 key값과 매개변수명을 동일하게 해준다면
	 * @RequestParam을 생략할 수 있다
	 */
//	@RequestMapping("login.me")
//	public String loginMember(@RequestParam(value="userId", defaultValue="test222") String id, String userPwd) {
//		
//		System.out.println(id);
//		System.out.println(userPwd);
//		return "main";
//	}
	
	/*
	 * 3. 커맨드 객체 방식
	 * 
	 * 해당 메소드의 매개변수로
	 * 요청시 전달값을 담고자하는 클래스 타입으로 만들어준 뒤
	 * 전달되는 key값과 매개변수 클래스의 필드명을 동일하게 작성해주면
	 * 객체를 생성하여 값을 담아서 전달해준다.
	 */
//	@RequestMapping("login.me")
//	public String loginMember(Member m) {
//		
//		Member loginMember = memberService.loginMember(m);
//
//		if(loginMember == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//		}
//		return "main";
//	}
	
	// 요청처리 후에 응답데이터를 담고 응답페이지로 포워딩 또는 url재요청 처리하는 방법
	//1. 스프링에서 제공하는 Model객체를 이용해서 return해주기
	
	/*
	 * 1. 스프링에서 제공하는 Model객체를 이용하는 방법
	 * 포워딩할 응답으로 전달하고자 하는 데이터를 맵형식(k,v)로 담을 수 있는 영역
	 *  
	 */
	
//	public String loginMember(Member m, HttpSession session, Model model) {
//		
//		Member loginMember = memberService.loginMember(m);
//
//		if(loginMember == null) {
//			System.out.println("로그인 실패");
//			
//			model.addAttribute("errorMsg", "로그인 실패"); //requestScope에 에러문구를 담는다.
//			// /WEB-INF/views/common/errorPage.jsp
//			return "/common/errorPage";
//		} else {
//			session.setAttribute("loginUser", loginMember);
//			System.out.println("로그인 성공");
//			
//			return "redirect:/";
//		}
//		//return "main";
//	}
	
	//2. 스프링에서 제공하는 ModelAndView객체를 이용하면 데이터를 담고 리턴형식까지 지정할 수 있음
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, HttpSession session, ModelAndView mv) {

//		if(loginMember == null) {
//			System.out.println("로그인 실패");
//			
//			mv.addObject("errorMsg", "로그인 실패"); //requestScope에 에러문구를 담는다.
//			// /WEB-INF/views/common/errorPage.jsp
//			//return "/common/errorPage";
//			mv.setViewName("common/errorPage");
//		} else {
//			session.setAttribute("loginUser", loginMember);
//			System.out.println("로그인 성공");
//			
//			//return "redirect:/";
//			mv.setViewName("redirect:/");
//		}
		//return "main";
		
		/*
		 * 암호화 후
		 * Member m의 id -> 사용자가 입력한 아이디
		 * Member m의 pwd -> 사용자가 입력한 pwd(평문)
		 */
		Member loginMember = memberService.loginMember(m);
		
		//loginMember pwd -> 암호화 된 비밀번호
		//bcryptPasswordEncoder -> matches(평문, 암호문)메소드를 이용하여 내부적으로 복호화 작업 후 비교가 이루어짐
		//두 구문이 일치하면 true 일치하지 않으면 false반환
		
		if(loginMember == null) {
			mv.addObject("errorMsg", "일치하는 아이디를 찾을 수 없습니다.");
			mv.setViewName("common/errorPage");
		} else if(!bcryptPasswordEncoder.matches(m.getUserPwd(), loginMember.getUserPwd())){
			mv.addObject("errorMsg", "비밀번호가 일치하지 않습니다.");
			mv.setViewName("common/errorPage");
		} else {
			session.setAttribute("loginUser", loginMember);
			
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping("myPage.me")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("update.me")
	public String updateMember(Member m, HttpSession session, Model model) {
		int result = memberService.updateMember(m);
		
		if(result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			return "redirect:/myPage.me";
		} else {
			model.addAttribute("errorPage", "회원정보 수정 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(Member m, HttpSession session) {

		//Member loginMember = memberService.loginMember(m);
		String encPwd = ((Member)session.getAttribute("loginUser")).getUserPwd();
		
		int result = 0;
		
		if(bcryptPasswordEncoder.matches(m.getUserPwd(), encPwd)) {
			result = memberService.deleteMember(m);
		} else {
			session.setAttribute("alertMsg", "비밀번호를 다시 확인해주세요.");
			return "redirect:/myPage.me";
		}
		
		if(result > 0) {
			session.removeAttribute("loginUser");
			session.setAttribute("alertMsg", "회원 탈퇴에 성공하였습니다.");
			return "redirect:/";
		} else {
			session.setAttribute("alertMsg", "회원 탈퇴 실패");
			return "redirect:/myPage.me";
		}
		//비밀번호를 암호화된 비밀번와 비교
		
		//일치하면 탈퇴처리 -> session에서 로그인 정보 제거 -> 메인페이지
		
		//일치하지 않으면 -> alertMsg : 비밀번호 다시 입력 - > 마이페이지
	}
	
	@RequestMapping("logout.me")
	//@GetMapping("logout.me")
	public String logoutMember(HttpSession session) {
		//session.invalidate();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	/*
	 * ajax 요청에 대한 응답을 위한 controller에는 @ResponseBody 어노테이션을 작성해줘야 한다
	 * 기본적인 세팅이 jsp응답으로 되어있기 때문에 @ResponseBody를 작성해주면
	 * 반환값을 http응답 객체에 직접 작성하겠다 라는 의미를 가지고 있다
	 */
	@ResponseBody
	@RequestMapping("idCheck.me")
	public String idCheck(String checkId) {
		int result = memberService.idCheck(checkId);
		
		if(result > 0) { //id 이미 존재
			return "NNNNN";
		} else {
			return "NNNNY";
		}
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m, HttpSession session, Model model) {
		System.out.println(m);
		
		/*
		 * 인코딩 필터를 적용해줬기 때문에 한글을 잘 받을 수 있음
		 * 
		 * age같은 경우 int로 필드를 구성할 경우 빈 문자열이 전달되면 형변환 과정에서 400에러가 발생한다
		 * 400에러는 보통 요청하는 데이터와 이를 받아주는 데이터가 일치하지 않아서 많이 발생한다.
		 * 
		 * 비밀번호가 사용자의 입력 그대로 전달된다.(평문)
		 * Bcrypt 방식을 이용해서 암호화 작업 후 저장을 하겠다.
		 * -> 스프링 시큐리티에서 제공하는 모듈을 이용 (pom.xml 라이브러리 추가 후  Bean에 객체등록)
		 */
		
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd);
		
		int result = memberService.insertMember(m);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}
}
