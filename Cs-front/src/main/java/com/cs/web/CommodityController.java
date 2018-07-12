package com.cs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.model.Class2;
import com.cs.model.Comment;
import com.cs.model.Commodity;
import com.cs.services.IClass2Service;
import com.cs.services.ICommentService;
import com.cs.services.ICommodityService;
/**
 * 商品管理Controller
 * @author fan
 * 创建时间：2018年7月12日
 */
@Controller
@RequestMapping("/CommodityController")
public class CommodityController {

	@Autowired
	private ICommodityService commodityServiceImpl;
	@Autowired
	private ICommentService commentServiceImpl;
	@Autowired
	private IClass2Service iClass2Service;
/**
 * 根据二级分类的id来分页查询所有该二级分类下的所有商品
 * @param page 查询第几页
 * @param size 每页显示多少条记录
 * @param class2Id 二级分类的id
 * @param model
 * @return
 */
	@RequestMapping("/pageByClass2Id")
	public String pageByClass2Id(int page,int size,int class2Id,Model model) {
		 Page<Commodity> pg = commodityServiceImpl.pageByClass2Id(page, size, class2Id);
		 List<Class2> class2List = iClass2Service.findAll();
		 model.addAttribute("class2List", class2List);
		 model.addAttribute("pg",pg);
		 model.addAttribute("class2Id", class2Id);
		return "productList2";
	}
	/**
	 * 根据商品名称查找商品
	 * @param commodityName 商品名称
	 * @param modle
	 * @return
	 */
	
	@RequestMapping("/findByName")
	public String findByName(String commodityName,Model modle) {
		Commodity commodity = commodityServiceImpl.findByName(commodityName);
		modle.addAttribute(commodity);
		return "";
	}
	/**
	 * 根据商品id查询商品和该商品的评论
	 * @param id 商品id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findById")
	public String findById(int id,Model model) {
		Commodity commodity = commodityServiceImpl.findByCommodityId(id);
		List<Comment> commentList = commentServiceImpl.findByCommodityId(id);
		model.addAttribute("commodity", commodity);
		model.addAttribute(commentList);
		return "product";
	}
}
