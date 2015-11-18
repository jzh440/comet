package com.hdsx.comet.vo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;

public class Message implements Serializable{
	
	private String id;
	private String title;
	private String body;
	private String sender;
	private String recivers;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecivers() {
		return recivers;
	}
	public void setRecivers(String recivers) {
		this.recivers = recivers;
	}
	

}