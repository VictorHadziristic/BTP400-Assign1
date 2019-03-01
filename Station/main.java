import Assign1.*;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

public class main {

    public static void main(String args[]){
        boolean stationActive = true; Job currentJob = null; Station station = null;
        try {

            Socket Socket = new Socket("127.0.0.1", Integer.parseInt(args[0]));

            ObjectInputStream objectInputStream = new ObjectInputStream(Socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Socket.getOutputStream());

            station = (Station) objectInputStream.readObject();

            if(station != null){
                objectOutputStream.writeObject(new Message(MessageType.STATUS, new Status(stationStatus.WAITING, statusBuilder(station,MessageType.STATUS)), null, null));
                while(stationActive){
                    Message incomingJob = (Message) objectInputStream.readObject();
                    station.setCurrentJob(incomingJob.getJob());
                    if(currentJob != null && currentJob.getCurrentTask() == station.getTask()){
                        objectOutputStream.writeObject(new Message(MessageType.ORDER, new Status(stationStatus.HALTED, statusBuilder(station, MessageType.ORDER)), new Order(station.getTask().getTaskPart(), orderStatus.UNFULFILLED), null));
                        Message incomingOrder = (Message) objectInputStream.readObject();
                        if(incomingOrder.getOrder().getOrderStatus() == orderStatus.FULFILLED){
                            objectOutputStream.writeObject(new Message(MessageType.STATUS, new Status(stationStatus.WORKING, statusBuilder(station, MessageType.STATUS)), null, null));
                            Thread.sleep(station.getTask().getTaskDuration());
                            objectOutputStream.writeObject(new Message(MessageType.STATUS, new Status(stationStatus.WAITING, statusBuilder(station,MessageType.STATUS)), null, null));
                        }
                    }
                    // Possibly Implement wrong job sent to server
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String statusBuilder(Station station, MessageType messageType){
        String status = null;
        if(messageType.equals(MessageType.STATUS) && station.getCurrentStatus().equals(stationStatus.WAITING)){
            status = "Station: " + station.getID() + " is waiting for a job";
        }else if(messageType.equals(MessageType.STATUS) && station.getCurrentStatus().equals(stationStatus.WORKING)){
            status = "Station: " + station.getID() + " is: " + station.getCurrentJob().getCurrentTask().getTaskDescription() + " for job: " +  station.getCurrentJob().getId();
        }else if(messageType.equals(MessageType.ORDER)){
            status =  "Station: " + station.getID() + " is requesting: ";
            for(Map.Entry<Part, Integer> i: station.getTask().getTaskPart().entrySet()){
                status += i.getKey().getName() + " x" + i.getValue().toString();
            }
            status += " for job: " +  station.getCurrentJob().getId();
        }
        return status;
    }
}
