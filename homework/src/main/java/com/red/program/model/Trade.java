package com.red.program.model;

/**
 * 充值或打赏记录，交易id，账户id，充值或打赏金额，交易时间，充值/打赏，备注
 * @author zheng
 *
 */
public class Trade {
	 int tid;
     int wid;
     int volumn;   
     String tradetime;
     int property;
     String memo;
     public Trade() {}
     public Trade(int tid, int wid, int volumn, String tradetime, int property, String memo) {
 		super();
 		this.tid = tid;
 		this.wid = wid;
 		this.volumn = volumn;
 		this.tradetime = tradetime;
 		this.property = property;
 		this.memo = memo;
 	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getVolumn() {
		return volumn;
	}
	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
	public String getTradetime() {
		return tradetime;
	}
	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
		this.property = property;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Trade [tid=" + tid + ", wid=" + wid + ", volumn=" + volumn + ", tradetime=" + tradetime + ", property="
				+ property + ", memo=" + memo + "]";
	}
     
}
