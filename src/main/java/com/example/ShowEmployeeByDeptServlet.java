package com.example;

import com.example.dao.impl.EmployeeDaoImpl;
import com.example.util.DBConnection;
import com.example.vo.Dept;
import com.example.vo.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowEmployeeByDeptServlet", value = "/ShowEmployeeByDeptServlet")
public class ShowEmployeeByDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        //        request.setCharacterEncoding("utf-8");
//        response.setContentType("html/text");
//        response.setCharacterEncoding("utf-8");
//        DBConnection dbc = new DBConnection();
//        EmployeeDaoImpl dao = new EmployeeDaoImpl(dbc.getConnection());
//        List<Dept> allDepts = null;
//        try {
//            allDepts = dao.getAllDepts();
//            request.setAttribute("depts",allDepts);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }finally {
//            dbc.close();
//        }
//        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //转发之前做depts存进request，否则下拉框找不到值
        DBConnection dbc = new DBConnection();
        EmployeeDaoImpl dao = new EmployeeDaoImpl(dbc.getConnection());
        List<Dept> allDepts = null;
        try {
            allDepts = dao.getAllDepts();
            request.setAttribute("depts",allDepts);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            dbc.close();
        }

        //拿到表单提交的选择
        String deptID = request.getParameter("dept_select");
        if (deptID==null){
            deptID = "";
        }

        if (!deptID.equals("") ) {
            //如果表单提交的选择不是空字符串，用表单提交的选择
        }else{
            //如果表单提交的选择是空字符串，认为表单提交的选择是所有部门列表的第一行的部门ID
             deptID = String.valueOf(allDepts.get(0).getID());
        }

        //把deptID存到session去
        HttpSession session = request.getSession();
        session.setAttribute("deptID",deptID);


        //查该部门所有员工employee_list，存到request的attribute
        dbc = new DBConnection();
        dao = new EmployeeDaoImpl(dbc.getConnection());
        try {
            List<Employee> employee_list = new ArrayList<>();
            employee_list=   dao.getAllEmployeeByDeptID(Integer.parseInt(deptID));
            request.setAttribute("employee_list",employee_list);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }finally {
            dbc.close();
        }

        //请求转发
        request.getRequestDispatcher("show.jsp").include(request, response);

    }
}
