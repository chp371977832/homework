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
            <td>身份证号</td>
            <td>${sessionScope.basicInfo.idNumber}</td>
        </tr>
        <tr>
            <td>手机号</td>
            <td>${sessionScope.basicInfo.phone}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${sessionScope.basicInfo.gender}</td>
        </tr>
        <tr>
            <td>生日</td>
            <td>${sessionScope.basicInfo.birthday}</td>
        </tr>
        <tr>
            <td>出生地</td>
            <td>${sessionScope.basicInfo.birthPlace}</td>
        </tr>
        <tr>
            <td>民族</td>
            <td>${sessionScope.basicInfo.nationality}</td>
        </tr>
        <tr>
            <td>学历</td>
            <td>${sessionScope.basicInfo.education}</td>
        </tr>
        <tr>
            <td>住址</td>
            <td>${sessionScope.basicInfo.address}</td>
        </tr>
    </table>

    <a href="main.jsp" style="display:block;text-align:center;">返回</a>
</center>
</body>
</html>
