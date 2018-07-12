package com.cs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cs_comment")
public class Comment {

	@Id
	@Column(name = "comment_id")
	private Integer commentId;
	@Column(name = "comment_content")
	private String commentContent;
	@Column(name = "comment_date")
	private Date commentDate;
	@Column(name = "commodity_id")
	private int commodityId;
	@Column(name = "user_id")
	private int userId;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", commodityId=" + commodityId + ", userId=" + userId + "]";
	}

	
	
}
