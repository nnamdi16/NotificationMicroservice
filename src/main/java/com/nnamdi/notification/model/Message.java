package com.nnamdi.notification.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@JsonIgnoreProperties
@Component
public class Message {
    private String password;

    private Long messageId;
    private String subject;
    private String from;
    private String to;
    private String body;
    private String sentTime;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Message() {
        this.sentTime = LocalDateTime.now().toString();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", subject='" + subject + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", body='" + body + '\'' +
                ", sentTime='" + sentTime + '\'' +
                '}';
    }
}
