<%--
  Created by IntelliJ IDEA.
  User: MSI-me
  Date: 2022/12/22
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="AddServlet" method="post" onsubmit="return isValidData();">
        <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse; width: 50%; margin: 0 auto;">
            <tr align="center">
                <th align="center" colspan="2">增加员工</th>
            </tr>
            <tr>
                <td>
                    分类
                </td>
                <td>

                    <select name="select_department" >
                        <c:forEach var="d" items="${depts}">
                            <option value="${d.ID}">${d.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td> <input type="text" name="t_name" id="t_name"> </td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td> <input type="text" name="t_birthday" id="t_birthday"> </td>
            </tr>
            <tr style="text-align: center">
                <td align="center" colspan="2"><input type="submit" value="确定"></td>
            </tr>
        </table>
    </form>

<script>
    function isValidData() {
        var nameString=document.getElementById("t_name").value;
        var dateString=document.getElementById("t_birthday").value;
        var regEx = /^\d{4}-\d{2}-\d{2}$/;
        if (nameString==""){
            alert("姓名不能为空");
            return false;
        }

        if (!regEx.test(dateString)) {
            alert("请输入正确的日期格式，例如：2022-12-22");
            return false;
        }

        return true;
    }



</script>
</body>

</html>
