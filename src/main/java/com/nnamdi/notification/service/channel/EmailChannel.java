package com.nnamdi.notification.service.channel;

import com.google.common.collect.Lists;
import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import com.nnamdi.notification.util.EmailValidator;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
public class EmailChannel implements Channel{

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void notify(Message msg) {
        if (!emailValidator.isValid(msg.getFrom())) {
            throw new RuntimeException("Invalid email format in - from address ");
        }

        if (!emailValidator.isValid(msg.getTo())) {
            throw new RuntimeException("Invalid email format in - to address ");
        }

        try {
            Email email = DefaultEmail.builder()
                            .from(new InternetAddress(fromEmail, "Notification Service"))
                            .to(Lists.newArrayList(new InternetAddress(
                                    msg.getTo(), ""
                            ))).subject(msg.getSubject())
                            .body(msg.getBody())
                            .encoding("UTF-8").build();
            emailService.send(email);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send message using email channel, exception " + e.getMessage(),e);
        }
    }

    @Override
    public boolean supports(ChannelType channelType) {
        return ChannelType.email == channelType;
    }
}
