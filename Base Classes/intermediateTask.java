package Assign1;

import java.util.ArrayList;
import java.util.Map;

public class intermediateTask extends Task {

    public intermediateTask(boolean isMandatory, int taskDuration, Map<Part, Integer> taskPart, String taskDescription){
        this.taskType = Assign1.taskType.INTERMEDIATE;
        this.isMandatory = isMandatory;
        this.taskDuration = taskDuration;
        this.taskPart = taskPart;
        this.taskDescription = taskDescription;
    }
}
