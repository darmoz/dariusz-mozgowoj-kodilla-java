package factoryChallenge;


import org.junit.Assert;
import org.junit.Test;

public class TaskTestSuite {
    @Test
    public void testShoppingTask() {
        //given
        TaskFactory factory = new TaskFactory();
        ShoppingTask task = (ShoppingTask)factory.createTask("SHOPPING");
        //when
        TaskDto dtoEntry = (TaskDto)TaskDataBase.getInstance().getTask(0);
        String name = task.getTaskName();
        boolean status = dtoEntry.getStatus();
        int basketSize = task.getQuantity();

        //then
        Assert.assertEquals(true, status);
        Assert.assertEquals("Cloths", name);
        Assert.assertEquals(2, basketSize);
    }
    @Test
    public void testPaintingTask() {
        //given
        TaskFactory factory = new TaskFactory();
        PaintingTask task = (PaintingTask)factory.createTask("PAINTING");
        //when
        TaskDto dtoEntry = (TaskDto)TaskDataBase.getInstance().getTask(0);
        boolean status = dtoEntry.getStatus();
        String name = task.getTaskName();
        String roomToPaint = task.getWhatToPaint();
        //then
        Assert.assertEquals(true, status);
        Assert.assertEquals("Apartment refreshing", name);
        Assert.assertEquals("Dinning room", roomToPaint);
    }
    @Test
    public void testDrivingTask() {
        //given
        TaskFactory factory = new TaskFactory();
        DrivingTask task = (DrivingTask)factory.createTask("DRIVING");
        //when
        TaskDto dtoEntry = (TaskDto)TaskDataBase.getInstance().getTask(0);
        boolean status = dtoEntry.getStatus();
        String name = task.getTaskName();
        String place = task.getWhere();
        //then
        Assert.assertEquals(true, status);
        Assert.assertEquals("City Tour", name);
        Assert.assertEquals("Old city", place);
    }
}
