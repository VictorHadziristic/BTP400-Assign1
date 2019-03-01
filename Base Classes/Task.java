package Assign1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

enum taskType {INITIAL, INTERMEDIATE, FINAL}

public abstract class Task implements Serializable {
    boolean isMandatory;
    taskType taskType;
    int taskDuration;
    Map<Part, Integer> taskPart;
    String taskDescription;

    //Basic Queries
    public boolean isMandatory() { return isMandatory; }
    public taskType getTaskType() { return taskType; }
    public Map<Part, Integer> getTaskPart() { return taskPart; }
    public int getTaskDuration() { return taskDuration; }
    public String getTaskDescription() { return taskDescription; }
}
