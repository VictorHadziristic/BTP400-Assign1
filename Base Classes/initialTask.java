package Assign1;

import java.util.ArrayList;
import java.util.Map;

public class initialTask extends Task{

    public initialTask(int taskDuration, Map<Part, Integer> taskPart, String taskDescription){
        this.isMandatory = true;
        this.taskType = Assign1.taskType.INITIAL;
        this.taskDuration = taskDuration;
        this.taskPart = taskPart;
        this.taskDescription = taskDescription;
    }
}
