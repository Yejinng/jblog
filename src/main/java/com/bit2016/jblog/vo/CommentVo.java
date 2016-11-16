package com.bit2016.jblog.vo;

public class CommentVo {

	private Long commentNo;
	private Long postNo;
	private String commentContent;
	private String commentDate;
	public Long getCommentNo() {
		return commentNo;
	}
	public Long getPostNo() {
		return postNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", postNo=" + postNo + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + "]";
	}
	
}
