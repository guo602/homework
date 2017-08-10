package com.red.program.model;

public class Program {
	int pid;
	String pro_name;
	String performer;
	String start_time;
	int dept_id;
	
	public Program() {}
	public Program(int pid, String pro_name, String performer, String start_time, int dept_id) {
		super();
		this.pid = pid;
		this.pro_name = pro_name;
		this.performer = performer;
		this.start_time = start_time;
		this.dept_id = dept_id;
	
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

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}


	@Override
	public String toString() {
		return "Program [pid=" + pid + ", pro_name=" + pro_name + ", performer=" + performer + ", start_time="
				+ start_time + ", dept_id=" + dept_id + "]";
	}
	
	
}
