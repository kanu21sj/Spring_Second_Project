package com.mega.mvc39;
//상품 위치 테이블에 대한 컨트롤 해주는 컨트롤러

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlController {
	@Autowired
	ProductLocationDAO dao;
	@RequestMapping("pl_insert.mega")
	
	public void insert(ProductLocationVO bag) throws Exception {
		dao.insert(bag);
		System.out.println("데이터 반환 성공");
		System.out.println(bag.pid);
		System.out.println(bag.platitude);
		System.out.println(bag.plongtitude);
	}
	
	
}
