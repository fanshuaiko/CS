package com.cs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs.model.Order;

/**
 * 订单仓库
 * 
 * @author fan 创建时间：2018年7月12日
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	/**
	 * 查询订单 根据用户id
	 * 
	 * @param userId
	 * @return
	 */
	List<Order> findByUserId(int userId);

}
