package Assign1;

import java.util.ArrayList;

public class intermediateTask extends Task {

    public intermediateTask(boolean isMandatory, int taskDuration, ArrayList<Part> taskPart, String taskDescription){
        this.taskType = Assign1.taskType.INTERMEDIATE;
        this.isMandatory = isMandatory;
        this.taskDuration = taskDuration;
        this.taskPart = taskPart;
        this.taskDescription = taskDescription;
    }
}
