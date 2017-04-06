package com.bonc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bonc.entities.XGoods;
import com.bonc.servies.XGoodsServices;

/**
* @author xujiangpeng 
* @E-mail:xujiangpeng@bonc.com
* @version 创建时间：2017年1月11日 上午11:52:53
*/

@Controller
public class XController {
	
	@Resource  
    private XGoodsServices goodsServices; 
	
	//@Resource  
	private XGoods xGoods;
	
	
	public XGoods getxGoods() {
		return xGoods;
	}
	public void setxGoods(XGoods xGoods) {
		this.xGoods = xGoods;
	}


	/**
	 * 主页面，输出Hello
	 */
	@RequestMapping("/")
	@ResponseBody
	public String Hello(){
		return "Hello";
	}
	
	
	/**
	 * 查询所有
	 * 遗留bug  第一次请求必须加上?currentPage=0
	 */
	@RequestMapping("/findAll")
	public ModelAndView findAll(int currentPage){
		ModelAndView mav = new ModelAndView("XGoods"); 
		List<XGoods> goods = goodsServices.findAll(currentPage);
		mav.addObject("goods",goods);
		return mav;
	}
	
	/**
	 * 添加商品
	 */
	@RequestMapping("/save")
	public ModelAndView save(XGoods xGoods){
		goodsServices.save(xGoods);
		return findAll(0);
	}
	
	/**
	 * 删除单个商品信息
	 */
	@RequestMapping("/delete")
	public ModelAndView delete(Integer goodID){
		goodsServices.delete(goodID);
		return findAll(0);
	}
	
	/**
	 * 更新单个商品信息
	 * 改进：可以用对象名.的形式进行参数的封装
	 */
	@RequestMapping("/xupdate")
	public ModelAndView xupdate(String goodName, Double
			goodPrice, int goodNumber, String goodInfo,Integer goodID){
		goodsServices.xupdate(goodName, goodPrice, goodNumber, goodInfo,goodID);
		//goodsServices.xupdate(xGoods);
		return findAll(0);
	}
	
	
	/**
	 * 通过ID查询
	 * @param goodID
	 * @return
	 */
	@RequestMapping("/findByGoodID")
	public ModelAndView findByGoodID(Integer goodID){//注意这里的形参，就是请求url需要的名称
		ModelAndView mav = new ModelAndView("update"); 
		mav.addObject("byGoodID",goodsServices.findByGoodID(goodID));
		return mav;
	}
	
	/**
	 * 通过名称查询(通过关键字)
	 * @param goodName
	 */
	@RequestMapping("/findByKey")
	public ModelAndView findByKey(String key,String xvalue){
		ModelAndView mav = new ModelAndView("XGoods");
		mav.addObject("goods",goodsServices.findByKey(key,xvalue));
		return mav;
	}
	
	
	
	@RequestMapping("/testjsp1")
	public String testjsp1(){
		System.out.println("testjsp1");
		return "test"; //这里的test指的是视图名称，所以不用responsebody.
	}
	
	@RequestMapping("/testjsp2")
	public ModelAndView testjsp2(){
		System.out.println("testjsp2");
		ModelAndView mav = new ModelAndView("test"); //和上面一样,指定响应视图
		mav.addObject("mes","xjp");
		return mav;
	}
	
	 
	      
}
