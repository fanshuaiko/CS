package com.cs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cs.model.Comment;

/**
 * 商品评论仓库
 * 
 * @author fan 创建时间：2018年7月12日
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	/**
	 * 根据商品id查询当前商品下的评论
	 * 
	 * @param commodityId
	 *            商品id
	 * @return
	 */
	List<Comment> findByCommodityId(int commodityId);
}
