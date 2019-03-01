package Assign1;

import java.io.Serializable;
import java.util.ArrayList;

enum carStatus {PreProduction, Production, PostProduction};

public class Job implements Serializable {
    ArrayList<Task> assemblyTasks;
    Car car;
    Task currentTask;

    public Job(ArrayList<Task> assemblyTasks, Car car) {
        this.assemblyTasks = assemblyTasks;
        this.car = car;
        this.currentTask = assemblyTasks.get(0);
    }

    public ArrayList<Task> getAssemblyTasks() {
        return assemblyTasks;
    }

    public Car getCar() {
        return car;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void completeTask() {
        this.currentTask = null;
        this.assemblyTasks.remove(0);
        this.currentTask = assemblyTasks.get(0);
    }
}
