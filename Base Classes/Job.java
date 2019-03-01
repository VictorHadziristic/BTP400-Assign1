package Assign1;

import java.io.Serializable;
import java.util.ArrayList;

enum carStatus {PreProduction, Production, PostProduction};

public class Job implements Serializable {
    int id;
    ArrayList<Task> assemblyTasks;
    Task currentTask;

    public Job(ArrayList<Task> assemblyTasks) {
        this.assemblyTasks = assemblyTasks;
        this.currentTask = assemblyTasks.get(0);
    }

    public ArrayList<Task> getAssemblyTasks() {
        return assemblyTasks;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public int getId() {
        return id;
    }

    public void completeTask() {
        this.currentTask = null;
        this.assemblyTasks.remove(0);
        this.currentTask = assemblyTasks.get(0);
    }
}
