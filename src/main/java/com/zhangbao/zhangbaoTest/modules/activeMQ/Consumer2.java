package com.zhangbao.zhangbaoTest.modules.activeMQ;
 
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
 
@Component
public class Consumer2 {
 
	@JmsListener(destination = "mytest.queue")
	@SendTo("out.queue")
	public String receiveQueue(String text) {
		System.out.println("Consumer2收到的报文为:"+text);
		return "return message"+text;
	}
}