package com.nnamdi.notification.model;

public enum ChannelType {
    sms,
    email;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
