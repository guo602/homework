package com.red.program.model;

/**
 * 所有用户，用户id，用户工号，用户名
 * @author zheng
 *
 */
public class All_user {
    int uid;
    String itcode;
    String username;
    public All_user() {}
	public All_user(int uid, String itcode, String username) {
		super();
		this.uid = uid;
		this.itcode = itcode;
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getItcode() {
		return itcode;
	}
	public void setItcode(String itcode) {
		this.itcode = itcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "All_user [uid=" + uid + ", itcode=" + itcode + ", username=" + username + "]";
	}
    
}
