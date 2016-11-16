package com.bit2016.jblog.vo;

public class PostVo {

	private Long postNo;
	private Long categoryNo;
	private String postTitle;
	private String postContent;
	private String postDate;
	public Long getPostNo() {
		return postNo;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", categoryNo=" + categoryNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", postDate=" + postDate + "]";
	}
	
	
}
