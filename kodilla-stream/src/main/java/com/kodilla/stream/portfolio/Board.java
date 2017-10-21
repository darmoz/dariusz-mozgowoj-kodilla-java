package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class Board {
    private final List<TasksList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TasksList taskList) {
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TasksList taskList) {
        return taskLists.remove(taskList);
    }

    public List<TasksList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" + "\n" +
                "name='" + name + '\'' + ",\n" +
                "taskLists=" + taskLists + "\n" +
                '}';
    }
}