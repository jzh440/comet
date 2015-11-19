package com.hdsx.comet.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hdsx.comet.event.JMSApplicationEvent;

public class TopicMessageListener implements MessageListener,ApplicationContextAware {

	private ApplicationContext context;
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage msg = (TextMessage) message;
		try {
			context.publishEvent(new JMSApplicationEvent(msg.getText()));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context = context;
	}

}
