package Assign1;

public class Status {
    stationStatus stationStatus;
    String statusContent;

    public Status(Assign1.stationStatus stationStatus, String statusContent) {
        this.stationStatus = stationStatus;
        this.statusContent = statusContent;
    }

    public Assign1.stationStatus getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(Assign1.stationStatus stationStatus) {
        this.stationStatus = stationStatus;
    }

    public String getStatusContent() {
        return statusContent;
    }

    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }
}
