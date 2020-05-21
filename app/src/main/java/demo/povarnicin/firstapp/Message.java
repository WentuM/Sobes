package demo.povarnicin.firstapp;

import java.util.Date;

public class Message {
    public String userName;
    public String textMessage;
    private long messageTime;

    public Message() {}
    public Message(String userName, String textMessage) {
        this.userName = userName;
        this.textMessage = textMessage;

        this.messageTime = new Date().getTime();
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
