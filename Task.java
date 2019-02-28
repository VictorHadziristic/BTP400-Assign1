package Assign1;

import java.util.ArrayList;

enum taskType {INITIAL, INTERMEDIATE, FINAL};

public abstract class Task {
    boolean isMandatory;
    taskType taskType;
    int taskDuration;
    ArrayList<Part> taskPart;
    String taskDescription;

    //Basic Queries
    public boolean isMandatory() { return isMandatory; }
    public taskType getTaskType() { return taskType; }
    public ArrayList<Part> getTaskPart() { return taskPart; }
    public int getTaskDuration() { return taskDuration; }
    public String getTaskDescription() { return taskDescription; }
}
