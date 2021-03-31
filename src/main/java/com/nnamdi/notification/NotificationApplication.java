package com.nnamdi.notification;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEmailTools
public class NotificationApplication {


	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
		// set up the connection
//		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("bunny.cloudamqp.com");
//		connectionFactory.setUsername("oyetxevk:oyetxevk");
//		connectionFactory.setPassword("rYRA2_ov5vmHAlwkjEhUQVqaTeWpRKBy");
//		connectionFactory.setVirtualHost("hornet.rmq.cloudamqp.com");
//
//		//Recommended settings
//		connectionFactory.setRequestedHeartBeat(30);
//		connectionFactory.setConnectionTimeout(30000);
//
//		//Set up queue, exchanges and bindings
//		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
//		Queue queue = new Queue("myQueue");
//		admin.declareQueue(queue);
//		TopicExchange exchange = new TopicExchange("myEExchange");
//		admin.declareExchange(exchange);
//		admin.declareBinding(
//				BindingBuilder.bind(queue).to(exchange).with("foo.*"));
//
//		//Set up the listener
//		SimpleMessageListenerContainer container =
//				new SimpleMessageListenerContainer(connectionFactory);
//		Object listener = new Object() {
//			public void handleMessage(String foo) {
//				System.out.println(foo);
//			}
//		};
//
//		//Send a message
//		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
//		container.setMessageListener(adapter);
//		container.setQueueNames("myQueue");
//		container.start();
//
//		RabbitTemplate template = new RabbitTemplate(connectionFactory);
//		template.convertAndSend("myExchange", "foo.bar", "Hello CloudAMQP!");
//		try{
//			Thread.sleep(1000);
//		} catch(InterruptedException e) {
//			Thread.currentThread().interrupt();
//		}
//		container.stop();
	}

}
