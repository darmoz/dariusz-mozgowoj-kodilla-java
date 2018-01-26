package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private String mentorName;
    private int exercisesToCheck;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }


    @Override
    public void update(ExercisesContainer exercisesContainer) {
        System.out.println(mentorName + " has new " + exercisesContainer.getExerciseName() + " solution available"
        + "\n" + "Total solutions awaiting: " + exercisesContainer.getExerciseResults().size());
        exercisesToCheck++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getExercisesToCheck() {
        return exercisesToCheck;
    }
}
