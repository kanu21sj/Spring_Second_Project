package com.mega.mvc39;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨트롤러 선언
public class ProductController {// 입력값을 받아서 처리해주는 컨트롤러
	
	@Autowired
	ProductDAO dao;
	// 받아주는 기능 설정, 싱글톤으로 생성 후 하나의 주소값을 호출하여 계속 사용가능
	@RequestMapping("insert")
	// 브라우저에서 입력된 값을 가상주소 insert로 보내주면 아래를 실행
	public void insert(ProductVO productVO) throws Exception {// 입력받은 값은 ProductVO타입이고 bag이라는 변수를 사용해서 찍어 줄 수 있다.
		System.out.println(productVO);
		// 각각의 입력받은 값 확인 productVO를 toString으로 오버라이딩(재정의)해서 입력값을 찍을 수 있다.
		dao.insert(productVO); // ProductDAO class의 insert 메서드 실행
	}
	
	@RequestMapping("select")
	
	public void select(ProductVO productVO, HttpSession session) {
		// 세션을 사용하기 위해서 HttpSession을 임포트 시킨다.
		System.out.println("입력받은 번호는 : " + productVO.contact);
		List<ProductVO> list = dao.read(productVO);
		if(list != null) {
			System.out.println("해당 전화번호 확인");
			session.setAttribute("userCon", list);
			session.setAttribute("contact", productVO.contact);
		} else {
			System.out.println("해당 전화번호 없음.");
		}
	}
	
	@RequestMapping("pdetail")
	
	public void pdetail(ProductVO productVO, Model model) {
		System.out.println("입력받은 매물 번호는 " + productVO.pnum);
		ProductVO productVO2 = dao.pdetail(productVO);
		String pic = productVO2.getRoomimg();
		System.out.println(pic);
		String pic2 = pic.replace("1", "2");
		productVO2.setRoomimg2(pic2);
		System.out.println(pic2);
		model.addAttribute("productVO2", productVO2);
	}
	
	@RequestMapping("update")
	
	public void update(ProductVO bag) {
		System.out.println("수정할 data는 : " + bag);
		dao.update(bag);
	}
	
	@RequestMapping("update2")
	
	public void update2(ProductVO bag) {
		System.out.println("수정할 data는 : " + bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete")
	
	public void delete(ProductVO bag) {
		System.out.println("삭제하려는 상품 번호는 : " + bag.pnum); // 입력받은 상품번호
		dao.delete(bag); // DAO에 있는 delete 실행 DAO는 맵퍼파일에서 delete 실행
	}
	
	@RequestMapping("delete2")
	
	public void delete2(ProductVO bag) {
		System.out.println("삭제하려는 상품 번호는 : " + bag.pnum); // 입력받은 상품번호
		dao.delete(bag); // DAO에 있는 delete 실행 DAO는 맵퍼파일에서 delete 실행
	}
	

}
	