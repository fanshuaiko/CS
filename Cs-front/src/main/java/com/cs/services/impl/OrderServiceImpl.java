package com.cs.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.OrderRepository;
import com.cs.model.Order;
import com.cs.services.IOrderService;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> findByUserId(int userId) {
		return orderRepository.findByUserId(userId);
	}

}
