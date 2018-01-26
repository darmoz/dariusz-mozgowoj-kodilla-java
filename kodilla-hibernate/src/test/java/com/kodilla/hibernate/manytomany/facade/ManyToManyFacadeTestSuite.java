package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyFacadeTestSuite {
    @Autowired
    private ManyToManyFacade manyToManyFacade;

    @Test
    public void testFacadeCompanySearchByMatch() throws QueryProcessingException {
        //Given
        TestInputData inputData = new TestInputData();
        inputData.createDataBaseEntries();
        //When
        List<Company> result = manyToManyFacade.processCompanyQueries("chin");
        //Then
        Assert.assertEquals(1, result.size());
        //Cleanup
        inputData.deleteTestInput();

    }

    @Test
    public void testFacadeEmployeeSearchByMatch() throws QueryProcessingException {
        //Given
        TestInputData inputData = new TestInputData();
        inputData.createDataBaseEntries();
        //When
        ///List<Employee> result = manyToManyFacade.processEmployeeQueries("oval");
        List<Employee> result = manyToManyFacade.processEmployeeQueries("mit");
        //Then
        Assert.assertEquals(1, result.size());
        //Cleanup
        inputData.deleteTestInput();

    }


}
