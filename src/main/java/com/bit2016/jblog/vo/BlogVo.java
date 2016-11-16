package com.bit2016.jblog.vo;

public class BlogVo {

	private Long userNo;
	private String blogTitle;
	private String blogLogo;
	
	public Long getUserNo() {
		return userNo;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public String getBlogLogo() {
		return blogLogo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public void setBlogLogo(String blogLogo) {
		this.blogLogo = blogLogo;
	}
	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", blogTitle=" + blogTitle + ", blogLogo=" + blogLogo + "]";
	}
	
	
}
