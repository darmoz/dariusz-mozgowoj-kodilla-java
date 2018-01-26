package com.kodilla.patterns2.observer.homework;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ExercisesContainer implements Observable{
    private final List<Observer> observers;
    private final Queue<String> exerciseResults;
    private String exerciseName;

    public ExercisesContainer(String exerciseName) {
        observers = new ArrayList<>();
        exerciseResults = new ArrayDeque<>();
        this.exerciseName = exerciseName;
    }

    public void addSolution(String solution) {
        exerciseResults.offer(solution);
        notifyObservers();
    }

    public Queue<String> getExerciseResults() {
        return exerciseResults;
    }

    public String getExerciseName() {
        return exerciseName;
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
