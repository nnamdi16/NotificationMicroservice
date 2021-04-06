package com.nnamdi.notification.service.channel;

import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;

@Component
public class NotificationChannelFactory {
    private final List<NotificationChannel> notificationChannelList;

    @Autowired
    public NotificationChannelFactory(List<NotificationChannel> notificationChannelList) {
        this.notificationChannelList = notificationChannelList;
    }


    public List<NotificationChannel> getChannelList() {
        return notificationChannelList;
    }

    public NotificationChannel get(ChannelType channelType) {
        return notificationChannelList.stream()
                .filter(service -> service.supports(channelType))
                .findFirst()
                .orElseThrow(() ->new RuntimeException("No Channel found with type " + channelType));
    }

    public void notifyAll(Message message) throws MessagingException {
        for (NotificationChannel notificationChannel : notificationChannelList){
            notificationChannel.notify(message);
        }
    }

    public  List<NotificationChannel> getChannels() {
        return notificationChannelList;
    }

}
