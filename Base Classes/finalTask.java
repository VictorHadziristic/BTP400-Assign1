package Assign1;

import java.util.ArrayList;
import java.util.Map;

public class finalTask extends Task{

    public finalTask(int taskDuration, Map<Part, Integer> taskPart, String taskDescription){
        this.taskType = Assign1.taskType.FINAL;
        this.taskDuration = taskDuration;
        this.taskPart = taskPart;
        this.taskDescription = taskDescription;
    }
}
