package com.red.program.model;

public class Each_program {

	int pid;
	String pro_name;
	String performer;
	String start_time;
	String dept;
	
	public Each_program() {}
	public Each_program(int pid, String pro_name, String performer, String start_time, String dept) {
		super();
		this.pid = pid;
		this.pro_name = pro_name;
		this.performer = performer;
		this.start_time = start_time;
		this.dept = dept;
	
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getDept() {
		return dept ;
	}

	public void setDept(String dept_id) {
		this.dept = dept ;
	}


	@Override
	public String toString() {
		return "Program [pid=" + pid + ", pro_name=" + pro_name + ", performer=" + performer + ", start_time="
				+ start_time + ", dept=" + dept + "]";
	}
	
	
}
