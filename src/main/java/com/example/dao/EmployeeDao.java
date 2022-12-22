package com.example.dao;

import com.example.vo.Dept;
import com.example.vo.Employee;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDao {
    //获得所有部门对象集合
    public abstract List<Dept> getAllDepts() throws Exception;
    //保存一个员工对象
    public abstract boolean save(Employee employe) throws Exception;
    //根据部门ID得到部门所有员工
    public abstract List<Employee> getAllEmployeeByDeptID(Integer  DeptID) throws Exception;
}
