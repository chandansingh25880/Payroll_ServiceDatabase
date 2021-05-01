package com.payrollservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

    /*@Description:- to update the salary i.e.the base pay for Employee erisa to 3000000.00  */
    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldMatch() {
        employeePayrollService = new EmployeePayrollDBService();
        employeePayrollList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terisa", 3000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa");
        Assert.assertTrue(result);

    }

    @Test
    public void givenDateRange_WhenRetrievedEmployee_ShouldReturnEmpCount() throws EmployeePayrollException {
        employeePayrollService = new EmployeePayrollService();
        employeePayrollList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        LocalDate startDate = LocalDate.of(2018, 01, 01);
        LocalDate endDate = LocalDate.now();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollDataForDateRange(startDate, endDate);
        Assert.assertEquals(3, employeePayrollList.size());
    }
}
}
