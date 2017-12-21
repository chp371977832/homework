<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/20 0020
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="#">首页</a>

    <c:if test="${sessionScope.login == null }">
        <a href="empManagerServlet?method=login">登录</a>
    </c:if>
    <c:if test="${sessionScope.login != null}">
        ${sessionScope.login.empAccount},你好！<a href="empManagerServlet?method=logout">注销</a>
    </c:if>
</body>
</html>
