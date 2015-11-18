package com.hdsx.comet.dwr.client;
import java.io.Serializable;

/**
 * <pe>
 * 		<p>ActiveMQConnectionFactory amq= new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
 *		<p>ActiveMQConnectionFactory amq= new ActiveMQConnectionFactory();	
 *</pe>
 */
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class JMSConsumerService implements ApplicationContextAware{

	private String queneName;
	
	private String topicName;
	
	private String brokerURL;
	
	private  PooledConnectionFactory pooledConnectionFactory;
	
	@Override
	public void setApplicationContext(ApplicationContext act) throws BeansException {
		// TODO Auto-generated method stub
		this.pooledConnectionFactory = new PooledConnectionFactory(brokerURL);
		pooledConnectionFactory.initConnectionsPool();
		consume(queneName,new JMSMessageListener(act));
		subscibe(topicName,new JMSMessageListener(act));
	}
	
	public void consume(String quene,MessageListener listener){
		try {
			Connection conn = pooledConnectionFactory.createConnection();
			conn.start();
			Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(quene);
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(listener);
			session.commit();
			//conn.close();
			System.out.println("消息已消费.....");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void subscibe(String topicName,MessageListener listener){
		try {
			Connection conn = pooledConnectionFactory.createConnection();
			conn.start();
			Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic(topicName);
			MessageConsumer consumer = session.createConsumer(topic);
			consumer.setMessageListener(listener);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrokerURL() {
		return brokerURL;
	}

	public void setBrokerURL(String brokerURL) {
		this.brokerURL = brokerURL;
	}

	public String getQueneName() {
		return queneName;
	}

	public void setQueneName(String queneName) {
		this.queneName = queneName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	
}
