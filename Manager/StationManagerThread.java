import Assign1.Message;
import Assign1.MessageType;
import Assign1.Station;
import Assign1.Status;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StationManagerThread extends Thread{
    boolean stationStatus = true;
    Station station;
    Socket socket = null;

    public StationManagerThread(Socket socket, Station station){
        this.station = station;
        this.socket = socket;
    }

    public void run(){
        try {
            Process proc = Runtime.getRuntime().exec("java -jar BTP400-Assign1-Station.jar " + socket.getPort());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(station);

            main.getInventory();
            /*
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (stationStatus){
                Message incomingMessage = (Message) objectInputStream.readObject();
                if(incomingMessage.getMessageType() == MessageType.STATUS){

                }else if(incomingMessage.getMessageType() == Mess){

                }
            }
            */
        } catch (IOException e) {
            e.printStackTrace();
        }/* catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
    }
}
