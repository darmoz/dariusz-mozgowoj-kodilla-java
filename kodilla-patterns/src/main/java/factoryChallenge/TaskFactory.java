package factoryChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(String taskType) {
        List<TaskDto> taskList = TaskDataBase.getInstance().taskList;
                switch(taskType) {
            case SHOPPING:
                Task shopTask = new ShoppingTask("Cloths", "Jumper", 2);
                boolean shopStatus = shopTask.isTaskExecuted();
                TaskDto shoppingDto = new TaskDto(shopTask, shopStatus);
                taskList.add(shoppingDto);
                return shopTask;
            case PAINTING:
                Task paintTask = new PaintingTask("Apartment refreshing", "Blue", "Dinning room");
                boolean paintStatus = paintTask.isTaskExecuted();
                TaskDto paintingDto = new TaskDto(paintTask, paintStatus);
                taskList.add(paintingDto);
                return paintTask;
            case DRIVING:
                Task driveTask = new DrivingTask("City Tour", "Old city", "Cab");
                boolean driveStatus = driveTask.isTaskExecuted();
                TaskDto drivingDto = new TaskDto(driveTask, driveStatus);
                taskList.add(drivingDto);
                return driveTask;
        }
        return null;
    }
}
