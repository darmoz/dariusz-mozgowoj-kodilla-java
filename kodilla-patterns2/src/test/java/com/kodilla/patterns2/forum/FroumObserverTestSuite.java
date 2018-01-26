package com.kodilla.patterns2.forum;

import com.kodilla.patterns2.observer.forum.ForumUser;
import com.kodilla.patterns2.observer.forum.JavaHelpForumTopic;
import com.kodilla.patterns2.observer.forum.JavaToolForumTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FroumObserverTestSuite {

    @Test
    public void testObserver() {
        //Given
        JavaHelpForumTopic javaHelpForumTopic = new JavaHelpForumTopic();
        JavaToolForumTopic javaToolForumTopic = new JavaToolForumTopic();

        ForumUser Ania = new ForumUser("Ania");
        ForumUser Darek = new ForumUser("Darek");
        ForumUser Jagoda = new ForumUser("Jagoda");

        javaHelpForumTopic.registerObserver(Ania);
        javaHelpForumTopic.registerObserver(Jagoda);
        javaToolForumTopic.registerObserver(Darek);
        javaToolForumTopic.registerObserver(Ania);
        //When
        javaHelpForumTopic.addPost("First post about Java9");
        javaHelpForumTopic.addPost("Enum vs if?");
        javaHelpForumTopic.addPost("REST and Microservices questions");
        javaToolForumTopic.addPost("use Gradle");
        javaToolForumTopic.addPost("Logger error");
        //Then
        assertEquals(5, Ania.getUpdateCount());
        assertEquals(3, Jagoda.getUpdateCount());
        assertEquals(2, Darek.getUpdateCount());
    }
}
