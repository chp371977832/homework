<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<c:if test="${sessionScope.login == null }">
    <jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${sessionScope.login != null}">
    <jsp:forward page="main.jsp"></jsp:forward>
</c:if>

</body>
</html>
