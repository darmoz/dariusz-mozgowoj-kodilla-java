package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context =
            new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("Do Shopping");
        board.getInProgressList().addTask("Finish Java course");
        board.getDoneList().addTask("Eat dinner");
        //When
        String toDoTask = board.getToDoList().getTask(0);
        String inProgressTask = board.getInProgressList().getTask(0);
        String doneTask = board.getDoneList().getTask(0);
        //Then
        Assert.assertEquals("Do Shopping", toDoTask);
        Assert.assertEquals("Finish Java course", inProgressTask);
        Assert.assertEquals("Eat dinner", doneTask);



    }

}
