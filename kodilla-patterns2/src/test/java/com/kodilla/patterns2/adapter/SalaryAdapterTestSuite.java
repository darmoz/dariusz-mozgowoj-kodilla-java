package com.kodilla.patterns2.adapter;

import com.kodilla.patterns2.adapter.company.SalaryAdapter;
import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter adapter = new SalaryAdapter();
        //When
        double totalSalary = adapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        assertEquals(22450, totalSalary, 0);

    }
}
