package com.cs.services;

import java.util.List;

import com.cs.model.Comment;

public interface ICommentService {
	/**
	 * 根据商品id查询当前商品下的评论
	 * 
	 * @param commodityId
	 *            商品id
	 * @return
	 */
	List<Comment> findByCommodityId(int commodityId);
}
