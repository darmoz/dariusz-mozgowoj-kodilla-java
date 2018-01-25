package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.Company;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManyToManyFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    private List<Company> anyMatchCompanySearch;

    private List<Employee> anyMatchEmployeeSearch;


    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);

    public void createDataBaseEntries() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);


        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

    }

    public List<Company> processCompanyQueries(String text) throws QueryProcessingException {
    LOGGER.info("Getting new text to search with: " + text);
    boolean wasError = false;
    if(text.isEmpty()) {
        LOGGER.error(QueryProcessingException.ERR_INVALID_TEXT);
        wasError = true;
        throw new QueryProcessingException(QueryProcessingException.ERR_INVALID_TEXT);
    }
    try {
        anyMatchCompanySearch = companyDao.findCompanyWithAnyMatch(text);
        if(anyMatchCompanySearch.size()==0) {
            LOGGER.error("There is no match to:" + text + " in database");
            wasError = true;
            throw new QueryProcessingException(QueryProcessingException.ERR_COMPANY_SEARCH);
        } LOGGER.info("Provided text has match in Company Database");
        } finally {
        if(wasError) {
            LOGGER.info("Something went wrong");

        }
      }
        return anyMatchCompanySearch;
    }

    public List<Employee> processEmployeeQueries(String text) throws QueryProcessingException {
        LOGGER.info("Getting new text to search with: " + text);
        boolean wasError = false;
        if(text.isEmpty()) {
            LOGGER.error(QueryProcessingException.ERR_INVALID_TEXT);
            wasError = true;
            throw new QueryProcessingException(QueryProcessingException.ERR_INVALID_TEXT);
        }
        try {
            anyMatchEmployeeSearch = employeeDao.findEmployeesByAnyMatch(text);
            if(anyMatchEmployeeSearch.size()==0) {
                LOGGER.error("There is no match to:" + text + " in database");
                wasError = true;
                throw new QueryProcessingException(QueryProcessingException.ERR_EMPLOYEE_SEARCH);
            } LOGGER.info("Provided text has match in Employee Database");
        } finally {
            if(wasError) {
                LOGGER.info("Something went wrong");

            }
        }
        return anyMatchEmployeeSearch;
    }


    public void deleteTestEntity() {
        employeeDao.deleteAll();

    }

}
