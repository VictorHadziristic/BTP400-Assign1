package Assign1;

import java.io.Serializable;

public class Message implements Serializable {
    MessageType messageType;
    Status status = null; // status of the station
    Order order = null;
    Job job = null;

    public Message(MessageType messageType, Status status, Order order, Job job) {
        if(messageType == MessageType.STATUS && (status == null || order != null || job != null)){
            throw new IllegalArgumentException("Invalid Status Message");
        }else if(messageType == MessageType.ORDER && (status == null || order == null || job != null)){
            throw new IllegalArgumentException("Invalid Order Message");
        }else if(messageType == MessageType.COMPLETEDJOB && (status == null || order != null || job == null)){
            throw new IllegalArgumentException("Invalid Completed Job Message");
        }else if(messageType == MessageType.INCOMINGJOB && (status != null || order != null || job == null)){
            throw new IllegalArgumentException("Invalid Incoming Job Message");
        }else if(messageType == MessageType.SHUTDOWN && (status != null || order != null || job != null)){
            throw new IllegalArgumentException("Invalid Shut Down Message");
        }else{
            this.messageType = messageType;
            this.status = status;
            this.order = order;
            this.job = job;
        }
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public Status getStatus() {
        return status;
    }

    public Order getOrder() {
        return order;
    }

    public Job getJob() {
        return job;
    }
}
