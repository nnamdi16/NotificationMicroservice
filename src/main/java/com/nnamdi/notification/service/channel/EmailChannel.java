package com.nnamdi.notification.service.channel;

import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import com.nnamdi.notification.util.EmailValidator;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class EmailChannel implements Channel{

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private EmailService emailService;

    @Autowired
    Message message;

    private JavaMailSender javaMailSender;

    public EmailChannel(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void notify(Message msg) throws MessagingException {
        if (!emailValidator.isValid(msg.getFrom())) {
            throw new RuntimeException("Invalid email format in - from address ");
        }

        if (!emailValidator.isValid(msg.getTo())) {
            throw new RuntimeException("Invalid email format in - to address ");
        }

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(msg.getTo());
            simpleMailMessage.setSubject(msg.getSubject());
            simpleMailMessage.setText(msg.getBody());
            simpleMailMessage.setFrom(msg.getFrom());
            javaMailSender.send(simpleMailMessage);

        } catch (Exception e) {
            throw new RuntimeException("Failed to send message using email channel, exception " + e.getMessage(),e);
        }
    }

    @Override
    public boolean supports(ChannelType channelType) {
        return ChannelType.email == channelType;
    }
}
