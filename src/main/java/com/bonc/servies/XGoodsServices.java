package com.bonc.servies;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.bonc.entities.XGoods;
import com.bonc.repository.XGoodsRepository;


/**
*
* @author xujiangpeng 
* @E-mail:xujiangpeng@bonc.com
* @version 创建时间：2017年1月12日 上午11:02:04
*/

@Service
public class XGoodsServices{
	
	
	@Resource
	private XGoodsRepository goodsRepository;
	
	
	@Transactional
	public List<XGoods> findAll(int currentPage){
		int maxPage = goodsRepository.findAll().size()/4;
		if( currentPage < 0){
			currentPage = 0;
		}
		if(currentPage > maxPage){
			currentPage = maxPage;
		}
		
		
		
		int pageSize = 4;
		PageRequest pageRequest = new PageRequest(currentPage, pageSize);
		Page<XGoods> page = goodsRepository.findAll(pageRequest);
		//new ModelAndView().addObject("currentPage",currentPage);
		//有时间考虑下，currentPage 为什么不需要手动放入？
		 
		return page.getContent();
	}
	
	
	
	@Transactional //事务绑定
	public void save(XGoods goods){
		goodsRepository.save(goods);
	}
	
	@Transactional
	public void delete(int id){
		goodsRepository.delete(id);
	}
	
	//public void update
	
	
	@Transactional
	public XGoods findByGoodID(Integer goodID){
		return goodsRepository.findByGoodID(goodID);
	}
	
	@Transactional
	public void xupdate(String goodName, 
			Double goodPrice, int goodNumber, String goodInfo,Integer goodID){
		//goodsRepository.saveAndFlush(goods);
		//goodsRepository.flush();
		
		goodsRepository.UpdateXGoods(goodName, 
				goodPrice, goodNumber,goodInfo,goodID);
	}
	
	
	/*@Transactional
	public void xupdate(XGoods xGoods) {
		goodsRepository.UpdateXGoods(xGoods);
	}*/
	


	public List<XGoods> findByKey(String key, String xvalue) {
		
		if("goodName".equals(key)){
			return goodsRepository.findByGoodName(xvalue);
		}
		
		if("goodPrice".equals(key)){
			return goodsRepository.findByGoodPrice(Double.valueOf(xvalue));
		}
		
		if("goodNumber".equals(key)){
			return goodsRepository.findByGoodNumber(Integer.valueOf(xvalue));
		}
		
		if("goodInfo".equals(key)){
			return goodsRepository.findByGoodInfo(xvalue);
		}
		
		return null;
	}



	


}
