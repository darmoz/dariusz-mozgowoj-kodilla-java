package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class TaskList {

    private List<String> task;

    public TaskList() {
        task = new ArrayList<String>();
    }

    public void addTask(String string) {
        task.add(string);
    }

    public String getTask(int i){
        String entry = task.get(i);
        return  entry;
    }
}
