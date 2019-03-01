package Assign1;

public class Station {
    int ID;
    Task task;
    Job currentJob;
    stationStatus currentStatus;

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
