package com.kodilla.stream.portfolio;

import java.util.LinkedList;
import java.util.List;

public final class TasksList {
    private final List<Task> tasks = new LinkedList<>();
    private final String name;

    public TasksList(final String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new LinkedList<>(tasks);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "name='" + name + '\'' + ",\n" +
                "tasks=\n" + tasks + "\n" +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TasksList)) return false;
        TasksList taskList = (TasksList) o;
        return name.equals(taskList.name);
    }
}