package com.red.program.model;

public class LuckyMoney {
	int lid;
	int round;
	int total;

	public LuckyMoney() {
	}

	public LuckyMoney(int lid, int round, int total) {
		super();
		this.lid = lid;
		this.round = round;
		this.total = total;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "LuckyMoney [lid=" + lid + ", round=" + round + ", total=" + total + "]";
	}

}
