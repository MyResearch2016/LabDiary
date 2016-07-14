package com.wxyseu.model;

import java.sql.Timestamp;

public class Diary {
	
	private int id = 0;	// �ռ�ID
	private String text = "";  // �ռ�����
	private Timestamp writeTime = null;  // д�ռ�ʱ��
	private String timeString = "";
	private int userid = -1;  // �û�ID
	private String username = "";  // �û���
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}
	public Timestamp getWriteTime() {
		return writeTime;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public String getTimeString() {
		return timeString;
	}
}

