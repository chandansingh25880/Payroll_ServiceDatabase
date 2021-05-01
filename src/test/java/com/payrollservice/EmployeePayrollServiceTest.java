package com.payrollservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
   
        EmployeePayrollDBService employeePayrollService;
        List<EmployeePayrollData> employeePayrollList;

    /*@Description:-  Ability for Employee Payroll Service to retrieve the Employee Payroll from the Database
    * using method readEmployeePayrollData to read data from list
    * Return the list of Employee Payroll Data */
        @Test
        public void givenEmployeePayrollInDB_WhenRetrived_ShouldMatchEmployeeCount() {
            employeePayrollService = new EmployeePayrollDBService();
            employeePayrollList = employeePayrollService.readEmployeePayrollData(EmployeePayrollDBService.IOService.DB_IO);
            Assert.assertEquals(3, employeePayrollList.size());

        }
    }