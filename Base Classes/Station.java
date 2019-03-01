package Assign1;

import java.net.Socket;

public class Station {
    int ID;
    Task task;
    Job currentJob;
    stationStatus currentStatus;
    Socket socket;

    public String reportStatus(){
        String statusString;
        switch (currentStatus) {
            case OFF:  statusString = "OFF";
                break;
            case WAITING:  statusString = "WAITING";
                break;
            case WORKING:  statusString = "WORKING";
                break;
            case HALTED:  statusString = "HALTED";
                break;
            default: statusString = "OFF";
                break;
        }
        return statusString;
    }

    public Station(int ID, Task task) {
        this.ID = ID;
        this.task = task;
        this.currentStatus = stationStatus.WAITING;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }

    public Task getTask() {
        return task;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public stationStatus getCurrentStatus() {
        return currentStatus;
    }

    public int getID() { return ID; }

    public Order createOrder(){
        return new Order(task.getTaskPart(), orderStatus.UNFULFILLED);
    }
}
