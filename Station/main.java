import Assign1.*;

import java.io.*;
import java.net.Socket;

public class main {

    public static void main(String args[]){
        boolean stationActive = true; Job currentJob = null; Station station = null;
        try {

            Socket Socket = new Socket("127.0.0.1", 27000);

            ObjectInputStream objectInputStream = new ObjectInputStream(Socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Socket.getOutputStream());

            station = (Station) objectInputStream.readObject();

            if(station != null){
                objectOutputStream.writeObject(new Message(MessageType.STATUS, new Status(station.getID(), stationStatus.WAITING), null, null));
                while(stationActive){
                    Message incomingJob = (Message) objectInputStream.readObject();
                    currentJob = incomingJob.getJob();
                    if(currentJob != null && currentJob.getCurrentTask() == station.getTask()){
                        objectOutputStream.writeObject(new Message(MessageType.ORDER, new Status(station.getID(), stationStatus.HALTED), new Order(station.getTask().getTaskPart(), orderStatus.UNFULFILLED), null));
                        Message incomingOrder = (Message) objectInputStream.readObject();
                        if(incomingOrder.getOrder().getOrderStatus() == orderStatus.FULFILLED){
                            objectOutputStream.writeObject(new Message(MessageType.STATUS, new Status(station.getID(), stationStatus.WORKING), null, null));
                            Thread.sleep(station.getTask().getTaskDuration());
                            objectOutputStream.writeObject(new Message(MessageType.STATUS, new Status(station.getID(), stationStatus.WAITING), null, null));
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
}
