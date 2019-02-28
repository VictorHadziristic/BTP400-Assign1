package Assign1;

import java.util.ArrayList;

public class finalTask extends Task{

    public finalTask(int taskDuration, ArrayList<Part> taskPart, String taskDescription){
        this.taskType = Assign1.taskType.FINAL;
        this.taskDuration = taskDuration;
        this.taskPart = taskPart;
        this.taskDescription = taskDescription;
    }
}
