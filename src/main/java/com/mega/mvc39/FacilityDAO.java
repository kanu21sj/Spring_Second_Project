package com.mega.mvc39;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class FacilityDAO {
	// 관리자만 넣을 수 있음
	@Autowired
	SqlSessionTemplate my; //마이바티스 싱글톤객체 생성
	
	public void insert(FacilityVO bag) throws Exception {
		my.insert("facility.insert", bag);
	}

	public void delete(String fid) {
		my.delete("facility.delete",fid);
	}
	/*
	public ArrayList read(String f_id) {
		ArrayList list = new ArrayList();
		
		
		return list;
	}*/
}
