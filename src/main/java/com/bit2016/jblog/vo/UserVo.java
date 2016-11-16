package com.bit2016.jblog.vo;

public class UserVo {
	
	private Long userNo;
	private String id;
	private String name;
	private String password;
	private String joinDate;
	public Long getUserNo() {
		return userNo;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", name=" + name + ", password=" + password + ", joinDate="
				+ joinDate + "]";
	}
	
	

}
