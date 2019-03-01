package Assign1;

public class Status {
    int stationID;
    stationStatus stationStatus;

    public Status(int stationID, Assign1.stationStatus stationStatus) {
        this.stationID = stationID;
        this.stationStatus = stationStatus;
    }

    public int getStationID() {
        return stationID;
    }

    public Assign1.stationStatus getStationStatus() {
        return stationStatus;
    }
}
