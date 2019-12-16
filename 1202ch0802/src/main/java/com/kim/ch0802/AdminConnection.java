package com.kim.ch0802;

public class AdminConnection {
	/*Environment객체를 사용하지 않고 프로퍼티 파일을 직접 이용하여 스프링 빈을 설정하는 방법*/
	private String adminId;
	private String adminPw;
	private String sub_adminId;
	private String sub_adminPw;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getSub_adminId() {
		return sub_adminId;
	}
	public void setSub_adminId(String sub_adminId) {
		this.sub_adminId = sub_adminId;
	}
	public String getSub_adminPw() {
		return sub_adminPw;
	}
	public void setSub_adminPw(String sub_adminPw) {
		this.sub_adminPw = sub_adminPw;
	}
	
	
}
