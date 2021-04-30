package com.payrollservice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
/*@Description:- To stablish the connection b/w Mysql to java program */
public class EmployeePayrollService {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://Localhost:3306/payroll_service?autoReconnect=true&useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath", e);
        }
        ListDrivers();
        try {
            System.out.println("Connecting to the database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful" + connection);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    private static void ListDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()) {
            Driver driverClass =(Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}

