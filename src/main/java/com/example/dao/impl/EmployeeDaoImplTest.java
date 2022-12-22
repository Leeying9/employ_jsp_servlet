package com.example.dao.impl;

import com.example.util.DBConnection;
import com.example.vo.Employee;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoImplTest {

    @Test
    public void getAllDepts() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(new DBConnection().getConnection());
        try {
            System.out.println(employeeDao.getAllDepts());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void save() {
        Employee employee=new Employee(1,2,"testname","2001-01-01");
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(new DBConnection().getConnection());
        try {
            boolean saveRes = employeeDao.save(employee);
            System.out.println(saveRes);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void getAllEmployeeByDeptID() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(new DBConnection().getConnection());
        try {
            List<Employee> all = employeeDao.getAllEmployeeByDeptID(2);
            for (Employee employee : all){
                System.out.println(employee);
            }
            System.out.println("***");
            System.out.println(all);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}