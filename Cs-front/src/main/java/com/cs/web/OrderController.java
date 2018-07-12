package com.cs.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.model.Cart;
import com.cs.model.CartItem;
import com.cs.model.Order;
import com.cs.model.OrderItem;
import com.cs.model.User;
import com.cs.services.IOrderItemService;
import com.cs.services.IOrderService;

/**
 * 订单管理Controller
 * 
 * @author fan 创建时间：2018年7月12日
 */

@Controller
@RequestMapping("/OrderController")
public class OrderController {

	@Autowired
	private IOrderService orderServiceImpl;
	@Autowired
	private IOrderItemService orderItemService;

	// 生成订单的方法
	@RequestMapping("/submitOrder")
	public String submitOrder(HttpSession session, Model model) {
		Object cartObj = session.getAttribute("cart");
		Cart cart = (Cart) cartObj;
		Object userObj = session.getAttribute("currentUser");
		User currentUser = (User) userObj;
		System.out.println("==========================" + currentUser);
		if (cart == null || currentUser == null) {
			return "order";
		} else {
			Order order = new Order();
			order.setUserId(currentUser.getUserId());
			order.setTotalPrice(cart.getTotal());
			order.setUserName(currentUser.getUserName());
			order.setUserAddress(currentUser.getUserAddress());
			order.setUserTel(currentUser.getUserTel());
			// 设置订单的状态
			order.setState(1); // 1:未付款.
			// 设置订单时间
			order.setCreateTime(new Date());
			Order reOrder = orderServiceImpl.save(order);// 返回保存后的Order，目的是得到保存到数据库的OrderId，复制给orderItem
			for (CartItem cartItem : cart.getCartItems()) {
				// 订单项的信息从购物项获得的.
				OrderItem orderItem = new OrderItem();
				orderItem.setCount(cartItem.getCount());
				orderItem.setTotalPrice(cartItem.getSubtotal());
				orderItem.setCommodityId(cartItem.getCommodity().getCommodityId());
				orderItem.setOrderId(reOrder.getOrderId());
				orderItemService.save(orderItem);
			}
//			 清空购物车:
//			 cart.clearCart();
			model.addAttribute("order", order);
			return "order";
		}
	}

	// 查询我的订单:
	@RequestMapping("/findByUid")
	public String findByUid(HttpSession session, Model model) {
		
		// 获得用户的id.
		User currentUser = (User) session.getAttribute("currentUser");
		System.out.println("***********" + currentUser);
		// 获得用户的id
		Integer userId = currentUser.getUserId();
		List<Order> orderList = orderServiceImpl.findByUserId(userId);
		List<Order> li = new ArrayList<>();
		for (Order order : orderList) {
			int state = order.getState();
			if (state == 1) {
				order.setStateDescription("未付款");
				li.add(order);
			} else if (state == 2) {
				order.setStateDescription("已付款");
				li.add(order);
			} else {
				li.add(order);
			}
		}
		model.addAttribute("orderList", li);
		return "orderList";
	}
}
