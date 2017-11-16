package factoryChallenge;

public class TaskDto {
    public Task task;
    public boolean executionStatus;

    public TaskDto(Task task, boolean executionStatus) {
        this.task = task;
        this.executionStatus = executionStatus;
    }

    public Task getTask() {
        return task;
    }

    public boolean getStatus() {return executionStatus;}

    public boolean isExecutionStatus(Task task) {
        boolean status = task.isTaskExecuted();
        return status;
    }
}
