package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.ArrayList;


public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> testEven = new ArrayList<Integer>();
        for(int i=2; i<10; i+=2){
            testEven.add(i);
        }
        //When
        OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testNumbers = new ArrayList<Integer>();
        for(int i=1; i<10; i++) {
            testNumbers.add(i);
        };
        //Then
        Assert.assertEquals(testEven, oddExterminator.exterminator(testNumbers));
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> testEmpty = new ArrayList<Integer>();
        //When
        OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testNumbers = new ArrayList<Integer>();
        //Then
        Assert.assertEquals(testEmpty, oddExterminator.exterminator(testNumbers));
    }
}
