package com.red.program.model;

public class Department {
	int did;
	String deptname;
	int bonus;
	
	public Department() {}
	public Department(int did, String deptname, int bonus) {
		super();
		this.did = did;
		this.deptname = deptname;
		this.bonus = bonus;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return "Department [did=" + did + ", deptname=" + deptname + ", bonus=" + bonus + "]";
	}
	
	
	
}
