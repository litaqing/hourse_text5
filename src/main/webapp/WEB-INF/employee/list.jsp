<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Author: Puhao
  Date: 2019/5/8 0008
  Brief:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="8" cellpadding="5" cellspacing="6" border="1">
    <tr>
        <td>id</td>
        <td>lastName</td>
        <td>email</td>
        <td>addr</td>
    </tr>
    <c:forEach items="${userList}" var="a">
        <tr>
            <td>${a.id}</td>
            <td>${a.lastName}</td>
            <td>${a.email}</td>
            <td>${a.addr}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

