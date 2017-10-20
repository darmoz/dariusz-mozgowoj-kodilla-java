package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;

public class ArrayOperationsTesstSuite {

    @Test

    public void testGetAverage() {

        //Given
        int[] array = {1,4,5,6,0,7,12,2,3,5,9,1,2,2,6,3,8,3,10,0};
        //When
        double sum = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }
         double expected = sum / array.length;
        //Then
        OptionalDouble result = ArrayOperations.getAverage(array);
        Assert.assertEquals(expected, result.getAsDouble(),0.01);
    }
}
