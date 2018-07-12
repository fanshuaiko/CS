package com.cs.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.model.Cart;
import com.cs.model.CartItem;
import com.cs.model.Commodity;
import com.cs.services.ICommodityService;
/**
 * 购物车Controller
 * @author fan
 * 创建时间：2018年7月12日
 */
@Controller
@RequestMapping("/CartController")
public class CartController {

	@Autowired
	private ICommodityService commodityService;

	// 将购物项添加到购物车:执行的方法
	@PostMapping("/addCart")
	public String addCart(int commodityId, int comodityCount,HttpSession session) {
		Object cartObj =  session.getAttribute("cart");
		if (cartObj == null) {
			cartObj = new Cart();
			session.setAttribute("cart", cartObj);
		}
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		// 设置数量:
		cartItem.setCount(comodityCount);
		// 根据pid进行查询商品:
		Commodity commodity = commodityService.findByCommodityId(commodityId);
		// 设置商品:
		cartItem.setCommodity(commodity);
		// 将购物项添加到购物车.
		// 购物车应该存在session中.
//		Cart cart = getCart();
		((Cart) cartObj).addCart(cartItem);
		session.setAttribute("cart", (Cart) cartObj);
		return "myCart";
	}

	@RequestMapping("/myCart")
	public String intoMycart() {
	
		return "myCart";
	}
	
	
	// 清空购物车的执行的方法:
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session) {
		Object cartObj =  session.getAttribute("cart");
		if (cartObj == null) {
			cartObj = new Cart();
			session.setAttribute("cart", cartObj);
		}
		// 获得购物车对象.
//		Cart cart = getCart();
		// 调用购物车中清空方法.
		((Cart) cartObj).clearCart();
		return "myCart";
	}

	// 从购物车中移除购物项的方法:
	@GetMapping("/removeCart")
	public String removeCart(int commodityId,HttpSession session) {
		// 获得购物车对象
		Object cartObj =  session.getAttribute("cart");
		if (cartObj == null) {
			cartObj = new Cart();
			session.setAttribute("cart", cartObj);
		}
//		Cart cart = getCart();
		// 调用购物车中移除的方法:
		((Cart) cartObj).removeCart(commodityId);
		// 返回页面:
		return "myCart";
	}

}