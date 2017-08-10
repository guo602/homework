package com.red.program.model;

public class Bonus {
    int pid;
    int bonus;
    public Bonus() {}
	public Bonus(int pid, int bonus) {
		super();
		this.pid = pid;
		this.bonus = bonus;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Bonus [pid=" + pid + ", bonus=" + bonus + "]";
	}
    
}
