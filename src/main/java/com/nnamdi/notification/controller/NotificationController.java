package com.nnamdi.notification.controller;

import com.nnamdi.notification.exception.BadRequest;
import com.nnamdi.notification.model.ChannelType;
import com.nnamdi.notification.model.Message;
import com.nnamdi.notification.service.NotificationService;
import com.nnamdi.notification.util.EmailValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "Notification Microservice")
@RequestMapping("/api/v1.0/notifier")
public class NotificationController {
    private static final Logger LOGGER = LogManager.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EmailValidator emailValidator;

    @ApiOperation(value = "Notify the given message to given channelType")
    @ApiResponses(value = {@ApiResponse(code=404, message = "Not Found")})
    @PostMapping("/notify/{channelType}")
    public long notify(@PathVariable ChannelType channelType, @RequestBody Message message) {
        if (ChannelType.email == channelType) {
            if (!emailValidator.isValid(message.getFrom())) {
                throw new BadRequest("From Address", message.getFrom());
            }
            if (!emailValidator.isValid(message.getTo())) {
                throw new BadRequest("To Address", message.getTo());
            }

        }
        return notificationService.notify(channelType, message);
    }

    @ApiOperation(value = "Notify the given message to all channels like email and sms")
    @ApiResponses(value = {@ApiResponse(code=404, message = "Not Found")})
    @PostMapping("/notifyAll")
    public long notifyAll(@RequestBody Message message) {
        return notificationService.notifyAll(message);
    }



}
