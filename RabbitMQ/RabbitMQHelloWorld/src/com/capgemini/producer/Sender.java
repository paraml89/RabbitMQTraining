package com.capgemini.producer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
	
	public static final String QUEUE_NAME="QUEUE_HELLO";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory connectionFactory=new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection=connectionFactory.newConnection();
		Channel channel=connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message="Welcome to My World.............!!!";
		
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
		
	}

}
