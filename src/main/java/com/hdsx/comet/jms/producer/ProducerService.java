package com.hdsx.comet.jms.producer;

/**
 * 目前数据的传输都是以字符串格式，这个应根据实际情况确认
 * @author Administrator
 *
 */
public interface ProducerService {

	/**
	 * 点对点模型
	 * @param requestName 发送目的地
	 * @param msg 消息内容
	 */
	public void sendQueueMessage(String requestName,String msg);
	
	/**
	 * 订阅模型
	 * @param requestName 发送目的地
	 * @param msg 消息内容
	 */
	public void sendTopicMessage(String requestName,String msg);
	/**
	 * 点对点需回复
	 * @param requestName
	 * @param msg
	 * @param responseName
	 * @return
	 */
	public String sendAndReceiveQueueMessage(String requestName,String msg,String responseName);
	/**
	 *  订阅模型不需要回复
	 * @param requestName
	 * @param msg
	 * @param responseName
	 * @return
	 */
	public String sendAndReceiveTopicMessage(String requestName,String msg,String responseName);
}
