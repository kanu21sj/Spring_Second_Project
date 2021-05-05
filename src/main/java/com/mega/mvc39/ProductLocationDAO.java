package com.mega.mvc39;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductLocationDAO {
	
	@Autowired
	SqlSessionTemplate my;
	public void insert(ProductLocationVO bag) throws Exception {
		my.insert("productLocation.insert", bag);
	}
	
	public ProductVO select(ProductVO bag) {
		return my.selectOne("ruser.select", bag);
	}
	
}
