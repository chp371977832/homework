<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/20 0020
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>login</title>
</head>
<body>
<center style="padding-top: 10%;">
    <form action="empManagerServlet" method="post">
        <input type="hidden" name="method" value="login">

        <input type="text" style="border: 0px;color: crimson;" value="${sessionScope.msg}"><br>

        账号：<input type="text" name="account"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登陆"> <input type="reset" value="重置">
    </form>
</center>
</body>
</html>
