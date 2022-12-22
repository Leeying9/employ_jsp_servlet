package com.example;

import com.example.dao.impl.EmployeeDaoImpl;
import com.example.util.DBConnection;
import com.example.vo.Dept;
import com.example.vo.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text");
        response.setCharacterEncoding("utf-8");
        DBConnection dbc = new DBConnection();
        EmployeeDaoImpl dao = new EmployeeDaoImpl(dbc.getConnection());
        List<Dept> allDepts = null;
        try {
            allDepts = dao.getAllDepts();
            request.setAttribute("depts",allDepts);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            request.getRequestDispatcher("add.jsp").forward(request,response);
            dbc.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");



        String deptID = request.getParameter("select_department");
        String employee_name = request.getParameter("t_name");
        String employee_birthday = request.getParameter("t_birthday");
        request.setAttribute("deptID",deptID);
        request.setAttribute("employee_name",employee_name);
        request.setAttribute("employee_birthday",employee_birthday);
        Employee employee = new Employee(Integer.parseInt(deptID),employee_name,employee_birthday);
        DBConnection dbc = new DBConnection();
        EmployeeDaoImpl dao = new EmployeeDaoImpl(dbc.getConnection());
        try {
            dao.save(employee);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            dbc.close();
        }
        request.getRequestDispatcher("success.jsp").include(request,response);
    }
}
