package Assign1;

import java.util.ArrayList;

public class initialTask extends Task{

    public initialTask(int taskDuration, ArrayList<Part> taskPart, String taskDescription){
        this.isMandatory = true;
        this.taskType = Assign1.taskType.INITIAL;
        this.taskDuration = taskDuration;
        this.taskPart = taskPart;
        this.taskDescription = taskDescription;
    }
}
