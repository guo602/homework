package com.red.program.model;

import java.util.Arrays;

public class ChatInfo {
     int uid;
     int nickname;
     byte[] image;
     int islock;
     public ChatInfo() {}
	public ChatInfo(int uid, int nickname, byte[] image, int islock) {
		super();
		this.uid = uid;
		this.nickname = nickname;
		this.image = image;
		this.islock = islock;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getNickname() {
		return nickname;
	}
	public void setNickname(int nickname) {
		this.nickname = nickname;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getIslock() {
		return islock;
	}
	public void setIslock(int islock) {
		this.islock = islock;
	}
	@Override
	public String toString() {
		return "ChatInfo [uid=" + uid + ", nickname=" + nickname + ", image=" + Arrays.toString(image) + ", islock="
				+ islock + "]";
	}
    
}
