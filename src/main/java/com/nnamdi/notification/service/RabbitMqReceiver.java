//package com.nnamdi.notification.service;
//
//import com.nnamdi.notification.model.ChannelType;
//import com.nnamdi.notification.model.Message;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Component
//public class RabbitMqReceiver implements RabbitListenerConfigurer {
//    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);
//    private AtomicInteger notificationId = new AtomicInteger(1);
//
//    @Value("${mailFrom}")
//    private String senderEmail;
//
//    @Autowired
//    private NotificationService notificationService;
//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
//
//    }
//
//    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
//    public void receivedMessage(String in) throws MessagingException {
//        Message message = new Message();
//        message.setMessageId((long) notificationId.getAndIncrement());
//        message.setFrom(senderEmail);
//        message.setSubject("Registration Successful");
//        message.setBody("Your registration to Piggy Bank is Successful");
//        message.setTo(in);
//        notificationService.notify(ChannelType.email,message);
//
//        logger.info("User details logged...." + in);
//    }
//
//
//}

//jar build/libs/notification-0.0.1-SNAPSHOT.jar  --app reloadly-notify-microservice

