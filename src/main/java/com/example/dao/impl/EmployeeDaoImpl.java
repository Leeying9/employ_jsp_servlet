package com.example.dao.impl;

import com.example.dao.EmployeeDao;
import com.example.util.DBConnection;
import com.example.vo.Dept;
import com.example.vo.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private Connection conn = null;
    public EmployeeDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Dept> getAllDepts() throws Exception {

        //声明声明集、结果集
        PreparedStatement prst = null;
        ResultSet rs = null;
        //做声明集
        String sql = "SELECT  * FROM Dept WHERE 1 = 1";
        prst = conn.prepareStatement(sql);
        //查询（做结果集）
        rs = prst.executeQuery();
        //利用结果
        List<Dept> depts = new ArrayList<Dept>();
        while (rs.next()){
            int ID = rs.getInt(1);
            String Name = rs.getString(2);
            Dept dept = new Dept(ID, Name);
            depts.add(dept);
        }
        //关闭rs，prst
        if (rs!=null)
            rs.close();
        if (prst!=null)
            prst.close();

        //返回结果
        return depts;
    }

    @Override
    public boolean save(Employee employee) throws Exception {
        //声明声明集、结果集
        PreparedStatement prst = null;
        ResultSet rs = null;
        //做声明集
//        INSERT INTO employee(DeptID,`Name`,birthday) VALUEs(2,'zhangsan','2001-08-18');
        String sql = "INSERT INTO employee(DeptID,`Name`,birthday) VALUES (?,?,?);";
        prst = conn.prepareStatement(sql);
        prst.setInt(1,employee.getDeptID().intValue());
        prst.setString(2,employee.getName());
        prst.setDate(3, Date.valueOf(employee.getBirthday()));//注意！date！
        //查询（做结果集）
        int update = prst.executeUpdate();
        //关闭rs，prst
        if (rs!=null)
            rs.close();
        if (prst!=null)
            prst.close();

        //返回结果
        return (update>0)?true:false;
    }

    @Override
    public List<Employee> getAllEmployeeByDeptID(Integer DeptID) throws Exception {
        //声明声明集、结果集
        PreparedStatement prst = null;
        ResultSet rs = null;
        //做声明集

        String sql = "Select * from employee where DeptID = ?;";
        prst = conn.prepareStatement(sql);
        prst.setInt(1,DeptID);

        //查询（做结果集）
        rs=prst.executeQuery();
        //利用结果
        List<Employee> employee_list = new ArrayList<Employee>();// 必须要new，不能是=null，否则空指针错误
        while (rs.next()){

            Integer ID = rs.getInt(1);
            Integer DeptID_i = rs.getInt(2);
            String Name = rs.getString(3);
            String birthday = rs.getString(4);
            Employee em = new Employee(ID,DeptID_i,Name,birthday);
            employee_list.add(em);
        }
        //关闭rs，prst
        if (rs!=null)
            rs.close();
        if (prst!=null)
            prst.close();
        //返回结果
        return employee_list;
    }
}
