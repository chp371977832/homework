<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/21 0021
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<center>
<body>
    <table align="center" border="1">
        <tr>
            <td>姓名</td>
            <td>${sessionScope.login.empName}</td>
        </tr>
        <tr>
            <td>账号</td>
            <td>${sessionScope.login.empAccount}</td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input style=" border: 0px;" type="password" value="${sessionScope.login.empPassword}"></td>
        </tr>
        <tr>
            <td>最近登录时间</td>
            <td>${sessionScope.login.lastLoginTime}</td>
        </tr>
    </table>
    <a href="main.jsp" style="display:block;text-align:center;">返回</a>
</center>
</body>

</html>
