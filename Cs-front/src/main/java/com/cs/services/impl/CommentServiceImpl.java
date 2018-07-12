package com.cs.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.CommentRepository;
import com.cs.model.Comment;
import com.cs.services.ICommentService;
@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private CommentRepository commentRepository;
	@Override
	public List<Comment> findByCommodityId(int commodityId) {
		
		return commentRepository.findByCommodityId(commodityId);
		
	}

}
