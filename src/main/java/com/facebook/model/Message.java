package com.facebook.model;

import com.facebook.ui.MessageUI;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {

//    private static int newIdi=1;

    private final int message_id;
    private int sender_id;
    private int receiver_id;
    private String message;
    private long serialVersionUID=1L;

    public Message(int message_id, int sender_id, int receiver_id, String message) {
        this.message_id = message_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
    }

    public Message(int sender_id, int receiver_id, String message) {

        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
        this.message_id= hashCode();
    }


    @Override
    public int hashCode() {
        return Objects.hash(getSender_id(), getReceiver_id(), getMessage());
    }

    public int getMessage_id() {
        return message_id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        if(message.contains("_reply*")){
            String s1 = message.substring(message.indexOf("*") + 1);
            return "\t id= " + message_id +
                    ", " + MessageUI.getNameFromID(sender_id) +": "+
                    '\''+s1.trim() + '\'' ;
        }
        return "\n id= " + message_id +
                ", " + MessageUI.getNameFromID(sender_id) +": "+
                '\''+message + '\'';
    }
}
