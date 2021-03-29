package com.nnamdi.notification.service;

import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import com.nnamdi.notification.service.channel.Channel;
import com.nnamdi.notification.service.channel.ChannelFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NotificationService {

    private static final Logger LOGGER = LogManager.getLogger(NotificationService.class);

    @Autowired
    ChannelFactory factory;


    public NotificationService(ChannelFactory factory) {
        this.factory = factory;
    }

    private AtomicInteger notificationId = new AtomicInteger(1);


    /**
     * Notifies channel identified by given channelType with the given message.
     * @param msg
     * @return
     */
    public long notifyAll(Message msg) throws MessagingException {
        for (Channel c: factory.getChannels()) {
            msg.setMessageId((long) notificationId.getAndIncrement());
            c.notify(msg);
            LOGGER.debug("ID = "+notificationId+", Message Sent = "+msg);
        }

        return notificationId.longValue();
    }


    /**
     * Notifies all configured channels with the given message
     * @param channelType
     * @param message
     * @return
     */
    public long notify(ChannelType channelType, Message message) throws MessagingException {
        message.setMessageId((long) notificationId.getAndIncrement());
        factory.get(channelType).notify(message);
        LOGGER.debug("ID = "+notificationId+", Message sent =" +message);
        return notificationId.longValue();
    }
}
