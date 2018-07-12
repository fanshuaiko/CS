package com.cs.services;

import java.util.List;

import com.cs.model.Order;

public interface IOrderService {
	/**
	 * 保存订单
	 * 
	 * @param order
	 *            订单实体
	 * @return
	 */
	Order save(Order order);

	/**
	 * 根据用户id查询当前用户的订单
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */

	List<Order> findByUserId(int userId);

}
