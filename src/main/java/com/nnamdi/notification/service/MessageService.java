package com.nnamdi.notification.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageService {
    String NOTIFICATION ="notification";

    @Input(NOTIFICATION)
    SubscribableChannel notification();

}
