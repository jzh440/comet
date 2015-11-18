package com.hdsx.comet.dwr.client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;

import com.hdsx.comet.dwr.event.HDMessageEvent;

public class JMSMessageListener implements MessageListener {

	private ApplicationContext context;
	
	public JMSMessageListener(ApplicationContext context){
		this.context = context;
	}
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage msg = (TextMessage) message;
		try {
			System.out.println("JMS:"+msg.getText());
			context.publishEvent(new HDMessageEvent(msg.getText()));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
