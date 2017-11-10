package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean
    @Scope("prototype")
    public TaskList createToDoList() {
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList createDoneList() {
        return new TaskList();
    }

    @Bean
    public Board createBoard() {
        return new Board(createToDoList(), createInProgressList(), createDoneList());
    }
}
