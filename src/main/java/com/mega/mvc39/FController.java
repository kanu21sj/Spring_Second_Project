package com.mega.mvc39;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//편의 시설 테이블에 대한 컨트롤 해주는 컨트롤러
@Controller
public class FController {
	@Autowired
	FacilityDAO dao; //dao싱글톤 객체 생성
	
	@RequestMapping("f_insert.mega")
	public void insert(FacilityVO bag) throws Exception {
		dao.insert(bag);
		System.out.println("데이터 반환 성공");
		System.out.println(bag.fid);
		System.out.println(bag.flatitude);
		System.out.println(bag.flongtitude);
		System.out.println(bag.ftype);
	}
	
	@RequestMapping("f_delete.mega")
	public void delete(String fid) {
		dao.delete(fid);
	}
	/*
	@RequestMapping("f_read.mega")
	
	public void read(String f_id, FacilityDAO db) {
		
	}*/
	
}
