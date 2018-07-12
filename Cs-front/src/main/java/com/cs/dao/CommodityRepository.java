package com.cs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cs.model.Commodity;
/**
 * 商品仓库
 * @author fan
 * 创建时间：2018年7月12日
 */
@Repository
public interface CommodityRepository
		extends PagingAndSortingRepository<Commodity, Integer>, JpaSpecificationExecutor<Commodity> {

	/**
	 * 查询最新的10条商品
	 * 
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from cs_commodity order by commodity_id desc limit 0,10")
	public List<Commodity> findLastTen();

	/**
	 * 根据商品名模糊查询商品
	 * 
	 * @param commodityName
	 * @return
	 */
	@Query("from Commodity c where c.commodityName like %?1%")
	public Commodity findByName(String commodityName);

	/**
	 * 根据商品id查询商品
	 * 
	 * @param id
	 *            商品id
	 * @return
	 */
	public Commodity findByCommodityId(Integer id);

	/**
	 * 根据一级分类id查询商品
	 * 
	 * @param commodityIds
	 * @return
	 */

	@Query("from Commodity where class2Id in ?1")
	public List<Commodity> findByClass1Id(int[] class2Id);
}
