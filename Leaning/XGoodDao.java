package com.bonc.dao;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bonc.entities.XGoods;

/**
* @author xujiangpeng 
* @E-mail:xujiangpeng@bonc.com
* @version 创建时间：2017年1月11日 上午11:44:59
*/


@Repository
public class XGoodDao{
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public XGoods findByName(String name){
		 
		 //注意这里指向的是数据库，不是关系映射类
		 String sql = "select * from xgoods where good_name = ?";
		 RowMapper<XGoods> rowMapper = new BeanPropertyRowMapper<XGoods>(XGoods.class);
		 XGoods goods = jdbcTemplate.queryForObject(sql, new Object[]{name},rowMapper);
		 return goods;
		 
	 }
	 
}
