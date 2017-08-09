package com.red.program.model;

public class ChatHistory {
    int hid;
    int uid;
    String word;
    String  historytime;
    public ChatHistory() {}
	public ChatHistory(int hid, int uid, String word, String historytime) {
		super();
		this.hid = hid;
		this.uid = uid;
		this.word = word;
		this.historytime = historytime;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getHistorytime() {
		return historytime;
	}
	public void setHistorytime(String historytime) {
		this.historytime = historytime;
	}
	@Override
	public String toString() {
		return "ChatHistory [hid=" + hid + ", uid=" + uid + ", word=" + word + ", historytime=" + historytime + "]";
	}
    
    
}
