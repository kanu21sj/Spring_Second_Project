package com.mega.mvc39;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //독립적 기능을 수행하기 위한 모듈
public class RuserDAO {
	
	@Autowired //myBatis싱글톤 주소를 주입!!
	SqlSessionTemplate my; //SqlSessionTemplate 사용할 수 있도록 객체 생성

//	회원가입	
	public void insert(RuserVO bag) throws Exception {
//		회원가입시 브라우저에서 입력한 정보를 서버로 보내기 위한 메서드
		my.insert("ruser.insert", bag);
	}
	
//	ID 중복확인
	public int idCheck(String id) {
//	회원가입시 id 중복 체크를 하기 위한 메서드
//	int타입으로 캐스팅(중복 O = 1, 중복 X = 0)
		return my.selectOne("ruser.idcheck", id);
	}

//	로그인
	public RuserVO login(RuserVO vo) {
//	컨트롤러로부터 받은 id, pw값이 vo와 동일할 경우 로그인 허용
		return my.selectOne("ruser.login", vo);	
	}

//	회원 정보 업데이트
	public void update(RuserVO bag) throws Exception{
		my.update("ruser.update", bag);
	}
	
//	회원 정보 삭제
	public int delete(RuserVO bag) throws Exception{
		return my.delete("ruser.delete", bag);
	}
	
//	회원 정보 검색
	public RuserVO select(RuserVO bag) {
		return my.selectOne("ruser.select", bag);
	}
	
	public RuserVO checkBasket(String id) {
//	메인으로 돌아가게 되면 추천 매물 보여지는 것이 유지될 수 있도록 하는 메서드
		return my.selectOne("ruser.checkbasket", id);
	}
}
