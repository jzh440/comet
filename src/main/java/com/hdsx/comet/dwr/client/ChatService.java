package com.hdsx.comet.dwr.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hdsx.comet.dwr.event.HDMessageEvent;

public class ChatService implements ApplicationContextAware {

	private ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context = context;
	}
	
	public void sendMessage(String msg){
		context.publishEvent(new HDMessageEvent(msg));
	}

}
