package com.theah64.xrob.models;

/**
 * Created by theapache64 on 30/9/16.
 */

public class Message {

    public static final String TYPE_INBOX = "inbox";
    private final String androidId;
    private final String from, content, type;
    private final long deliveryTime;

    public Message(String androidId, String from, String content, String type, long deliveryTime) {
        this.androidId = androidId;
        this.from = from;
        this.content = content;
        this.type = type;
        this.deliveryTime = deliveryTime;
    }

    public String getAndroidId() {
        return androidId;
    }

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public long getDeliveryTime() {
        return deliveryTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "androidId=" + androidId +
                ", from='" + from + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}
