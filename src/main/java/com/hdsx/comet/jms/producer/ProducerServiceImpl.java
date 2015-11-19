package com.hdsx.comet.jms.producer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService {

	private JmsTemplate queueJmsTemplate;
	
	private JmsTemplate topicJmsTemplate;
	
	@Override
	public void sendQueueMessage(String requestName, final String text) {
		// TODO Auto-generated method stub
		queueJmsTemplate.send(requestName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(text);
			}
		});
	}
	@Override
	public void sendTopicMessage(String requestName, final String text) {
		// TODO Auto-generated method stub
		topicJmsTemplate.send(requestName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(text);
			}
		});
	}
	
	@Override
	public String sendAndReceiveQueueMessage(String requestName, final String text, final String responseName) {
		// TODO Auto-generated method stub
		TextMessage replyToMsg =(TextMessage) queueJmsTemplate.sendAndReceive(requestName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage txtMsg = session.createTextMessage(text);
				Destination destination = session.createQueue(responseName);
				txtMsg.setJMSReplyTo(destination);
				return txtMsg;
			}
		});
		try {
			return replyToMsg.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return "";
	}
	@Override
	public String sendAndReceiveTopicMessage(String requestName, final String text, final String responseName) {
		// TODO Auto-generated method stub
				TextMessage replyToMsg =(TextMessage) queueJmsTemplate.sendAndReceive(requestName, new MessageCreator() {
					@Override
					public Message createMessage(Session session) throws JMSException {
						// TODO Auto-generated method stub
						TextMessage txtMsg = session.createTextMessage(text);
						Destination destination = session.createQueue(responseName);
						txtMsg.setJMSReplyTo(destination);
						return txtMsg;
					}
				});
				try {
					return replyToMsg.getText();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				return "";
	}
	public JmsTemplate getQueueJmsTemplate() {
		return queueJmsTemplate;
	}
	public void setQueueJmsTemplate(JmsTemplate queueJmsTemplate) {
		this.queueJmsTemplate = queueJmsTemplate;
	}
	public JmsTemplate getTopicJmsTemplate() {
		return topicJmsTemplate;
	}
	public void setTopicJmsTemplate(JmsTemplate topicJmsTemplate) {
		this.topicJmsTemplate = topicJmsTemplate;
	}
}
