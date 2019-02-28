package Assign1;

enum stationStatus {OFF, WAITING, WORKING, HALTED};

public class Station {
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

    public Task getTask() {
        return task;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public stationStatus getCurrentStatus() {
        return currentStatus;
    }

}
