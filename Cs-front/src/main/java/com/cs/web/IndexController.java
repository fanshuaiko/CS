package com.cs.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.model.Class1;
import com.cs.model.Commodity;
import com.cs.services.IClass1Service;
import com.cs.services.ICommodityService;
@Controller
@RequestMapping("/IndexController")
public class IndexController {

	@Autowired
	private IClass1Service iClass1Service;
	@Autowired
	private ICommodityService iCommodityService;
/**
 * 查询所有的一级分类和最新的10条商品
 * 并转到主页面
 * @param model
 * @param session
 * @return
 */
	@GetMapping("/index")
	public String index(Model model,HttpSession session) {
		Iterable<Class1> list1 = iClass1Service.findAll();
		List<Commodity> list2 = iCommodityService.findLastTen();
		session.setAttribute("list1", list1);
		model.addAttribute("list2", list2);
		return "index2";
	}
}
