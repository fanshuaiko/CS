package com.cs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs.model.OrderItem;
/**
 * 
 * @author fan
 * 创建时间：2018年7月12日
 */
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

}
