package com.bonc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* @author xujiangpeng 
* @E-mail:xujiangpeng@bonc.com
* @version 创建时间：2017年1月11日 上午11:23:02
*/

@Entity
@Table(name="xgoods")
public class XGoods {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
	private Integer goodID;
	
	private String goodName;
	private Double goodPrice;
	private Integer goodNumber; //如果是int 就不能添加空数据。Integer也不行，以后处理。
	private String goodInfo;
	
	
	public Integer getGoodID() {
		return goodID;
	}
	public void setGoodID(Integer goodID) {
		this.goodID = goodID;
	}
	
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public Integer getGoodNumber() {
		return goodNumber;
	}
	public void setGoodNumber(Integer goodNumber) {
		this.goodNumber = goodNumber;
	}
	public String getGoodInfo() {
		return goodInfo;
	}
	public void setGoodInfo(String goodInfo) {
		this.goodInfo = goodInfo;
	}
	
}
