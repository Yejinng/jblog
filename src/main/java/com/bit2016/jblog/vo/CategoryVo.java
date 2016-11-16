package com.bit2016.jblog.vo;

public class CategoryVo {

	private Long categoryNo;
	private Long userNo;
	private String categoryName;
	private String categoryDescription;
	private String categoryDate;
	public Long getCategoryNo() {
		return categoryNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public String getCategoryDate() {
		return categoryDate;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public void setCategoryDate(String categoryDate) {
		this.categoryDate = categoryDate;
	}
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", userNo=" + userNo + ", categoryName=" + categoryName
				+ ", categoryDescription=" + categoryDescription + ", categoryDate=" + categoryDate + "]";
	}
	
	
}
