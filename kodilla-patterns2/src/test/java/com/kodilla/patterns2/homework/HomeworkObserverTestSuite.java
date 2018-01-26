package com.kodilla.patterns2.homework;

import com.kodilla.patterns2.observer.homework.CollectionExercise;
import com.kodilla.patterns2.observer.homework.HibernateExercise;
import com.kodilla.patterns2.observer.homework.Mentor;
import com.kodilla.patterns2.observer.homework.SpringExercise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkObserverTestSuite {

    @Test
    public void testHomeworkObserver() {
        //Given
        CollectionExercise collectionExercise = new CollectionExercise();
        HibernateExercise hibernateExercise = new HibernateExercise();
        SpringExercise springExercise = new SpringExercise();

        Mentor Mentor1 = new Mentor("Mentor1");
        Mentor Mentor2 = new Mentor("Mentor2");

        collectionExercise.registerObserver(Mentor1);
        hibernateExercise.registerObserver(Mentor2);
        springExercise.registerObserver(Mentor1);
        springExercise.registerObserver(Mentor2);
        //When
        collectionExercise.addSolution("first solution of collections");
        collectionExercise.addSolution("temporal solution for collection loop");
        hibernateExercise.addSolution("connected to database");
        springExercise.addSolution("annotation works as expected");
        springExercise.addSolution("spring boot usage example");
        //then
        assertEquals(4, Mentor1.getExercisesToCheck());
        assertEquals(3, Mentor2.getExercisesToCheck());
    }
}
