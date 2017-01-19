package com.bonc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bonc.entities.XGoods;

/**
* @author xujiangpeng 
* @E-mail:xujiangpeng@bonc.com
* @version 创建时间：2017年1月12日 下午5:41:45
*/
public interface XGoodsRepository extends JpaRepository<XGoods, Integer>{
	
	XGoods findByGoodID(Integer goodID);
	
	List<XGoods> findByGoodName(String xvalue);

	List<XGoods> findByGoodPrice(Double xvalue);

	List<XGoods> findByGoodNumber(Integer xvalue);

	List<XGoods> findByGoodInfo(String xvalue);
	
	//void setXGoods(XGoods goods);
	
	@Modifying
	@Query("update XGoods x set x.goodName=?, x.goodPrice=?, "
			+ "x.goodNumber=?, x.goodInfo=? where x.goodID=?")
	void UpdateXGoods(String goodName, 
			Double goodPrice, int goodNumber, String goodInfo,Integer goodID);

	//void UpdateXGoods(XGoods xGoods);

	/**
	 * 如果是继承Repository接口的话，可以自己去写方法
	 * 1/ 查询方法 以 get | find | read 开头.
	 * 2/ 涉及查询条件时，条件的属性用条件关键字连接，要注意的是条件属性以首字母大写。
	 */
	
	
	/**
	 * 如何编写JPQL语句， 
	 * Hibernate  -- HQL语句.
	 * JPQL 语句 和HQL语句是类似的.
	 * 
	 * x@Query("from Cat where catName=:cn")
	 * public Cat findMyCatName(@Param("cn")String catName);
	 * 如果一致的话，就不需要@Param("cn")来声明了
	*/
}
