package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.IntStream;


public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TasksList taskListToDo = new TasksList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TasksList taskListInProgress = new TasksList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TasksList taskListDone = new TasksList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TasksList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TasksList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated())
                .count();

        //Then
        Assert.assertEquals(2, longTasks);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();

        //When
        List<TasksList> workTaskList = new ArrayList<>();
        workTaskList.add(new TasksList("In progress"));

        // OD TĄD MOJE WYPOCINY
        long countResult = project.getTaskLists().stream()
                .filter(workTaskList::contains)
                .flatMap(fm->fm.getTasks().stream())
                .map(m->m.getCreated().until(LocalDate.now(), ChronoUnit.DAYS))
                .count();

        List<TasksList> theList = project.getTaskLists();

       IntStream sumResult = IntStream.range(0,1)
               .map(m-> IntStream.range(0, theList.size()))
               .flatMap(n->n.)

        //Then






    }
}