package com.red.program.model;

/**
 * 所有用户账户，包括账户id，用户id，余额，账户是否可用，0可用，1不可用，获取红包雨次数
 * @author zheng
 *
 */
public class Wallet {
    int wid;
    int uid;
    int amount;
    int islock;
    int raintimes;
    public Wallet() {}
	public Wallet(int wid, int uid, int amount, int islock,int raintimes) {
		super();
		this.wid = wid;
		this.uid = uid;
		this.amount = amount;
		this.islock = islock;
		this.raintimes=raintimes;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIslock() {
		return islock;
	}
	public void setIslock(int islock) {
		this.islock = islock;
	}
	
	public int getRaintimes() {
		return raintimes;
	}
	public void setRaintimes(int raintimes) {
		this.raintimes = raintimes;
	}
	@Override
	public String toString() {
		return "Wallet [wid=" + wid + ", uid=" + uid + ", amount=" + amount + ", islock=" + islock + "]";
	}
	
    
}
