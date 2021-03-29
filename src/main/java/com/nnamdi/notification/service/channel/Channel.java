package com.nnamdi.notification.service.channel;

import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import org.springframework.stereotype.Repository;

import javax.mail.MessagingException;

@Repository
public interface Channel {
    default  void notify(Message message) throws MessagingException {
        throw new RuntimeException("Notify method is not implemented yet");
    }

    default boolean supports(ChannelType type) {
        throw  new RuntimeException("Notify method is not implemented ywt ");
    }
}
