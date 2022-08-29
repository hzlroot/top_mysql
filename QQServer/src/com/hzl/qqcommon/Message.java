package com.hzl.qqcommon;

import java.io.Serializable;
import java.util.Objects;

/**
 * 消息体
 */

public class Message implements Serializable {

    private String sender;//发送方
    private String  getter;//接收方
    private String content;//消息内容
    private String sendTime;//发送时间
    private String msgType;//消息类型


    public Message() {
    }

    public Message(String sender, String getter, String content, String sendTime, String msgType) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.sendTime = sendTime;
        this.msgType = msgType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(sender, message.sender) &&
                Objects.equals(getter, message.getter) &&
                Objects.equals(content, message.content) &&
                Objects.equals(sendTime, message.sendTime) &&
                Objects.equals(msgType, message.msgType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, getter, content, sendTime, msgType);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", getter='" + getter + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
