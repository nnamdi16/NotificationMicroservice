package com.nnamdi.notification.service.channel;

import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;

@Component
public class ChannelFactory {
    private final List<Channel> channelList;

    @Autowired
    public ChannelFactory(List<Channel> channelList) {
        this.channelList = channelList;
    }


    public List<Channel> getChannelList() {
        return channelList;
    }

    public Channel get(ChannelType channelType) {
        return channelList.stream()
                .filter(service -> service.supports(channelType))
                .findFirst()
                .orElseThrow(() ->new RuntimeException("No Channel found with type " + channelType));
    }

    public void notifyAll(Message message) throws MessagingException {
        for (Channel channel: channelList){
            channel.notify(message);
        }
    }

    public  List<Channel> getChannels() {
        return channelList;
    }

}
