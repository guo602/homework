package com.red.program.model;

public class Redpacket {
	int times;
	int amount;
    int isOpen;
    public Redpacket(){}
    public Redpacket(int times,int amount,int isOpen)
    {
    	super();
    	this.times=times;
    	this.amount=amount;
    	this.isOpen=isOpen;
    }
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
    
}
