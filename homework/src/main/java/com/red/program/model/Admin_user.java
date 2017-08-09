package com.red.program.model;

public class Admin_user {
	int aid;
	String itcode;
	String adminname;
	
	public Admin_user() {}
	public Admin_user(int aid, String itcode, String adminname) {
		super();
		this.aid = aid;
		this.itcode = itcode;
		this.adminname = adminname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getItcode() {
		return itcode;
	}

	public void setItcode(String itcode) {
		this.itcode = itcode;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Override
	public String toString() {
		return "Admin_user [aid=" + aid + ", itcode=" + itcode + ", adminname=" + adminname + "]";
	}
	
	
	
}
