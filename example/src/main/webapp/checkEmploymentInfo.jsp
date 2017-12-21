<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/21 0021
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<table align="center" border="1">
    <tr>
        <td>姓名</td>
        <td>${sessionScope.login.empName}</td>
    </tr>
    <tr>
        <td>员工编号</td>
        <td>${sessionScope.employmentInfo.empNumber}</td>
    </tr>
    <tr>
        <td>所在部门</td>
        <td>${sessionScope.employmentInfo.department}</td>
    </tr>
    <tr>
        <td>岗位</td>
        <td>${sessionScope.employmentInfo.post}</td>
    </tr>
    <tr>
        <td>员工类型</td>
        <td>${sessionScope.employmentInfo.empType}</td>
    </tr>
    <tr>
        <td>入职时间</td>
        <td>${sessionScope.employmentInfo.empDate}</td>
    </tr>
    <tr>
        <td>工资</td>
        <td>${sessionScope.employmentInfo.salary}</td>
    </tr>
</table>

<a href="main.jsp" style="display:block;text-align:center;">返回</a>
</center>
</body>
</html>
