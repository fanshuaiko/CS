package com.cs.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cs.model.Commodity;

public interface ICommodityService {
	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	List<Commodity> findAll();

	/**
	 * 查询最新的10条商品
	 * 
	 * @return
	 */
	List<Commodity> findLastTen();

	/**
	 * 根据二级分类分页查询商品
	 * 
	 * @param page
	 *            要查询第几页
	 * @param size
	 *            每页显示条数
	 * @param class2Id
	 *            二级分类id
	 * @return
	 */
	Page<Commodity> pageByClass2Id(int page, int size, int class2Id);

	/**
	 * 根据商品名模糊查询商品
	 * 
	 * @param commodityName
	 *            商品名
	 * @return
	 */
	Commodity findByName(String commodityName);

	/**
	 * 根据商品id查询商品
	 * 
	 * @param id
	 *            商品id
	 * @return
	 */
	Commodity findByCommodityId(int id);

	/**
	 * 根据一级分类分页查询商品
	 * 
	 * @param page
	 *            要查询第几页
	 * @param size
	 *            每页显示条数
	 * @param class2Id
	 *            二级分类id
	 * @return
	 */
	Page<Commodity> pageByClass1Id(int page, int size, int class1Id);

	/**
	 * 根据一级分类id查询所有商品
	 * 
	 * @param class1Id
	 *            一级分类id
	 * @return
	 */
	List<Commodity> findByClass1Id(int class1Id);

	

}
