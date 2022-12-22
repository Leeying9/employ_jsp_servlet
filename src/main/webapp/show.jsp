<%--
  Created by IntelliJ IDEA.
  User: MSI-me
  Date: 2022/12/22
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看某部门员工</title>
</head>
<body>
<form id="form1" action="ShowEmployeeByDeptServlet" method="post">

  {depts[0].ID}:<br> ${depts[0].ID}<br>
  {depts[1].ID}:<br> ${depts[1].ID}<br>
  {depts[2].ID}:<br> ${depts[2].ID}<br>
  {depts[3].ID}:<br> ${depts[3].ID}<br>
  sessionScope.deptID:${sessionScope.deptID}<br>
  sessionScope.deptID==【depts[1]】.ID?"selected":【${sessionScope.deptID==depts[1].ID?"selected":""}】<br>
<table border="1">
  <tr>
    <td>部门</td>
    <td>
      <select name="dept_select" id="dept_select" onchange="showAll()">
        <c:forEach var="d" items="${depts}">
          <option value="${d.ID}" ${sessionScope.deptID==d.ID?"selected":""} >${d.name}</option>
        </c:forEach>
      </select>
    </td>
  </tr>
  <tr>
    <th>姓名</th>
    <th>出生日期</th>
  </tr>

    <c:forEach items="${employee_list}" var="em" >
    <tr>
      <td>${em.name}</td>
      <td>${em.birthday}</td>
    </tr>
    </c:forEach>



</table>
</form>
<script>
  function showAll(){
    document.getElementById("form1").submit();
  }
</script>
</body>
</html>
