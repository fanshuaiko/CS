package com.cs.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.OrderItemRepository;
import com.cs.model.OrderItem;
import com.cs.services.IOrderItemService;
@Service
@Transactional
public class OrderItemServiceImpl implements IOrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Override
	public void save(OrderItem orderItem) {
		// TODO Auto-generated method stub
		orderItemRepository.save(orderItem);
	}

}
