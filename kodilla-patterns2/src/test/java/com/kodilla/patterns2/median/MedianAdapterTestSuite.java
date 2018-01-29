package com.kodilla.patterns2.median;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.TheBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<TheBook> testBooks = new HashSet<>();
        testBooks.add(new TheBook("John", "Walk", 2011, "1234"));
        testBooks.add(new TheBook("Adam", "Iron", 2012, "6092"));
        testBooks.add(new TheBook("Grim", "Idiots", 2013, "4216"));
        testBooks.add(new TheBook("Ben", "Give", 2014, "2456"));
        testBooks.add(new TheBook("Frank", "The house", 2015, "2234"));
        //When
        int medianOfPublicationYear = adapter.publicationYearMedian(testBooks);
        //Then
        assertEquals(2013, medianOfPublicationYear);
    }
}
