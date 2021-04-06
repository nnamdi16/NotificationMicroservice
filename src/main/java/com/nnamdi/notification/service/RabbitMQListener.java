package com.nnamdi.notification.service;

import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import javax.mail.MessagingException;
import java.util.concurrent.atomic.AtomicInteger;

@EnableBinding(MessageService.class)
public class RabbitMQListener {
    public  static  final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);
    private AtomicInteger notificationId = new AtomicInteger(1);

    @Value("${mailFrom}")
    private String senderEmail;

    @Autowired
    private NotificationService notificationService;

    @StreamListener(target = MessageService.NOTIFICATION)
    public void processReceivedMessage(String msg) throws MessagingException {
        logger.info("User details logged ......" + msg);
        Message message = new Message();
        message.setMessageId((long) notificationId.getAndIncrement());
        message.setFrom(senderEmail);
        message.setSubject("Registration Successful");
        message.setBody("Your registration to Piggy Bank is Successful");
        message.setTo(msg);
        notificationService.notify(ChannelType.email,message);
    }

}
