package factoryChallenge;

import java.util.ArrayList;
import java.util.List;

public class TaskDataBase {
    private static TaskDataBase instance;
    List<TaskDto> taskList = new ArrayList<>();

    private TaskDataBase() { }

    public static TaskDataBase getInstance() {
        if(instance==null) {
            instance=new TaskDataBase();
        }
        return instance;
    }

    public TaskDto getTask(int index) {
        return taskList.get(index);
    }



}
