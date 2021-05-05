package com.mega.mvc39;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//클라이언트의 요청에 대한 데이터를 받아 전달하기 쉽게 데이터를 가공하는 역할
@Controller //어노테이션, 표시 
public class RuserController {
	// 1) 스프링 프레임워크에 해당 클래스를 Controller역할을 하도록 등록
	// 2) 싱글톤 객체로 생성

	@Autowired 
	RuserDAO dao; 
	//@Autowired 사용하여 RuserDAO객체 사용하기 위해 의존성 주입
	//객체 생성이(new) 필요없이 객체 자동으로 생성

	@RequestMapping("ruser_login")
	public void insert(RuserVO bag) throws Exception {
		dao.insert(bag);
	}
	
	//get은 Select기능에 사용, 캐시가 남음, 보안측면이 떨어지나
	//전송속도가 우수하고 파라미터가 url에 노출됨
	
	//post 방식의 경우 패킷안에 숨겨져서 전송됨
	//CUD에 사용되며, 캐시가 남지않아 보안적인 면에서 우수
	//Request body에 데이터가 들어가기 때문에 
	//파라미터가 노출되지 않음.
	
	@RequestMapping(value="idcheck", method = RequestMethod.POST) 
	//http 전달 방식 post, 가상주소명 idcheck
	@ResponseBody 	
	//메서드의 return값을 HTTP reponse의 body에 담는 역할
	public String idcheck(String id) throws Exception {
		
		// int타입으로 캐스팅하여 id가 존재하면 1, 존재하지 않으면 0
		int result = dao.idCheck(id);
		
		if (result != 0) { // 0 = 아이디 중복 x, 1 = 아이디 중복 yes
			return "fail"; // 중복아이디 존재	
		} else {
			return "success"; //중복아이디 없음
		}
	}


	@Autowired 
	ProductDAO dao2; //productDAO 싱글톤 호출
	
	// 넘어갈 페이지가 다르다는 점을 Spring에 알려줘야 함 : 반환값 String 타입
	// RuserVO bag을 파라메터로 받고, session으로 로그인 연결, Model로 view page로 이동 
	// model = request.setAttribute와 같은 역할
	@RequestMapping("main")
	public String login(RuserVO bag, HttpSession session, Model model) {
		RuserVO vo = dao.login(bag); //dao, login메서드 사용 vo 변수로 정의 
		
		if (vo != null) {
		// 회원가입 정보(거래형태, 방개수, 희망세권)와 매칭된 매물 추천을 위한 알고리즘
		// 로그인 후 views 페이지에서 추천 매물 표출
			
		// 매칭된 결과는 상품정보가 담긴 디비에서 매칭된 정보를 가져오고
		// dao2 recommend 메서드(ProductDAO)에 vo를 담아 mapper로 전송
		// productMapper에서 추천 매물(회원가입 정보 = 상품 정보) sql문 dao로 보냄
		// ProductDAO recommend 함수에서 매칭되는 상품 정보를 가져옴
			
			session.setAttribute("userid", vo.getUserid()); 
			//로그인 성공할 경우 userid 값으로 세션 연결
			List<ProductVO> list = dao2.recommend(vo);
			// view 페이지에 매칭된 상품 정보 결과를 전송
			model.addAttribute("list", list); 
			return "main"; // 로그인 성공할 경우 main 페이지로 이동		
			} else { 
				return "signup"; // 로그인 실패할 경우 회원가입 페이지로 이동
			}
		}

//	메인 페이지 클릭시 매물 추천 유지
	@RequestMapping("checkBasket")
	@ResponseBody  //메서드의 return값을 HTTP reponse의 body에 담는 역할
	
	//	RequestParam
	//	String id = request.getParameter("id"); out.print(id); 동일	
	//	main 페이지 userid1 값을 가져옴	
	public List<ProductVO> checkBasket(@RequestParam(value="userid1") String userid) {
		
		// Ruser checkbasket 메서드의 userid에 해당하는 
		// 방타입, 개수, 땡세권 값을 bag변수에 담음
		RuserVO bag = dao.checkBasket(userid);
		
		// ProductVO recommend 메서드 bag값을 list타입의 list 변수에 담아
		// RuserVO, ProductVO의 조건이 매칭되는 
		// 상품에 대한 정보를 가져옴
		List<ProductVO> list = dao2.recommend(bag);
		
		// 방 이미지가 담긴 리스트를 반환값으로 넘겨줌
		return list;
	}
	
//	회원 정보 업데이트
	@RequestMapping("ruser_update")
	public void update(RuserVO bag) throws Exception {
		dao.update(bag);
	}
	
//	회원 정보 검색
	@RequestMapping("ruser_select")
	public void select(RuserVO ruservo, Model model) {
		RuserVO vo = dao.select(ruservo);
		model.addAttribute("vo2", vo); // 검색결과 views에 데이터 리턴	
	}
	
//	회원 정보 삭제
	@RequestMapping("ruser_delete")
	public String delete(RuserVO bag, HttpSession session) throws Exception {
//		아이디 삭제시 결과값이 1일경우 아이디 삭제, 0일 경우 삭제 x
		int result = dao.delete(bag);
		if(result == 1) {
//			아이디 탈퇴가 성공할 경우 세션끊음
			session.invalidate();
//			탈퇴될 경우 메인페이지로 재요청
			return "redirect:main.jsp";
		}else {
//			탈퇴가 실패할 경우 다시 삭제 브라우저 페이지로 이동
			return "redirect:ruser_delete.jsp";
		}
	}
}