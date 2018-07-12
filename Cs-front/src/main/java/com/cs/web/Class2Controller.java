package com.cs.web;
/**
 * 商品二级分类Controller
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.model.Class2;
import com.cs.model.Commodity;
import com.cs.services.ICommodityService;
import com.cs.services.impl.Class2ServiceImpl;

@Controller
@RequestMapping("/Class2Controller")
public class Class2Controller {
	@Autowired
	private Class2ServiceImpl class2ServiceImpl;
	@Autowired
	private ICommodityService commodityServiceImpl;
	/**
	 * 查询二级分类下的商品
	 * @param model
	 * @return
	 */
	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<Class2> list = class2ServiceImpl.findAll();
		model.addAttribute("list", list);
		return "productList";
	}
	/**
	 * 根据一级分类的Id来查询该一级分类下的二级分类，并查询该一级分类下的所有商品
	 * @param class1Id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findByClass1Id")
	public String findByClass1Id(int class1Id,Model model) {
		List<Class2> list = class2ServiceImpl.findByClass1Id(class1Id);
		model.addAttribute("list", list);
		List<Commodity> CommodityList = commodityServiceImpl.findByClass1Id(class1Id);
		model.addAttribute("CommodityList", CommodityList);
		return "productList";
	}
}
