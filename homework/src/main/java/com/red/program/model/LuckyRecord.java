package com.red.program.model;

public class LuckyRecord {
      int rid;
      int wid;
      int lucky_money;
      int round;
      public LuckyRecord() {}
	  public LuckyRecord(int rid, int wid, int lucky_money, int round) {
		super();
		this.rid = rid;
		this.wid = wid;
		this.lucky_money = lucky_money;
		this.round = round;
	 
	  }
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getLucky_money() {
		return lucky_money;
	}
	public void setLucky_money(int lucky_money) {
		this.lucky_money = lucky_money;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	@Override
	public String toString() {
		return "LuckyRecord [rid=" + rid + ", wid=" + wid + ", lucky_money=" + lucky_money + ", round=" + round + "]";
	}
      
}
